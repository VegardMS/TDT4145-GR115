package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class Favorittovelser extends DBConn {

    private PreparedStatement ps;

    private int antall;

    public Favorittovelser(int antall) {

        this.antall = antall;
        getFavorittOvelser();

    }


    public void getFavorittOvelser() {
        connect();

        Collection<String> favoritter = new ArrayList<>();
        try{

            String query = "SELECT Navn,COUNT(TreningsøktID) FROM InneholderØvelse " +
                    "NATURAL JOIN Øvelse GROUP BY ØvelseID ORDER BY COUNT(TreningsøktID) ASC LIMIT " + this.antall;
            ps = conn.prepareStatement(query);

            ResultSet result = ps.executeQuery(query);

            while(result.next()){
                favoritter.add("" + result.getString("Navn"));
            }

            ps.execute();

            System.out.println(favoritter);



        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args){
        Favorittovelser favoritter = new Favorittovelser(3);
        
    }
}
