import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;



public class Vieras {
    private int id;
    private String nimi;
    private String email;
    private String puhNro;
    private Connection yhteys;
    
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
            Tietokanta kanta = new Tietokanta();
            this.yhteys = kanta.getYhteys();
            
            String sql = "SELECT * from Vieras";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet tulokset = kysely.executeQuery();
            
            ArrayList<Vieras> vieraat = new ArrayList<Vieras>();
            
            while(tulokset.next()) {
                
                
                int id = tulokset.getInt("id");
                String nimi = tulokset.getString("nimi");
                String email = tulokset.getString("email");
                String puhNro = tulokset.getString("puhnro");
                
                Vieras v = new Vieras(id, nimi, email, puhNro);
                vieraat.add(v);
            }
            try { tulokset.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
            
            return vieraat;
            
    }
    
}
