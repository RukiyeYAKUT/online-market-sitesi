package entity;

import java.util.Date;
import java.sql.Timestamp;

public class musterii {

    private Long id;
    private String title;
    private Timestamp created;
    private Timestamp updated;
    private String müsteri_adı;

    public musterii() {
    }

    public musterii(Long id, String title, Timestamp created, Timestamp updated) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.updated = updated;
    }

    public musterii(String title, Timestamp created) {
        this.id = id;
        this.title = title;
        this.created = created;
    }

    

    
    

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
