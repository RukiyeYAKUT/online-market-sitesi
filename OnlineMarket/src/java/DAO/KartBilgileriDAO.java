
package DAO;

import entity.kartbilgileri;
import entity.musteribilgileri;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KartBilgileriDAO extends DBConnection {

    MusteriBilgileriDAO mustariBilgileriDAO;

    public void delete(kartbilgileri kart) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("Delete from kartbilgileri where id = " + kart.getId());
        } catch (SQLException ex) {
            Logger.getLogger(KartBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<kartbilgileri> findByKid(int id) {
        List<kartbilgileri> kartbilgileriList = new ArrayList<>();
        kartbilgileri kartbilgileri = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select * from kartbilgileri where kid = " + id);
            while (rs.next()) {
                musteribilgileri musteri = this.getMustariBilgileriDAO().findById(id);
                kartbilgileri = new kartbilgileri(musteri, rs.getString("ad"), rs.getString("soyad"), rs.getString("kartnumarasi"), rs.getInt("id"));
                kartbilgileriList.add(kartbilgileri);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kartbilgileriList;
    }
    
    public void create (kartbilgileri kart){
        try{
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO kartbilgileri (kid,ad,soyad,kartnumarasi) values ("+ kart.getMusteri().getId() +", '"+ kart.getAd() +"', '"+ kart.getSoyad()+"', '"+ kart.getKartnumarasi()+"')");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public MusteriBilgileriDAO getMustariBilgileriDAO() {
        if (this.mustariBilgileriDAO == null) {
            this.mustariBilgileriDAO = new MusteriBilgileriDAO();
        }
        return mustariBilgileriDAO;
    }

    public void setMustariBilgileriDAO(MusteriBilgileriDAO mustariBilgileriDAO) {
        this.mustariBilgileriDAO = mustariBilgileriDAO;
    }

}
