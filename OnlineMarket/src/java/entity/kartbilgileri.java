
package entity;


public class kartbilgileri {

    private musteribilgileri musteri;
    private String ad;
    private String soyad;
    private String kartnumarasi;
    private int id;

    public kartbilgileri() {
    }

    public kartbilgileri(musteribilgileri musteri, String ad, String soyad, String kartnumarasi, int id) {
        this.musteri = musteri;
        this.ad = ad;
        this.soyad = soyad;
        this.kartnumarasi = kartnumarasi;
        this.id = id;
    }
    
     public kartbilgileri(musteribilgileri musteri, String ad, String soyad, String kartnumarasi) {
        this.musteri = musteri;
        this.ad = ad;
        this.soyad = soyad;
        this.kartnumarasi = kartnumarasi;
    }
    
    public musteribilgileri getMusteri() {
        return musteri;
    }

    public void setMusteri(musteribilgileri musteri) {
        this.musteri = musteri;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getKartnumarasi() {
        return kartnumarasi;
    }

    public void setKartnumarasi(String kartnumarasi) {
        this.kartnumarasi = kartnumarasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

}
