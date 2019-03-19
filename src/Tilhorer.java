package src;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tilhorer extends DBConn {


    private PreparedStatement ps;
    private String Ovelse;
    private String gruppe;


    public Tilhorer(String Ovelse, String gruppe){
        this.Ovelse = Ovelse;
        this.gruppe = gruppe;

        kobleSammen();

    }

    public void kobleSammen(){
        connect();

        try{


            String query = "SELECT GruppeID FROM Ovelsesgruppe Where Beskrivelse ='" + this.gruppe + "';";
            PreparedStatement st2 = conn.prepareStatement(query);
            ResultSet sr = st2.executeQuery(query);


            String query2 = "SELECT ØvelseID FROM Øvelse Where Navn ='" + this.Ovelse + "';";
            PreparedStatement st3 = conn.prepareStatement(query2);
            ResultSet rs = st3.executeQuery(query2);



            int OID = 0;
            int GID = 0;
            while (rs.next()){
                OID = rs.getInt("ØvelseID");

            }

            while(sr.next()){
                GID = sr.getInt("GruppeID");

            }


            ps = conn.prepareStatement("INSERT INTO Tilhører(ØvelseID,GruppeID) VALUES ((?),(?))");

            ps.setInt(1, OID);
            ps.setInt(2,GID);

            ps.execute();
            conn.close();

        }catch (Exception e){
            System.out.println("Det skjedde en feil " + e);

        }

    }


    public static void main(String[] args){

        Tilhorer tilhorer = new Tilhorer("Knebøy","Bein");
    }






}
