package Lahjalista.Models;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Tietokanta {

    public static Connection getYhteys() throws SQLException, NamingException {  
        InitialContext cxt = new InitialContext();
        DataSource yhteysVarasto = (DataSource)cxt.lookup("java:/comp/env/jdbc/tomikasu");
        return yhteysVarasto.getConnection(); 
    }
    
    
}
