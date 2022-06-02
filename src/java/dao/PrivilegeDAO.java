package dao;

import entity.Privileges;
import entity.SystemGroup;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

public class PrivilegeDAO extends DBConnect {

    private GroupDAO gdao;

    public PrivilegeDAO() {
    }

    public List<Privileges> readList() {
        List<Privileges> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from privilege");
            while (rs.next()) {
                SystemGroup g = this.getGdao().getById(rs.getLong("sgroup"));
                list.add(new Privileges(rs.getLong("id"),g, rs.getString("mname"), rs.getBoolean("icreate"), rs.getBoolean("read"), rs.getBoolean("iupdate"), rs.getBoolean("idelete"), rs.getBoolean("ilist"), rs.getBoolean("irshow")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(Privileges c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into privilege (sgroup ,mname,icreate,iread,iupdate,idelete,ilist,irshow)values (" +c.getPgroup().getId()+",'" + c.getMname() + "'," + c.isIcreate() + "," + c.isIread() + "," + c.isIupdate() + "," + c.isIdelete() + "," + c.isIlist() + "," + c.isIrshow() + ")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Privileges c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update privilege set title='" + c.getMname() + "'where id =" + c.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Privileges c) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from privilege where id = " + c.getId());

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
