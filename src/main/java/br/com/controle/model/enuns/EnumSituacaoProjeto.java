package br.com.controle.model.enuns;

import br.com.controle.infra.persistencia.util.BaseEnum;

public enum EnumSituacaoProjeto implements BaseEnum{

	DESENV("DS","Em Desenvolvimento"),
	PRE_VENDA("PR","Pré Venda"),
	EM_ANALISE("EM","Em Análise"),
	POS_VENDA("PO","Pós Venda");
	
	private String valor;
	private String descricao;
	
	private EnumSituacaoProjeto(String valor, String descricao) {
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
	
	public EnumSituacaoProjeto fromCode(String valor) {
		
		if ( valor == EnumSituacaoProjeto.DESENV.valor) {
			return EnumSituacaoProjeto.DESENV;
		}
		if ( valor == EnumSituacaoProjeto.EM_ANALISE.valor) {
			return EnumSituacaoProjeto.EM_ANALISE;
		}
		if ( valor == EnumSituacaoProjeto.POS_VENDA.valor) {
			return EnumSituacaoProjeto.POS_VENDA;
		}
		if ( valor == EnumSituacaoProjeto.PRE_VENDA.valor) {
			return EnumSituacaoProjeto.PRE_VENDA;
		}
		
		return null;
	}
	
	
	@Override
	public String toString() {
		return valor;
	}
}
