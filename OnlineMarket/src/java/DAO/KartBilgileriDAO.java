
package DAO;

import entity.kartbilgileri;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KartBilgileriDAO extends DBConnection{
    public void delete(kartbilgileri kart){
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("Delete from kartbilgileri where kid = " + kart.getKid());
        } catch (SQLException ex) {
            Logger.getLogger(KartBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
