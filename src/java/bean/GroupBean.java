
package bean;

import dao.GroupDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import entity.SystemGroup;

@Named
@SessionScoped
public class GroupBean implements Serializable{
    private SystemGroup entity;
    private GroupDAO dao;
    private List<SystemGroup> list;
    
    public void clearForm(){
        this.entity = new SystemGroup();
        
    }
    
    public void create(){
          this.getDao().create(entity);
        this.entity=new SystemGroup();
    }
    public void update(){
          this.getDao().update(entity);
        this.entity=new SystemGroup();
    }
    public void delete(){
        this.getDao().delete(entity);
        this.entity=new SystemGroup();
    }

    public SystemGroup getEntity(){
        
        if (this.entity==null){
            this.entity=new SystemGroup();
            
        }
        return entity;
    }

    public void setEntity(SystemGroup entity) {
        this.entity = entity;
    }

    public GroupDAO getDao() {
        if(this.dao==null){
            this.dao=new GroupDAO();
        }
        
        return dao;
    }

    public void setDao(GroupDAO dao) {
        this.dao = dao;
    }

    public List<SystemGroup> getList() {
        this.list=this.getDao().readList();
        return list;
    }

    public void setList(List<SystemGroup> list) {
        this.list = list;
    }
    
    
    
}
