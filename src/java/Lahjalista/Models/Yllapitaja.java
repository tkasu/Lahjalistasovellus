
package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

public class Yllapitaja {
    private String kayttajatunnus;
    private String salasana;
    
    public Yllapitaja() {
    }
    
    protected void setUsername(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }
    
    public String getUsername() {
        return this.kayttajatunnus;
    }
    
    protected void setPassword(String salasana) {
        this.salasana = salasana;
    } 
   
    
    public static Yllapitaja etsiYllapitajaTunnuksilla(String kayttajatunnus, String salasana) throws SQLException, NamingException {
        String sql = "SELECT kayttajatunnus, salasana FROM Yllapitaja WHERE kayttajatunnus = ? AND salasana = ?";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        
        Yllapitaja kirjautunut = null;
        

        yhteys = Tietokanta.getYhteys();
        kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttajatunnus);
        kysely.setString(2, salasana);
        tulokset = kysely.executeQuery();

        if (tulokset.next()) {
            kirjautunut = new Yllapitaja();
            String tempTunnus = tulokset.getString("kayttajatunnus");
            String tempSalasana = tulokset.getString("salasana");
            kirjautunut.setUsername(tempTunnus);
            kirjautunut.setPassword(tempSalasana);
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

        
            
        
        
        return kirjautunut;
    }
    
    @Override
    public String toString() {
        return this.kayttajatunnus;
    }
    
}
