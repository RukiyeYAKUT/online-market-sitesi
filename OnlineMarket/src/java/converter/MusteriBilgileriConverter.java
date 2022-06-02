
package converter;

import DAO.MusteriBilgileriDAO;
import entity.musteribilgileri;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("musteriBilgileriConverter")
public class MusteriBilgileriConverter implements Converter{
    
    private MusteriBilgileriDAO musteriBilgileriDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getMusteriBilgileriDAO().findById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        musteribilgileri musteri = (musteribilgileri)t;
        return String.valueOf(musteri.getId());
    }

    public MusteriBilgileriDAO getMusteriBilgileriDAO() {
        if(this.musteriBilgileriDAO == null){
            this.musteriBilgileriDAO = new MusteriBilgileriDAO();
        }
        return musteriBilgileriDAO;
    }

    public void setMusteriBilgileriDAO(MusteriBilgileriDAO musteriBilgileriDAO) {
        this.musteriBilgileriDAO = musteriBilgileriDAO;
    }
    
}
