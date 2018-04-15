package br.com.controle.infra.persistencia.util;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.annotations.Type;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.internal.util.ReflectHelper;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class EnumUserType implements UserType, ParameterizedType {

	@SuppressWarnings({ "rawtypes" })
	private Class<Enum> enumClass;

	private static final Log logger = LogFactory.getLog(Type.class);

	@SuppressWarnings("unchecked")
	@Override
	public void setParameterValues(Properties parameters) {
		String enumClassName = parameters.getProperty("enumClassName");
		if (StringUtils.isBlank(enumClassName)) {
			throw new HibernateException("Parametro enumClassName nao informado para esse EnumUserType!");
		}
		try {
			enumClass = ReflectHelper.classForName(enumClassName);
		} catch (ClassNotFoundException ex) {
			throw new HibernateException("Classe enum " + enumClassName + " não encontrada", ex);
		}
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {
			return true;
		}
		if (x == null || y == null) {
			return false;
		}
		return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@SuppressWarnings("rawtypes")
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		// nome da coluna no banco
		String nomeColuna = names[0];

		// valor armazenado no banco
		String valorNoBanco = rs.getString(nomeColuna);

		Enum[] constantes = enumClass.getEnumConstants();

		for (Enum e : constantes) {
			Object obj = rs.wasNull() ? null : Enum.valueOf(enumClass, e.name());
			if (obj == null) {
				logger.trace("returning null as column: " + nomeColuna);
				return null;
			} else {
				try {
					Method method = obj.getClass().getMethod("getValor");
					method.setAccessible(true);
					String valor = String.valueOf(method.invoke(obj));
					if (valor.equals(valorNoBanco)) { // se o valor do banco for igual ao da constante
						logger.trace("returning '" + valor + "' as column: " + nomeColuna);
						return obj;
					}
				} catch (Exception e1) {
					logger.error("O enum " + obj.getClass() + " não extende a interface BaseEnum.", e1);
					throw new HibernateException("O enum " + obj.getClass() + " não extende a interface BaseEnum.", e1);
				}
			}
		}
		logger.warn("Retornando null para um valor do enum " + enumClass);
		return null;
	}

//	@Override
//	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
//		if (value == null) {
//			logger.trace("binding null to parameter: " + index);
//			st.setNull(index, Hibernate.STRING.sqlType());
//		} else {
//			if (value instanceof BaseEnum) {
//				logger.trace("binding '" + ((BaseEnum) value).getValor() + "' to parameter: " + index);
//				st.setObject(index, ((BaseEnum) value).getValor());
//			} else {
//				logger.trace("binding '" + value.toString() + "' to parameter: " + index);
//				st.setString(index, value.toString());
//			}
//		}
//	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public Class returnedClass() {
		return this.enumClass;
	}

//	@Override
//	public int[] sqlTypes() {
//		return new int[] { Hibernate.STRING.sqlType() };
//	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
