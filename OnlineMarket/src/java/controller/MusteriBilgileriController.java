
package controller;

import DAO.MusteriBilgileriDAO;
import entity.musteribilgileri;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named(value = "musteriBilgileri")
@SessionScoped
public class MusteriBilgileriController implements Serializable {

    private musteribilgileri musteri;
    private MusteriBilgileriDAO db;
    private List<musteribilgileri> musteriList;
    private String search = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public MusteriBilgileriController() {
    }

    public void create() {
        this.getDb().create(musteri);
        this.setMusteri(new musteribilgileri());
    }

    public void delete(musteribilgileri musteri) {
        this.getDb().delete(musteri);
    }

    public void select(musteribilgileri musteri) {
        this.setMusteri(musteri);
    }

    public void update() {
        this.getDb().update(this.musteri);
    }

    public void reset() {
        this.setMusteri(new musteribilgileri());
    }

    public void ileri() {
        System.out.println(this.page);
        if (this.page == this.pageCount) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void geri() {
        if (this.page == 1) {
            this.page = this.pageCount;
        } else {
            this.page--;
        }
    }

    public musteribilgileri getMusteri() {
        if (this.musteri == null) {
            this.musteri = new musteribilgileri();
        }
        return musteri;
    }

    public void setMusteri(musteribilgileri musteri) {
        this.musteri = musteri;
    }

    public MusteriBilgileriDAO getDb() {
        if (this.db == null) {
            this.db = new MusteriBilgileriDAO();
        }
        return db;
    }

    public void setDb(MusteriBilgileriDAO db) {
        this.db = db;
    }

    public List<musteribilgileri> getMusteriList() {
        
        if (!search.equals("")) {
            this.musteriList = this.getDb().findByName(search);
            return musteriList;
        }
        this.musteriList = this.getDb().getAll(this.page, this.pageSize);
        return musteriList;
    }

    public void setMusteriList(ArrayList<musteribilgileri> musteriList) {
        this.musteriList = musteriList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDb().count() / (double) this.getPageSize());
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
