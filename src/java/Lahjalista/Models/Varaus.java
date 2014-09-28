package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;


public class Varaus {
    private int lahjaId;
    private int varaajaId;
    private int maara;
    private Map<String, String> virheet = new HashMap<String, String>();
    
    public Varaus() {        
    }
    
    public void setLahjaId(int lahjaId) {
        this.lahjaId = lahjaId;
    }
    
    public int getLahjaId() {
        return this.lahjaId;
    }
    
    public void setVaraajaId(int varaajaId) {
        this.varaajaId = varaajaId;
    }
    
    public int getVaraajaId() {
        return this.varaajaId;
    }
    
    public void setMaara(int maara)  {
        this.maara = maara;
        if (maara < 1) {
            virheet.put("määrä", "Määrän pitää olla positiivinen luku");
        } else {
            virheet.remove("määrä");
        }
    }
    
    public void setMaara(String maara) {
        if (maara.trim().length() == 0) {
            setMaara(1);
        } else {
            try {
                setMaara(Integer.parseInt(maara));
            } catch (NumberFormatException e) {
                virheet.put("määrä", "Määrän pitää olla positiivinen luku.");
            }
        }
    }
    
    public int getMaara() {
        return this.maara;
    }
    
    public void lisaaKantaan() throws SQLException, NamingException {
        String sql = "INSERT INTO Varaus(lahja_id, varaaja_id, maara) VALUES(?,?,?)";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        
        Tietokanta kanta = new Tietokanta();
        yhteys = kanta.getYhteys();
        kysely = yhteys.prepareStatement(sql);

        kysely.setInt(1, this.getLahjaId());
        kysely.setInt(2, this.getVaraajaId());
        kysely.setInt(3, this.getMaara());

        kysely.executeUpdate();    
        
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

        

    }
    
    public void poistaKannasta() throws NamingException, SQLException {
        String sql = "DELETE FROM Varaus WHERE lahja_id = ? AND varaaja_id = ?";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        
        Tietokanta kanta = new Tietokanta();
        yhteys = kanta.getYhteys();
        kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, this.getLahjaId());
        kysely.setInt(2, this.getVaraajaId());

        kysely.executeUpdate();
        
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

    }
    
}
