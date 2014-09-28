package Lahjalista.Models;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Tietokanta {

    private DataSource yhteysVarasto;
    
    public Tietokanta () throws NamingException {
        InitialContext cxt = new InitialContext();
        this.yhteysVarasto = (DataSource)cxt.lookup("java:/comp/env/jdbc/tomikasu");
    }
    
    public Connection getYhteys() throws SQLException {  
        return yhteysVarasto.getConnection();
    }
    
    
}
