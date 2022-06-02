package dao;

import entity.SystemGroup;
import entity.SystemUser;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

public class UserDAO extends DBConnect {

    private GroupDAO gdao;

    public SystemUser getUser(String email, String pass) {
        SystemUser u = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from systemuser  where email='" + email + "' and pass='" + pass + "'");

            rs.next();
            SystemGroup g = this.getGdao().getById(rs.getLong("ugroup"));
            u = new SystemUser(rs.getLong("id"), rs.getString("email"), rs.getString("pass"), g);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }

    public List<SystemUser> readList() {
        List<SystemUser> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from systemuser");
            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getLong("ugroup"));
                list.add(new SystemUser(rs.getLong("id"), rs.getString("email"), rs.getString("pass"), g));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(SystemUser c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into systemuser(email, pass, ugroup)values ('" + c.getEmail() + "', '" + c.getPass() + "','" + c.getGroup().getId() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(SystemUser c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update systemgroup set pass='" + c.getPass + "',ugroup=" + c.getGroup().getId() + "where id =" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(SystemUser c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from systemuser where id = " + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public GroupDAO getGdao() {
        if (this.gdao == null) {
            this.gdao = new GroupDAO();
        }
        return gdao;
    }

    public void setGdao(GroupDAO gdao) {
        this.gdao = gdao;
    }

}
