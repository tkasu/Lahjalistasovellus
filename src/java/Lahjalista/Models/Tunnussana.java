

package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

public class Tunnussana {


    
    public Tunnussana() {
        
    }
    
    public static boolean oikeaTunnussana(String tunnussana) throws SQLException, NamingException {
        String sql = "SELECT * FROM Tunnussana WHERE sana = ?";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        
        yhteys = Tietokanta.getYhteys();
        kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnussana);
        tulokset = kysely.executeQuery();
        
        boolean loytyiko = false;
        
        if (tulokset.next()) {
            loytyiko = true;
        }
        
        if (tulokset != null) {
            try { tulokset.close(); } catch (Exception e1) {}
            tulokset = null;
        }
        if (kysely != null) {
            try { kysely.close(); } catch (Exception e1) {}
            kysely = null;
        }
        if (yhteys != null) {
            try { yhteys.close(); } catch (Exception e1) {}
            yhteys = null;
        }
        
        return loytyiko;
    }
    
}
