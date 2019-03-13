import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class Øvelsesgruppe extends Connecting{
    private PreparedStatement rs;
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
            rs = conn.prepareStatement("INSERT INTO Ovelsesgruppe(beskrivelse) VALUES ( (?))");
            rs.setString(1, this.beskrivelse);

            String duplicate = rs.getString("beskrivelse");

            if (beskrivelse == duplicate){
                return;
            }

            rs.execute();
        }
        catch (Exception e) {
            System.out.println("db error during prepare of insert into treningsokt"+e);
        }
    }





    public static void main(String[] args) {
        Øvelsesgruppe og = new Øvelsesgruppe("Bein");

    }

}
