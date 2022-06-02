
package entity;


public class musteribilgileri {
    private int id;
    private String ad;
    private String soyad;
    private String adres;
    private String mail;
    private String telefonno;

    public musteribilgileri() {
    }

    public musteribilgileri(int id, String ad, String soyad, String adres, String mail, String telefonno) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
        this.mail = mail;
        this.telefonno = telefonno;
    }
    
     public musteribilgileri(String ad, String soyad, String adres, String mail, String telefonno) {
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
        this.mail = mail;
        this.telefonno = telefonno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefonno() {
        return telefonno;
    }

    public void setTelefonno(String telefonno) {
        this.telefonno = telefonno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final musteribilgileri other = (musteribilgileri) obj;
        return this.id == other.id;
    }
    
    
    
}
