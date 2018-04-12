package br.com.controle.infra.persistencia.util;

/**
 * Interface que define o contrato de todos os Enums que serão
 * usados em mapeamentos ORM.
 *  
 */
public interface BaseEnum {
	/**
	 * Retorna o valor do Enum que se deseja
	 * gravar no banco.
	 * 	
	 * @return
	 */
	Object getValor();
	
	static BaseEnum fromCode(String valor) {
		// TODO Auto-generated method stub
		return null;
	}
}
