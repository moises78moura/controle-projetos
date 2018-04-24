package br.com.controle.mb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.controle.model.Bairro;
import br.com.controle.model.Estado;

@Named
//@FacesConverter(value="departamentoConverter")
@FacesConverter(forClass=Bairro.class)
public class BairroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(StringUtils.isNotBlank(value)){
			return (Bairro)component.getAttributes().get(value);
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value instanceof Bairro){
			Bairro bairro = (Bairro) value;
			if(bairro != null && bairro.getId() != null){
				component.getAttributes().put(bairro.getId().toString(), bairro);
				return bairro.getId().toString();
			}
		}
		
		return "";
	}

}
