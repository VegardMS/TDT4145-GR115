

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Resultatlogg extends Connecting{
	private PreparedStatement ps;
	private ResultSet rs;
	private String result;
	
	public String hentResultatLogg() {
		
		String query = "SELECT * FROM OvelsePaApparat NATURAL JOIN ØvelseUtenApparat NATURAL JOIN Treningsøkt NATURAL JOIN InneholderØvelse";
		
		try {
			connect();
			ps = conn.prepareStatement(query);
			this.rs = ps.executeQuery(query);
			System.out.println(rs);
			while (rs.next()){
				int vekt = rs.getInt("AntallKilo");
				int sett = rs.getInt("AntallSett");
				System.out.println("hei");
				this.result += "hie"+ Integer.toString(vekt) + Integer.toString(sett);
			}
		}
	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.result;
	}
	
	public static void main(String[] args) {
		Resultatlogg rl = new Resultatlogg();
		rl.hentResultatLogg();
		System.out.println(rl.result);
		
	}

}
