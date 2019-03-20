package src;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ØvelserIGruppe extends DBConn{
	
	private String øvelsegruppe;
	private String øvelser = "Disse øvelsene tilhører den ønskede øvelsegruppen: ";
	
	public ØvelserIGruppe(String øvelsegruppe) {
		
		this.øvelsegruppe = øvelsegruppe;
		finnØvelser();
		
	}
	
	public void finnØvelser() {
		
		try {
			connect();
			
			String query = "SELECT GruppeID FROM Ovelsesgruppe WHERE Beskrivelse='" + this.øvelsegruppe + "';";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery(query);
			int grID = 0;
			
			while (rs.next()) {
				grID = rs.getInt("GruppeID");
			}
			
			String query2 = "SELECT ØvelseID FROM Tilhører WHERE GruppeID='" + grID + "';";
			PreparedStatement st2 = conn.prepareStatement(query2);
			ResultSet rs2 = st2.executeQuery(query2);
			
			while (rs2.next()) {
				int øvID = rs2.getInt("ØvelseID");
				String query3 = "SELECT Navn FROM Øvelse WHERE ØvelseID='" + øvID + "';";
				PreparedStatement st3 = conn.prepareStatement(query3);
				ResultSet rs3 = st3.executeQuery(query3);
				
				while (rs3.next()) {
					String navn = rs3.getString("Navn");
					this.øvelser += "" + navn + ", "; 
				}
			}
			
			conn.close();
			
		}
		catch (Exception e) {
			
		}
		System.out.println(this.øvelser);
	}
	
	public static void main(String[] args) {
		ØvelserIGruppe ø1 = new ØvelserIGruppe("Bein");
	}

}