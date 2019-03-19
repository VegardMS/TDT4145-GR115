package src;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

public class Treningsøkt extends DBConn {
	private PreparedStatement rs;
	private int personligForm;
	private int prestasjon;
	private String notat;
	private Date dato;
	private Time tid;
	private int varighet;
	private PreparedStatement prep;


	public Treningsøkt(Date dato, Time tid, int varighet, int personligForm, int prestasjon,String notat) {
		this.dato = dato;
		this.tid = tid;
		this.varighet = varighet;
		this.personligForm = personligForm;
		this.prestasjon = prestasjon;
		this.notat = notat;
		registrerØkt();
	}

	public void registrerØkt() {
		connect();
		try {
			rs = conn.prepareStatement("INSERT INTO Treningsøkt (Dato, Tid, Varighet, PersonligForm, Prestasjon, Notat) VALUES ((?), (?), (?), (?), (?), (?))");

			rs.setDate(1, this.dato);
			rs.setTime(2, this.tid);
			rs.setInt(3, this.varighet);
			rs.setInt(4, this.personligForm);
			rs.setInt(5, this.prestasjon);
			rs.setString(6, this.notat);
			rs.execute();
		}
		catch (Exception e) {
			System.out.println("db error during prepare of insert into treningsøkt"+e);
		}
	}

	public void leggTilØvelse(String øvelse) {

		connect();

		try {

			String query = "SELECT TreningsøktID FROM Treningsøkt Where Dato ='" + this.dato + "And Tid =" + this.tid +"';";
			PreparedStatement st2 = conn.prepareStatement(query);
			ResultSet res = st2.executeQuery(query);

			Integer ØktID = null;
			Integer ØvelseID = null;


			String query2 = "SELECT ØvelseID FROM Øvelse Where Navn ='" + øvelse + "';";
			PreparedStatement st3 = conn.prepareStatement(query2);
			ResultSet pes = st3.executeQuery(query2);

			while(res.next()){
				ØktID = res.getInt("TreningsøktID");
			}

			while(pes.next()){
				ØvelseID = pes.getInt("ØvelseID");
			}

			if(ØktID.equals(null)|| ØvelseID.equals(null)){
				throw new IllegalArgumentException("Du må registrere øvelsen først!");
			}
			System.out.println(ØktID);
			System.out.println(ØvelseID);

			prep = conn.prepareStatement("INSERT INTO InneholderØvelse(TreningsøktID,ØvelseID) VALUES ((?),(?))");
			prep.setInt(1,ØktID);
			prep.setInt(2,ØvelseID);

			prep.execute();


		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public int getPersonligForm() {
		return personligForm;
	}

	public void setPersonligForm(int personligForm) {
		this.personligForm = personligForm;
	}

	public int getPrestasjon() {
		return prestasjon;
	}

	public void setPrestasjon(int prestasjon) {
		this.prestasjon = prestasjon;
	}

	public String getNotat() {
		return notat;
	}

	public void setNotat(String notat) {
		this.notat = notat;
	}

	public static void main(String[] args) {
		Date d = new Date (2028,03,19);
		System.out.println(d);
		Time t = new Time(8,42,00);
		Treningsøkt t4 = new Treningsøkt(d, t, 55, 9, 9, "Fikk gnagsår");
		t4.leggTilØvelse("Knebøy");


	}

}
