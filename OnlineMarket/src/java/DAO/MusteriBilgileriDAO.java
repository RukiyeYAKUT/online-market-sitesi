
package DAO;

import entity.musteribilgileri;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<musteribilgileri> getAll(int page, int pageSize) {
        List<musteribilgileri> musteriBilgileriList = new ArrayList<>();
        musteribilgileri musteri = null;
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select * from musteribilgileri order by id asc offset " + start + " limit " + pageSize);
            while (rs.next()) {
                musteri = new musteribilgileri(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("adres"), rs.getString("mail"), rs.getString("telefonno"));
                musteriBilgileriList.add(musteri);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return musteriBilgileriList;
    }

    public void create(musteribilgileri musteri) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("Insert into musteribilgileri (ad,soyad,adres,mail,telefonno) values ('" + musteri.getAd() + "','" + musteri.getSoyad() + "','" + musteri.getAdres() + "','" + musteri.getMail() + "','" + musteri.getTelefonno() + "')");

        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(musteribilgileri musteri) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("Update musteribilgileri set ad = '" + musteri.getAd() + "', soyad = '" + musteri.getSoyad() + "', adres = '" + musteri.getAdres() + "', mail = '" + musteri.getMail() + "', telefonno = '" + musteri.getMail() + "'where id = " + musteri.getId());

        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(musteribilgileri musteri) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from musteribilgileri where id = " + musteri.getId());
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<musteribilgileri> findByName(String name) {
        List<musteribilgileri> musteriBilgileriList = new ArrayList<>();
        musteribilgileri musteri = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select * from musteribilgileri where ad like '%" + name + "%'");
            while (rs.next()) {
                musteri = new musteribilgileri(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("adres"), rs.getString("mail"), rs.getString("telefonno"));
                musteriBilgileriList.add(musteri);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return musteriBilgileriList;
    }
    
    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select count(id) as count from musteribilgileri");
            rs.next();
            count = rs.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(MusteriBilgileriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

}
