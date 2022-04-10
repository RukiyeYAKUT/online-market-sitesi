
package DAO;

import entity.odemetipi;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OdemeTipiDAO extends DBConnection{
    public void delete(odemetipi odeme){
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("Delete from kartbilgileri where kid = " + odeme.getÖid());
        } catch (SQLException ex) {
            Logger.getLogger(KartBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
