
package DAO;

import entity.sepet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SepetDAO extends DBConnection{
    public void delete(sepet s){
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("Delete from kartbilgileri where kid = " + s.getSid());
        } catch (SQLException ex) {
            Logger.getLogger(KartBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
