
package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
   
    
    public static Yllapitaja etsiYllapitajaTunnuksilla(String kayttajatunnus, String salasana) throws Exception {
        String sql = "SELECT kayttajatunnus, salasana FROM Yllapitaja WHERE kayttajatunnus = ? AND salasana = ?";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        
        Yllapitaja kirjautunut = null;
        
        try {
            Tietokanta kanta = new Tietokanta();
            yhteys = kanta.getYhteys();
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
            
        } finally {
            tulokset.close();
            kysely.close();
            yhteys.close();
        }
        
        
        return kirjautunut;
    }
    
    public String toString() {
        return this.kayttajatunnus;
    }
    
}
