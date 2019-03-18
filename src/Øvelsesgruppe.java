
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Øvelsesgruppe extends DBConn {
    private PreparedStatement ps;
    private String beskrivelse;
    private String øvelseNavn;
    private int id;
    private PreparedStatement pre;





    public Øvelsesgruppe(String beskrivelse) {

        this.beskrivelse = beskrivelse;

        registrerGruppe();
    }
    public void registrerGruppe() {

        connect();

        String query = "SELECT * FROM Ovelsesgruppe WHERE Beskrivelse=(?)" ; //WHERE beskrivelse=(?)
        try {
            ps = conn.prepareStatement("INSERT INTO Ovelsesgruppe (Beskrivelse) VALUES (?)");
            ps.setString(1, this.beskrivelse);


            String query2 = "SELECT * FROM Ovelsesgruppe Where Beskrivelse ='" + this.beskrivelse + "';";
            PreparedStatement st3 = conn.prepareStatement(query2);
            ResultSet rs = st3.executeQuery(query2);
            String duplicate = " ";

            while(rs.next()){
                duplicate = rs.getString("Beskrivelse");
            }

            if (beskrivelse == duplicate){
                return;
            }

            ps.execute();


        }
        catch (Exception e) {
            System.out.println("db error during prepare of insert into treningsokt " + e);
        }
    }






    public static void main(String[] args) {
        Øvelsesgruppe og = new Øvelsesgruppe("tut og kjør");

    }

}
