package src;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat; 

public class Resultatlogg extends DBConn{
	private PreparedStatement ps;
	private ResultSet rs;
	private String result = "";
	private String øvelse;
	private Date fraDato;
	private Date tilDato;
	private char apparat;
	
	public Resultatlogg(String øvelse, Date fraDato, Date tilDato, char apparat) {
		this.øvelse = øvelse;
		this.fraDato = fraDato;
		this.tilDato = tilDato;
		this.apparat = apparat;
		
		if (apparat == 'y') {
			hentResultatMedApparat();
		}
		
		else if (apparat == 'n') {
			hentResultatUtenApparat();
		}
		
		else {
			throw new IllegalArgumentException("y for ja, n for nei");
		}
	}
	
	public String hentResultatMedApparat() {
		String fra = fraDato.toString();
		String til = tilDato.toString();
		
		String query = "SELECT * FROM (Øvelse NATURAL JOIN ØvelsePåApparat "
				+ " NATURAL JOIN Treningsøkt "
				+ " NATURAL JOIN InneholderØvelse) "
				+ "WHERE (Dato BETWEEN " + this.fraDato + " AND " + this.tilDato + ")"
				+ " AND Navn ='" + this.øvelse + "';"; 
		String periode = "Resultater for " + "'" + this.øvelse + "'" + " i perioden fra " + this.fraDato + " til " + this.tilDato + ":";
		System.out.println(periode);
		try {
			connect();
			ps = conn.prepareStatement(query);
			//ps.setString(1, this.øvelse);
			this.rs = ps.executeQuery(query);
			while (rs.next()){
				//ps.setString(1, this.øvelse);
				int vekt = rs.getInt("AntallKilo");
				int sett = rs.getInt("AntallSett");
				int økt = rs.getInt("TreningsøktID");
				
				this.result = "\n" + "Økt:" + Integer.toString(økt) + " Antall kilo:" + Integer.toString(vekt) +  " Antall sett:" + Integer.toString(sett) + "\n";
				//System.out.println(result);
			}
		}
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return this.result;
	}
	
	public String hentResultatUtenApparat() {
		String periode = "Resultater for " + "'" + this.øvelse + "'" + " i perioden fra " + this.fraDato + " til " + this.tilDato + ":";
		String query = "SELECT * FROM (Øvelse INNER JOIN ØvelseUtenApparat ON (Øvelse.ØvelseID = ØvelseUtenApparat.ØvelseID3))"
				+ "NATURAL JOIN Treningsøkt "
				+ "NATURAL JOIN InneholderØvelse) "
				+ "WHERE Navn ='" + this.øvelse + "';"; 
		connect();
		try {
			ps = conn.prepareStatement(query);
			this.rs = ps.executeQuery(query);
			
			while (rs.next()) {
				String beskrivelse = rs.getString("Beskrivelse");
				int økt = rs.getInt("TreningsøktID");
				
				this.result = "\n" + "Økt:" + Integer.toString(økt) + "Beskrivelse: " + beskrivelse;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return this.result;
	}
	
	public String getDate() {
		return this.fraDato.toString();
	}
	
	public static void main(String[] args) {
		Date fra = new Date(2017, 1, 1);
		Date til = new Date (2019, 3, 14);
		Resultatlogg rl = new Resultatlogg("Situp", fra, til,'y');
		
	}
}
