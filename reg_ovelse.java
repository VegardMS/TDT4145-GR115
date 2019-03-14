package database_treningdagbok;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class reg_ovelse extends DBConn{
	
	private String name;
	private PreparedStatement st;
	private char apparat;
	private int kilo;
	private int sett;
	private String beskrivelse;
	
	public reg_ovelse(String name, int kilo, int sett) {
		this.name = name;
		this.apparat = 'y';
		this.kilo = kilo;
		this.sett = sett;

		this.registrer();
	}
	
	public reg_ovelse(String name, String beskrivelse) {
		this.name = name;
		this.apparat = 'n';
		this.beskrivelse = beskrivelse;

		this.registrer();
	}
	
	public void registrer() {
		connect();
		try {
			String query = "INSERT INTO Øvelse (Navn) VALUES ((?))";
			this.st = conn.prepareStatement(query);
			this.st.setString(1, this.name);
			this.st.execute();
			
			if (this.apparat == 'y') {
				String query2 = "INSERT INTO OvelsePaApparat (AntallKilo, AntallSett) VALUES ((?), (?))";
				this.st = conn.prepareStatement(query2);
				this.st.setInt(1, this.kilo);
				this.st.setInt(2, this.sett);
				this.st.execute();
			}
			
			else if (this.apparat == 'n') {
				String query3 = "INSERT INTO ØvelseUtenApparat (Beskrivelse) VALUES ((?))";
				this.st = conn.prepareStatement(query3);
				this.st.setString(1, this.beskrivelse);
				this.st.execute();
			}
			
			conn.close();
		}
		catch (SQLException e) {
			
		}
	}
	
	public static void main(String[] args) {
		reg_ovelse r1 = new reg_ovelse("Situp", "Fyfaen så hurtig");
		reg_ovelse r2 = new reg_ovelse("Knebøy", 30, 3);
		
	}
}