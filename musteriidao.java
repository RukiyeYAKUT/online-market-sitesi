
package dao;

import entity.musterii;
import util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

public class musteriidao {
    
    private Connection db;

    public void createmusterii(Category c){
        try {
           
           
             Statement st = this.getDb().createStatement();
            String query ="insert into musterii (title ,created)values ('"+c.getClass()+"','"+c.getClass()+"')";
               int r =st.executeUpdate(query);       
              
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List <musterii> getmusteriiList(){
        
        List <musterii> musteriiList=new ArrayList<>();
        try{
            Statement st =this.getDb().createStatement();
            
            
            String query ="select * from musterii";
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
               musteriiList.add(new musterii(rs.getLong("id"),rs.getString("title"),rs.getTimestamp("created"),rs.getTimestamp("update")));
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return musteriiList;
    }
    
    
    
    public Connection getDb() {
        
        if(this.db==null){
            DBConnection dbc=new DBConnection();
            this.db=(Connection) dbc.connect();
        }
     
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public void createmusterii(musterii entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
