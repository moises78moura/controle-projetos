package br.com.controle.mb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.controle.model.Departamento;


@Named
@FacesConverter(forClass=Departamento.class)
public class DepartamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(StringUtils.isNotBlank(value)){
			Departamento departamento = (Departamento)component.getAttributes().get(value);
			return departamento;
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value instanceof Departamento){
			Departamento departamento = (Departamento) value;
			if(departamento != null && departamento.getId() != null){
				component.getAttributes().put(departamento.getId().toString(), departamento);
				return departamento.getId().toString();
			}
		}
		
		return "";
	}
}
