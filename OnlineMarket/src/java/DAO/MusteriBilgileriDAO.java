
package DAO;

import entity.musteribilgileri;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MusteriBilgileriDAO extends DBConnection {

    public musteribilgileri findById(int id) {
        musteribilgileri musteri = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select * from musteribilgileri where id = " + id);
            while (rs.next()) {
                musteri = new musteribilgileri(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("adres"), rs.getString("mail"), rs.getString("telefonno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return musteri;
    }

    public void delete(musteribilgileri musteri) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from musteribilgileri where id = " + musteri.getId());
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
