package src;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

public class hentØkter extends DBConn{
	
	private String sqlresult = "";
	
	public hentØkter(int number) {
		try {
			connect();
			
			int treningsøktID = 0;
			String query2 = "SELECT MAX(TreningsøktID) FROM Treningsøkt";
			PreparedStatement st2 = conn.prepareStatement(query2);
			ResultSet rs2 = st2.executeQuery(query2);
			while (rs2.next()) {
				treningsøktID = rs2.getInt("MAX(TreningsøktID)");
			}
			
			
			String query = "SELECT * FROM Treningsøkt WHERE TreningsøktID>" + (treningsøktID - number) + ";";
			PreparedStatement st = conn.prepareStatement(query);
			//st.setInt(1,number);
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt("TreningsøktID");
		        Date dato = rs.getDate("Dato");
		        Time tid = rs.getTime("Tid");
		        int varighet = rs.getInt("Varighet");
		        int pf = rs.getInt("PersonligForm");
		        int prestasjon = rs.getInt("Prestasjon");
		        String notat = rs.getString("Notat");
		        this.sqlresult += "ID:"+id + ". Dato: " + dato + ". Tid: " + tid + ". Varighet: " + varighet +". Personlig form: "+ pf +". Prestasjon: "+ prestasjon +". "+". Notat: " + notat +"\n";
			}
			st.close();
		}
		catch (Exception e) {
			
		}
		System.out.println(this.sqlresult);
	}

}