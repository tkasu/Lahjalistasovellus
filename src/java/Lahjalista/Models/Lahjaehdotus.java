
package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;


public class Lahjaehdotus {
    private int id;
    private String nimi;
    private double hinta;
    private String ostoOsoite;
    private String lisaaja;
    private int maxVaraukset;
    private Map<String, String> virheet = new HashMap<String, String>();
    
    public Lahjaehdotus() {
        
    }
    
    public void setId(int uusiId) {
        this.id = uusiId;
    } 
    
    public int getId() {
        return this.id;
    }
    
    public void setNimi(String uusiNimi) {
        this.nimi = uusiNimi;
        
        if (uusiNimi.trim().length() == 0) {
            virheet.put("nimi", "Nimi ei saa olla tyhjä.");
        } else {
            virheet.remove("nimi");
        }
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public void setHinta(double uusiHinta) {
        this.hinta = uusiHinta;
        
        if (uusiHinta < 0) {
            virheet.put("hinta", "Hinta ei voi olla negatiivinen.");
        } else {
            virheet.remove("pituus");
        }
    }
    
    
    public void setHinta(String uusiHinta) {
        uusiHinta = uusiHinta.replace(',', '.');
        try {
            setHinta(Double.parseDouble(uusiHinta));
        } catch (NumberFormatException e) {
            virheet.put("hinta", "Hinnan pitää olla luku.");
        }
    }
    
    public double getHinta() {
        return this.hinta;
    }
    
    public void setOsoite(String url) {
        this.ostoOsoite = url;
    }
    
    public String getOsoite() {
        return this.ostoOsoite;
    }
    
    
    public void setLisaaja(String kayttajatunnus) {
        this.lisaaja = kayttajatunnus;
    }
    
    public String getLisaaja() {
        return this.lisaaja;
    }
    
    public void setMaxVaraukset(int uusiMax) {
        this.maxVaraukset = uusiMax;
        
        if (uusiMax < 0) {
            virheet.put("maxVaraukset", "Varausten maksimimäärä ei voi olla negatiivinen.");
        } else {
            virheet.remove("maxVaraukset");
        }
    }
    
    public void setMaxVaraukset(String uusiMax) {
        if (uusiMax.trim().length() == 0) {
            virheet.put("maxVaraukset", "Varausten määrä ei saa olla tyhjä.");
        } else {
            virheet.remove("maxVaraukset");
            try {
                setMaxVaraukset(Integer.parseInt(uusiMax));
            } catch (NumberFormatException e){
                virheet.put("maxVaraukset", "Varausten määrän pitää olla kokonaisluku.");
            }
        }
    }
    
    public int getMaxVaraukset() {
        return this.maxVaraukset;
    }
    
    
    @Override
    public String toString() {
        return "id: " + getId() + " nimi: " + getNimi() + " hinta: " + getHinta() + " osto-soite: " + getOsoite() + " lisaaja: " + getLisaaja() + " max varaukset: " + getMaxVaraukset();
    }
    
    public void lisaaKantaan() throws NamingException, SQLException {
        String sql = "INSERT INTO Lahjaehdotus(nimi, hinta, ostoOsoite, lisaaja, maxVaraukset) VALUES(?,?,?,?,?) RETURNING id";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        
        try {
            Tietokanta kanta = new Tietokanta();
            yhteys = kanta.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, this.getNimi());
            kysely.setDouble(2, this.getHinta());
            kysely.setString(3, this.getOsoite());
            kysely.setString(4, this.getLisaaja());
            kysely.setInt(5, this.getMaxVaraukset());
            
            tulokset = kysely.executeQuery();
            tulokset.next();
            
            this.setId(tulokset.getInt(1));
            
        //try { tulokset.close(); } catch (Exception e) {}
        //try { kysely.close(); } catch (Exception e) {}
        //try { yhteys.close(); } catch (Exception e) {}
        
        } finally {
            tulokset.close();
            kysely.close();
            yhteys.close();
        }  
    }
    
    public static List<Lahjaehdotus> getKaikkiLahjat() throws Exception{
            Connection yhteys = null;
            PreparedStatement kysely = null;
            ResultSet tulokset = null;
            ArrayList<Lahjaehdotus> lahjat = new ArrayList<Lahjaehdotus>();
        
            try {
                Tietokanta kanta = new Tietokanta();
                yhteys = kanta.getYhteys();
                

                String sql = "SELECT * from Lahjaehdotus";
                kysely = yhteys.prepareStatement(sql);
                tulokset = kysely.executeQuery();

                lahjat = new ArrayList<Lahjaehdotus>();

                while(tulokset.next()) {
                        //private int it;
                        //private String nimi;
                        //private double hinta;
                        //private String ostoOsoite;
                        //private int lisaaja;
                        //private int maxVaraukset;

                    Lahjaehdotus l = new Lahjaehdotus();
                    
                    l.setId(tulokset.getInt("id"));
                    l.setNimi(tulokset.getString("nimi"));
                    l.setHinta(tulokset.getDouble("hinta"));
                    l.setOsoite(tulokset.getString("ostoOsoite"));
                    l.setLisaaja(tulokset.getString("lisaaja"));
                    l.setMaxVaraukset(tulokset.getInt("maxVaraukset"));
                    
                    lahjat.add(l);
                }
            } finally {
                tulokset.close();
                kysely.close();
                yhteys.close();
            }
            
            return lahjat;
    }
}
