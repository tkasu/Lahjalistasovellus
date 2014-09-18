package Lahjalista.Models;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Tietokanta {

    private Connection yhteys;
    
    public Tietokanta () throws NamingException, SQLException {
        InitialContext cxt = new InitialContext();
        DataSource yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/tomikasu");
        Connection yhteys = yhteysVarasto.getConnection(); 
        
        this.yhteys = yhteys;
    }
    
    public Connection getYhteys()  {  
        return this.yhteys;
    }
    
    
}
