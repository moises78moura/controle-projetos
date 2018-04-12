package br.com.controle.infra.persistencia.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class GenericEnumConverter implements AttributeConverter<BaseEnum,String>{

	@Override
	public BaseEnum convertToEntityAttribute(String value) {
		if ( value == null ) {
			return null;
		}
		
		return BaseEnum.fromCode( value );
	}

	@Override
	public String convertToDatabaseColumn(BaseEnum base) {
		if ( base == null ) {
			return null;
		}
		
		return (String) base.getValor();
	}

}
