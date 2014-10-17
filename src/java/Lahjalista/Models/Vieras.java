package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class Vieras {
    private int id;
    private String nimi;
    private String email;
    private String puhNro;
    private Map<String, String> virheet = new HashMap<String, String>();
    
    public Vieras() {
    }
    
    public void setId(int uusiId) {
        this.id = uusiId;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setNimi(String uusiNimi) {
        
        uusiNimi = uusiNimi.replace('<', ' ');
        uusiNimi = uusiNimi.replace('>', ' ');
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
    
    public void setEmail(String uusiEmail) {
        
        uusiEmail = uusiEmail.replace('<', ' ');
        uusiEmail = uusiEmail.replace('>', ' ');
        this.email = uusiEmail;
        
        Vieras vastaava = etsiEmaililla(uusiEmail);
        
        if (uusiEmail.trim().length() == 0) {
            virheet.put("email", "Email ei saa olla tyhjä.");
        } else if (vastaava != null && vastaava.getId() != this.getId()) {
            virheet.put("email", "Email löytyy jo tietokannasta!");
        } else {
            virheet.remove("email");
        }
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setPuhNro(String uusiPuhNro) {
        this.puhNro = uusiPuhNro;
    }
    
    public String getPuhNro() {
        return this.puhNro;
    }
    
    public boolean onkoKelvollinen() {
        return this.virheet.isEmpty();
    }
    
    public Collection<String> getVirheet() {
        return virheet.values();
    } 
    
    
    public void lisaaKantaan() {
        String sql = "INSERT INTO Vieras(nimi, email, puhnro) VALUES(?,?,?) RETURNING id";
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        
        try {
            yhteys = Tietokanta.getYhteys();
            kysely = yhteys.prepareStatement(sql);

            kysely.setString(1, this.getNimi());
            kysely.setString(2, this.getEmail());
            kysely.setString(3, this.getPuhNro());

            tulokset = kysely.executeQuery();
            tulokset.next();

            this.setId(tulokset.getInt(1));
        } catch (Exception e) {
            
        } finally {
            try { tulokset.close(); } catch (Exception e1) {}
            try { kysely.close(); } catch (Exception e2) {}
            try { yhteys.close(); } catch (Exception e3) {}
        }
            
        


    }
    
    public static Vieras etsi(int id) {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Vieras loydetty = null;
        
        try {
            yhteys = Tietokanta.getYhteys();


            String sql = "SELECT * FROM Vieras WHERE id = ?";
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, id);

            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                loydetty = new Vieras();

                loydetty.setId(tulokset.getInt("id"));
                loydetty.setNimi(tulokset.getString("nimi"));
                loydetty.setEmail(tulokset.getString("email"));
                loydetty.setPuhNro(tulokset.getString("puhnro"));
                          
            }
                
        } catch (Exception e) {
            
        }
        
        try { tulokset.close(); } catch (Exception e1) {}
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

        
        return loydetty;
    }
    
    public static Vieras etsi(String nimi) {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Vieras loydetty = null;
        
        try {
            yhteys = Tietokanta.getYhteys();


            String sql = "SELECT * FROM Vieras WHERE nimi = ?";
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, nimi);

            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                loydetty = new Vieras();

                loydetty.setId(tulokset.getInt("id"));
                loydetty.setNimi(tulokset.getString("nimi"));
                loydetty.setEmail(tulokset.getString("email"));
                loydetty.setPuhNro(tulokset.getString("puhnro"));
                          
            }
                
        } catch (Exception e) {
            
        }
        
        try { tulokset.close(); } catch (Exception e1) {}
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

        
        return loydetty;
    }
    
    public static Vieras etsiEmaililla(String email) {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Vieras loydetty = null;
        
        try {
            yhteys = Tietokanta.getYhteys();


            String sql = "SELECT * FROM Vieras WHERE email = ?";
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, email);

            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                loydetty = new Vieras();

                loydetty.setId(tulokset.getInt("id"));
                loydetty.setNimi(tulokset.getString("nimi"));
                loydetty.setEmail(tulokset.getString("email"));
                loydetty.setPuhNro(tulokset.getString("puhnro"));
                          
            }
                
        } catch (Exception e) {
            
        }
        
        try { tulokset.close(); } catch (Exception e1) {}
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}

        
        return loydetty;
    }
    
    
    
    public List<Vieras> getVieraat() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        ArrayList<Vieras> vieraat = new ArrayList<Vieras>();

        yhteys = Tietokanta.getYhteys();


        String sql = "SELECT * from Vieras";
        kysely = yhteys.prepareStatement(sql);
        tulokset = kysely.executeQuery();

        vieraat = new ArrayList<Vieras>();

        while(tulokset.next()) {


            int id = tulokset.getInt("id");
            String nimi = tulokset.getString("nimi");
            String email = tulokset.getString("email");
            String puhNro = tulokset.getString("puhnro");

            Vieras vieras = new Vieras();

            vieras.setId(id);
            vieras.setNimi(nimi);
            vieras.setEmail(email);
            vieras.setPuhNro(puhNro);

            vieraat.add(vieras);
        }

        try { tulokset.close(); } catch (Exception e1) {}
        try { kysely.close(); } catch (Exception e2) {}
        try { yhteys.close(); } catch (Exception e3) {}



        return vieraat;
            
    }
    
    @Override
    public String toString() {
        String palautettava ="id: " + this.id + " nimi: " + this.nimi + " email: " + this.email + " puhNro: " + this.puhNro; 
        return palautettava;
    }
    
}
