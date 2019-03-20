package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ovelse extends DBConn{
	
	private String name;
	private PreparedStatement st;
	private char apparat;
	private int kilo;
	private int sett;
	private String beskrivelse;
	
	
	public Ovelse(String name, int kilo, int sett) {
		this.name = name;
		this.apparat = 'y';
		this.kilo = kilo;
		this.sett = sett;

		this.registrer();
	}
	
	public Ovelse(String name, String beskrivelse) {
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
			int OvelseID = 0;
			String query4 = "SELECT ØvelseID FROM Øvelse Where Navn ='" + this.name + "';";
			PreparedStatement st2 = conn.prepareStatement(query4);
			ResultSet rs = st2.executeQuery(query4);
			while (rs.next()) {
				OvelseID = rs.getInt("ØvelseID");
			}
		
			if (this.apparat == 'y') {

				String query2 = "INSERT INTO OvelsePaApparat (ØvelseID, AntallKilo, AntallSett) VALUES ((?), (?), (?))";
				this.st = conn.prepareStatement(query2);
				this.st.setInt(1, OvelseID);
				this.st.setInt(2, this.kilo);
				this.st.setInt(3, this.sett);
				this.st.execute();
				
			}
			
			else {
	
				String query3 = "INSERT INTO ØvelseUtenApparat (ØvelseID, Beskrivelse) VALUES ((?), (?))";
				this.st = conn.prepareStatement(query3);
				this.st.setInt(1, OvelseID);
				this.st.setString(2, this.beskrivelse);
				this.st.execute();
				
			}
			
			conn.close();
			
			
		}
		catch (SQLException e) {
			
		}
	}
	
	public static void main(String[] args) {
		Ovelse r1 = new Ovelse("Pushups", "Fyfaen så hurtig");
		//reg_ovelse r2 = new reg_ovelse("Knebøy", 30, 3);
		
		
	}
}