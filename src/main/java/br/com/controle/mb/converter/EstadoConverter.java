package br.com.controle.mb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.controle.model.Estado;

@Named
//@FacesConverter(value="departamentoConverter")
@FacesConverter(forClass=Estado.class)
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(StringUtils.isNotBlank(value)){
			Estado estado = (Estado)component.getAttributes().get(value);
			return estado;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value instanceof Estado){
			Estado estado = (Estado) value;
			if(estado != null && estado.getId() != null){
				component.getAttributes().put(estado.getId().toString(), estado);
				return estado.getId().toString();
			}
		}
		
		return "";
	}

}
