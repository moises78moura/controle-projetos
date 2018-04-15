package br.com.controle.mb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.com.controle.model.BaseEntity;

import java.util.Map;

/**
 * 
 * Conversor genérico para entidades
 * Não funcionou o converter genérico.
 * 
 */

@Named
@FacesConverter(value = "br.com.controle.mb.converter.EntityConverter", forClass = BaseEntity.class)
public class EntityConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

//        if(value == null || !value.matches("\\d+")) {
//            return null;
//        }
    	if(value != null) {
            return this.getAttributesForm(uiComponent).get(value);
        }
//        Object object = this.getAttributesForm(uiComponent).get(value);
        
		return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        
    	if(value != null && !value.equals("")){
            BaseEntity entity = (BaseEntity) value;
            if(entity.getId() != null){
                this.addAttribute(uiComponent,entity);
                if(entity.getId() != null) {
                	return entity.getId().toString();
                }
            }
            return value.toString();
        }

        return "";
    }

    private void addAttribute(UIComponent component, BaseEntity abstractEntity){
        this.getAttributesForm(component).put(abstractEntity.getId().toString(),abstractEntity);
    }

    private Map<String, Object> getAttributesForm(UIComponent component){
        return component.getAttributes();
    }
}
