package br.com.controle.mb.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * 
 * @author Momoura
 *
 */
@FacesConverter(value="localDateConverter")
public class LocalDateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate localDate = LocalDate.parse(data, formatter);
		return localDate;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object data) {
		LocalDate dataSemFormato = (LocalDate) data;
		DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = dataSemFormato.format(forma);
		return dataFormatada;
	}

}
