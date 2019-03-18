import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tilhører extends DBConn {


    private PreparedStatement ps;
    private String øvelse;
    private String gruppe;


    public Tilhører(String øvelse, String gruppe){
        this.øvelse = øvelse;
        this.gruppe = gruppe;

        kobleSammen();

    }

    public void kobleSammen(){
        connect();

        try{


            String query = "SELECT GruppeID FROM Ovelsesgruppe Where Beskrivelse ='" + this.gruppe + "';";
            PreparedStatement st2 = conn.prepareStatement(query);
            ResultSet sr = st2.executeQuery(query);


            String query2 = "SELECT ØvelseID FROM Øvelse Where Navn ='" + this.øvelse + "';";
            PreparedStatement st3 = conn.prepareStatement(query2);
            ResultSet rs = st3.executeQuery(query2);



            int ØID = 0;
            int GID = 0;
            while (rs.next()){
                ØID = rs.getInt("ØvelseID");

            }

            while(sr.next()){
                GID = sr.getInt("GruppeID");

            }


            ps = conn.prepareStatement("INSERT INTO Tilhører(ØvelseID,GruppeID) VALUES ((?),(?))");

            ps.setInt(1, ØID);
            ps.setInt(2,GID);

            ps.execute();
            conn.close();

        }catch (Exception e){
            System.out.println("Det skjedde en feil " + e);

        }

    }


    public static void main(String[] args){

        Tilhører tilhører = new Tilhører("Knebøy","Bein");
    }






}
