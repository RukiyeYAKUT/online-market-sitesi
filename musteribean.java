
package controller;

import dao.musteriidao;
import entity.musterii;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;


@Named(value = "musteribean")
@SessionScoped
public class musteribean implements Serializable {
      
    
    private musterii entity;
    private musteriidao dao;
    private List<musterii> list;
    
    public musteribean() {
    }
    
    public void create (){
        this.entity.setCreated(new Timestamp(System.currentTimeMillis()));
        this.getDao().createmusterii(entity);
    }
    
    
    public musterii getEntity() {
        
        if(this.entity==null){
            this.entity=new musterii();
        }
        return entity;
    }

    public void setEntity(musterii entity) {
        this.entity = entity;
    }

    public musteriidao getDao() {
        
        if(this.dao==null){
            this.dao=new musteriidao();
        }
        return dao;
    }

    public void setDao(musteriidao dao) {
        this.dao = dao;
    }

    public List<musterii> getList() {
        
        this.list=this.getDao().getmusteriiList();
        return list;
    }

    public void setList(List<musterii> list) {
        this.list = list;
    }
    
}
