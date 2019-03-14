import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Tilhører extends Connecting {


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
            String gruppeID = "SELECT GruppeID FROM Ovelsesgruppe WHERE Beskrivelse ='" + this.gruppe +"';";

            PreparedStatement gr = conn.prepareStatement(gruppeID);

            ResultSet sr = gr.executeQuery(gruppeID);


            String øvelseID = "SELECT ØvelseID FROM Øvelse WHERE Navn ='" + this.øvelse +"';";


            PreparedStatement or = conn.prepareStatement(øvelseID);



            ResultSet rs = or.executeQuery(øvelseID);
            int ØvelseID = 0;
            int GruppeID = 0;



            while (rs.next()){
                ØvelseID = rs.getInt("ØvelsesID");
            }

            while (sr.next()){
                GruppeID = sr.getInt("GruppeID");
            }


            System.out.println(ØvelseID);
            System.out.println(GruppeID);
            System.out.println("hola");




            ps = conn.prepareStatement("INSERT INTO tilhører(ØvelsesID,ØvelsesgruppeID) VALUES ((?),(?))");

            ps.setInt(1, ØvelseID);
            ps.setInt(2,GruppeID);

            ps.execute();
            conn.close();

        }catch (Exception e){
            System.out.println("Det skjedde en feil");

        }

    }


    public static void main(String[] args){

        Tilhører tilhører = new Tilhører("Knebøy","Bein");
    }






}
