package src;

import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;

public abstract class DBConn {
    protected Connection conn;
    public DBConn() {
    }

    public void connect() {
        try {

            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Properties p = new Properties();
            p.put("user", "ikvassil_demo");
            p.put("password", "1234");
            conn = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/ikvassil_treningsdagbok?autoReconnect=true&useSSL=false",p);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to connect", e);
        }
    }
}

