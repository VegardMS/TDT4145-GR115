package src;
import java.sql.PreparedStatement;

public class Apparat extends DBConn {
	private PreparedStatement rs;
	private String navn;
	private String funksjon;
	
	public Apparat(String navn, String funksjon) {
		this.navn = navn;
		this.funksjon = funksjon;
		registrerApparat();
	}
	
	public void registrerApparat() {
		connect();
		try {
			rs = conn.prepareStatement("INSERT INTO Apparat (Navn, Funksjon) VALUES ((?), (?))");
			
			rs.setString(1, this.navn);
			rs.setString(2, this.funksjon);
			rs.execute();
			
			conn.close();
			
		} catch (Exception e) { 
            System.out.println("db error during prepare of insert into Apparat"+e);
        }
	}
	
	public static void main(String[] args) {
		Apparat a1 = new Apparat("Romaskin", "Ro");
		
	}

}
