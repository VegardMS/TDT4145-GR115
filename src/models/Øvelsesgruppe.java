import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Øvelsesgruppe extends Connecting{
    private PreparedStatement ps;
    private String beskrivelse;
    private String øvelseNavn;





    public Øvelsesgruppe(String beskrivelse) {

        this.beskrivelse = beskrivelse;

        registrerGruppe();
    }
    public void registrerGruppe() {
        connect();

        String query = "SELECT * FROM Ovelsesgruppe WHERE beskrivelse=(?)" ;
        try {
            ps = conn.prepareStatement("INSERT INTO Ovelsesgruppe(beskrivelse) VALUES ( (?))");
            ps.setString(1, this.beskrivelse);


            ResultSet rs = ps.executeQuery(query);
            String duplicate = rs.getString("beskrivelse");

            if (beskrivelse == duplicate) {
                return;
            }

            ps.execute();
        }
        catch (Exception e) {
            System.out.println("db error during prepare of insert into treningsokt"+e);
        }
    }





    public static void main(String[] args) {
        Øvelsesgruppe og = new Øvelsesgruppe("kondisjon");

    }

}
