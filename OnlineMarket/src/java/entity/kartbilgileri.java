
package entity;


public class kartbilgileri {

    private int kid;
    private String ad;
    private String soyad;
    private String kartnumarasi;
    private musteribilgileri musteri;

    public kartbilgileri() {
    }

    public kartbilgileri(int kid, String ad, String soyad, String kartnumarasi, musteribilgileri musteri) {
        this.kid = kid;
        this.ad = ad;
        this.soyad = soyad;
        this.kartnumarasi = kartnumarasi;
        this.musteri = musteri;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
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

    public musteribilgileri getMusteri() {
        return musteri;
    }

    public void setMusteri(musteribilgileri musteri) {
        this.musteri = musteri;
    }

}
