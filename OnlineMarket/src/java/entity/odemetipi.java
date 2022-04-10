
package entity;


public class odemetipi {
    private int öid;
    private String kapidaodeme;
    private String onlineodeme;

    public odemetipi() {
    }

    public odemetipi(int öid, String kapidaodeme, String onlineodeme) {
        this.öid = öid;
        this.kapidaodeme = kapidaodeme;
        this.onlineodeme = onlineodeme;
    }

    public int getÖid() {
        return öid;
    }

    public void setÖid(int öid) {
        this.öid = öid;
    }

    public String getKapidaodeme() {
        return kapidaodeme;
    }

    public void setKapidaodeme(String kapidaodeme) {
        this.kapidaodeme = kapidaodeme;
    }

    public String getOnlineodeme() {
        return onlineodeme;
    }

    public void setOnlineodeme(String onlineodeme) {
        this.onlineodeme = onlineodeme;
    }
    
}
