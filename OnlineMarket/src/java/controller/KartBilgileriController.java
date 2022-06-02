
package controller;

import DAO.KartBilgileriDAO;
import entity.kartbilgileri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "kartBilgileri")
@SessionScoped
public class KartBilgileriController implements Serializable {

    private kartbilgileri kart;
    private KartBilgileriDAO db;
    private List<kartbilgileri> kartList;
    private int musteriId;

   
    public KartBilgileriController() {
    }
    
    public void create(){
        this.getDb().create(kart);
    }
    
    
    public void delete(kartbilgileri kart) {
        System.out.println(kart.getId());
        this.getDb().delete(kart);
    }

    public List<kartbilgileri> getKartList() {
        return this.kartList;
    }

    public void setKartList(int id) {
        this.kartList = this.getDb().findByKid(id);
    }

    public kartbilgileri getKart() {
        if (this.kart == null) {
            this.kart = new kartbilgileri();
        }
        return kart;
    }

    public void setKart(kartbilgileri kart) {
        this.kart = kart;
    }

    public KartBilgileriDAO getDb() {
        if (this.db == null) {
            this.db = new KartBilgileriDAO();
        }
        return db;
    }

    public void setDb(KartBilgileriDAO db) {
        this.db = db;
    }

    public int getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(int musteriId) {
        this.musteriId = musteriId;
    }

}
