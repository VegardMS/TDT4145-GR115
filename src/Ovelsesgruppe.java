package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ovelsesgruppe extends DBConn {
    private PreparedStatement ps;
    private String beskrivelse;
    private String OvelseNavn;
    private int id;
    private PreparedStatement pre;


    public Ovelsesgruppe(String beskrivelse) {

        this.beskrivelse = beskrivelse;

        registrerGruppe();
    }
    public void registrerGruppe() {

        connect();

        String query = "SELECT * FROM Øvelsesgruppe WHERE Beskrivelse=(?)" ; //WHERE beskrivelse=(?)
        try {
            ps = conn.prepareStatement("INSERT INTO Øvelsesgruppe (Beskrivelse) VALUES (?)");
            ps.setString(1, this.beskrivelse);


            String query2 = "SELECT * FROM Øvelsesgruppe Where Beskrivelse ='" + this.beskrivelse + "';";
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
            System.out.println("db error during prepare of insert into treningsøkt " + e);
        }
    }



    public static void main(String[] args) {
        Ovelsesgruppe og = new Ovelsesgruppe("tut og kjør");

    }

}
