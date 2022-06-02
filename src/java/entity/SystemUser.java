package entity;

import java.io.Serializable;

public class SystemUser implements Serializable {

    private Long id;
    private String email;
    private String pass;
    private SystemGroup group;
    public String getPass;

    public SystemUser() {
    }

    public SystemUser(Long id, String email, String pass, SystemGroup group) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public SystemGroup getGroup() {
        return group;
    }

    public void setGroup(SystemGroup group) {
        this.group = group;
    }

}
