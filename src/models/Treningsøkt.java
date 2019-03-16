

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

public class Treningsøkt extends Connecting{
	private PreparedStatement rs;
	private int personligForm;
	private int prestasjon;
	private String notat;
	private Date dato;
	private Time tid;
	private int varighet;
	
	
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
		Date d = new Date (2018, 04, 11);
		System.out.println(d);
		Time t = new Time(15,12,00);
		Treningsøkt t4 = new Treningsøkt(d, t, 60, 8, 10, "ok!!");
		
	}

}
