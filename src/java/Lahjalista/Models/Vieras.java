package Lahjalista.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


// TÄMÄ LUOKKA KESKENERÄINEN

public class Vieras {
    private int id;
    private String nimi;
    private String email;
    private String puhNro;
    
    public Vieras(int id, String nimi, String email, String puhNro) {
        this.id = id;
        this.nimi = nimi;
        this.email = email;
        this.puhNro = puhNro;
    }
    
    @Override
    public String toString() {
        String palautettava ="id: " + this.id + " nimi: " + this.nimi + " email: " + this.email + " puhNro: " + this.puhNro; 
        return palautettava;
    }
    
    public List<Vieras> getVieraat() throws Exception{
            Connection yhteys = null;
            PreparedStatement kysely = null;
            ResultSet tulokset = null;
            ArrayList<Vieras> vieraat = new ArrayList<Vieras>();
        
            try {
                Tietokanta kanta = new Tietokanta();
                yhteys = kanta.getYhteys();
                

                String sql = "SELECT * from Vieras";
                kysely = yhteys.prepareStatement(sql);
                tulokset = kysely.executeQuery();

                vieraat = new ArrayList<Vieras>();

                while(tulokset.next()) {


                    int id = tulokset.getInt("id");
                    String nimi = tulokset.getString("nimi");
                    String email = tulokset.getString("email");
                    String puhNro = tulokset.getString("puhnro");

                    Vieras v = new Vieras(id, nimi, email, puhNro);
                    vieraat.add(v);
                }
            } finally {
                tulokset.close();
                kysely.close();
                yhteys.close();
            }
            
            return vieraat;
            
    }
    
}
