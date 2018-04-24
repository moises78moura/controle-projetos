package br.com.controle.mb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.controle.mb.ColaboradorBean;
import br.com.controle.model.Cidade;

@Named
// @FacesConverter(value="departamentoConverter")
@FacesConverter( forClass=Cidade.class)
public class CidadeConverter implements Converter {

	@Inject
	private ColaboradorBean colaboradorBean;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (StringUtils.isNotBlank(value)) {
//			Cidade cidade = colaboradorBean.buscarCidadePorId(Long.parseLong(value));
			 Cidade cidade = (Cidade)component.getAttributes().get(value);//
			return cidade;
			// return (Cidade)component.getAttributes().get(value);
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value instanceof Cidade) {
			Cidade cidade = (Cidade) value;
			if (cidade != null && cidade.getId() != null) {
				component.getAttributes().put(cidade.getId().toString(), cidade);
				return cidade.getId().toString();
			}
		}

		 return "";
//		if (value instanceof Cidade) {
//
//			Cidade municipio = (Cidade) value;
//			return String.valueOf(municipio.getId());
//		}
//
//		return "";
	}

}
