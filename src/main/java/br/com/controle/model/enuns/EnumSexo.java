package br.com.controle.model.enuns;

import br.com.controle.infra.persistencia.util.BaseEnum;

public enum EnumSexo implements BaseEnum{

	
	FEMININO("F","Feminino"),
	MASCULINO("M","Masculino");
	
	private String valor;
	private String descricao;
	
	private EnumSexo(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public EnumSexo fromCode(String valor) {
		
		if ( valor == EnumSexo.FEMININO.valor) {
			return EnumSexo.FEMININO;
		}
		if ( valor == EnumSexo.MASCULINO.valor) {
			return EnumSexo.MASCULINO;
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		return valor;
	}
	
}
