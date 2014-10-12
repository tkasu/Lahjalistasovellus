package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;


public class Varaus {
    private int lahjaId;
    private String lahjaNimi;
    private int varaajaId;
    private String varaajaNimi;
    private String varaajaEmail;
    private int maara;
    private Map<String, String> virheet = new HashMap<String, String>();
    
    public Varaus() {        
    }
    
    public void setLahjaId(int lahjaId) {
        this.lahjaId = lahjaId;
    }
    
    public void setLahjaNimi(String nimi) {
        this.lahjaNimi = nimi;
    }
    
    public int getLahjaId() {
        return this.lahjaId;
    }
    
    public String getLahjaNimi() {
        return this.lahjaNimi;
    }
    
    public void setVaraajaId(int varaajaId) {
        this.varaajaId = varaajaId;
    }
    
    public void setVaraajaNimi(String nimi) {
        this.varaajaNimi = nimi;
    }
    
    public void setVaraajaEmail(String email) {
        this.varaajaEmail = email;
    }
    
    public int getVaraajaId() {
        return this.varaajaId;
    }
    
    public String getVaraajaNimi() {
        return this.varaajaNimi;
    }
    
    public String getVaraajaEmail() {
        return this.varaajaEmail;
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
    
    public void paivitaKantaan(int vanhaLahjaId, int vanhaVaraajaId) throws SQLException, NamingException {
        String sql = "UPDATE Varaus SET lahja_id = ?, varaaja_id = ? WHERE lahja_id = ? AND varaaja_id = ?";
        Connection yhteys = null;
        PreparedStatement kysely = null;

        yhteys = Tietokanta.getYhteys();
        kysely = yhteys.prepareStatement(sql);

        kysely.setInt(1, this.getLahjaId());
        kysely.setInt(2, this.getVaraajaId());
        kysely.setInt(3, vanhaLahjaId);
        kysely.setInt(4, vanhaVaraajaId);

        kysely.executeUpdate();
        
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}
    }
    
    public void poistaKannasta() throws NamingException, SQLException {
        String sql = "DELETE FROM Varaus WHERE lahja_id = ? AND varaaja_id = ?";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        
        yhteys = Tietokanta.getYhteys();
        kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, this.getLahjaId());
        kysely.setInt(2, this.getVaraajaId());

        kysely.executeUpdate();
        
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

    }
    
    
    public static Varaus etsi(int lahjaId, int varaajaId) {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Varaus loydetty = null;
        
        try {
            yhteys = Tietokanta.getYhteys();


            String sql = "SELECT * FROM Varaus WHERE lahja_id = ? AND varaaja_id = ?";
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, lahjaId);
            kysely.setInt(2, varaajaId);

            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                loydetty = new Varaus();

                loydetty.setLahjaId(tulokset.getInt("lahja_id"));
                loydetty.setVaraajaId(tulokset.getInt("varaaja_id"));
                          
            }
                
        } catch (Exception e) {
            
        }
        
        try { tulokset.close(); } catch (Exception e1) {}
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

        
        return loydetty;
    }
    
    public static List<Varaus> etsiLahjalla(int lahjaId) {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        ArrayList<Varaus> loydetyt = new ArrayList<Varaus>();
        
        try {
            yhteys = Tietokanta.getYhteys();


            String sql = "SELECT * FROM Varaus WHERE lahja_id = ?";
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, lahjaId);

            tulokset = kysely.executeQuery();

            while (tulokset.next()) {
                Varaus loydetty = new Varaus();

                loydetty.setLahjaId(tulokset.getInt("lahja_id"));
                loydetty.setVaraajaId(tulokset.getInt("varaaja_id"));
                 
                loydetyt.add(loydetty);
            }
                
        } catch (Exception e) {
            
        }
        
        try { tulokset.close(); } catch (Exception e1) {}
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

        
        return loydetyt;
    }
    
    
    public static List<Varaus> getVaraukset(String hakuehto) {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        ArrayList<Varaus> varaukset = new ArrayList<Varaus>();
        
        try {
            yhteys = Tietokanta.getYhteys();

            String sql = "SELECT lahja_id, varaaja_id, maara FROM VARAUS INNER JOIN LAHJAEHDOTUS ON Varaus.lahja_id = Lahjaehdotus.id INNER JOIN VIERAS ON Varaus.varaaja_id = Vieras.id WHERE LOWER(Lahjaehdotus.nimi) LIKE LOWER(?) OR LOWER(Vieras.nimi) LIKE LOWER(?) ORDER BY Vieras.nimi";
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, "%" + hakuehto + "%");
            kysely.setString(2, "%" + hakuehto + "%");

            tulokset = kysely.executeQuery();

            while (tulokset.next()) {

                Varaus varaus = new Varaus();
                
                int lahjaId = tulokset.getInt("lahja_id");
                varaus.setLahjaId(lahjaId);
                varaus.setLahjaNimi(Lahjaehdotus.etsi(lahjaId).getNimi()); // etsii lahjaId:n perusteella lahjan nimen
          
                int varaajaId = tulokset.getInt("varaaja_id");
                varaus.setVaraajaId(varaajaId);
                Vieras varaaja = Vieras.etsi(varaajaId);
                varaus.setVaraajaNimi(varaaja.getNimi());
                varaus.setVaraajaEmail(varaaja.getEmail());
                
                varaukset.add(varaus);
            }
            
        } catch (Exception e) {
            
        } finally {

            try { tulokset.close(); } catch (Exception e1) {}
            try { kysely.close(); } catch (Exception e2) {}
            try { yhteys.close(); } catch (Exception e3) {}
            
        }

        return varaukset;
    }
    
}
