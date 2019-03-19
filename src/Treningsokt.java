package src;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

public class Treningsokt extends DBConn {
	private PreparedStatement rs;
	private int personligForm;
	private int prestasjon;
	private String notat;
	private LocalDate dato;
	private Time tid;
	private int varighet;
	private PreparedStatement prep;


	public Treningsokt(LocalDate dato, Time tid, int varighet, int personligForm, int prestasjon,String notat) {
		this.dato = dato;
		this.tid = tid;
		this.varighet = varighet;
		this.personligForm = personligForm;
		this.prestasjon = prestasjon;
		this.notat = notat;
		registrerOkt();
	}

	public void registrerOkt() {
		connect();
		try {
			rs = conn.prepareStatement("INSERT INTO Treningsøkt (Dato, Tid, Varighet, PersonligForm, Prestasjon, Notat) VALUES ((?), (?), (?), (?), (?), (?))");

			rs.setDate(1, Date.valueOf(this.dato));
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

	public void leggTilOvelse(String Ovelse) {

		connect();

		try {

			String query = "SELECT TreningsØktID FROM Treningsøkt Where Dato ='" + this.dato + "And Tid =" + this.tid +"';";
			PreparedStatement st2 = conn.prepareStatement(query);
			ResultSet res = st2.executeQuery(query);

			Integer OktID = null;
			Integer OvelseID = null;


			String query2 = "SELECT ØvelseID FROM Øvelse Where Navn ='" + Ovelse + "';";
			PreparedStatement st3 = conn.prepareStatement(query2);
			ResultSet pes = st3.executeQuery(query2);

			while(res.next()){
				OktID = res.getInt("TreningsØktID");
			}

			while(pes.next()){
				OvelseID = pes.getInt("ØvelseID");
			}

			if(OktID.equals(null)|| OvelseID.equals(null)){
				throw new IllegalArgumentException("Du må registrere Øvelsen først!");
			}
			System.out.println(OktID);
			System.out.println(OvelseID);

			prep = conn.prepareStatement("INSERT INTO InneholderØvelse(TreningsØktID,ØvelseID) VALUES ((?),(?))");
			prep.setInt(1,OktID);
			prep.setInt(2,OvelseID);

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
		LocalDate d = LocalDate.of(2028,03,19);
		System.out.println(d);
		Time t = new Time(8,42,00);
		Treningsokt t4 = new Treningsokt(d, t, 55, 9, 9, "Fikk gnagsår");
		t4.leggTilOvelse("Knebøy");


	}

}
