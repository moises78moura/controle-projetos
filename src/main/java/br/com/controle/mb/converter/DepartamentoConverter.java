package br.com.controle.mb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.controle.model.Departamento;


@Named
@FacesConverter(value="departamentoConverter")
public class DepartamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(StringUtils.isNotBlank(value)) {
			Departamento departamento ;
		}
			
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
