package br.com.controle.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import br.com.controle.infra.persistencia.util.GenericEnumConverter;
import br.com.controle.model.enuns.EnumSituacaoProjeto;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_projeto database table.
 * 
 */
@Entity
@Table(name="tb_projeto")
@NamedQuery(name="Projeto.findAll", query="SELECT p FROM Projeto p")
public class Projeto extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=255)
	private String descricao;

	@Column(nullable=false, length=60)
	private String nome;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal orcamento;

	@Column(length=15)
	private String sigla;

	@Convert( converter=GenericEnumConverter.class )
	@Column(nullable=false, length=2)
	private EnumSituacaoProjeto situacao;

	//bi-directional many-to-one association to Alocado
	@OneToMany(mappedBy="projeto")
	private List<Alocado> alocados;

	public Projeto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getOrcamento() {
		return this.orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public EnumSituacaoProjeto getSituacao() {
		return this.situacao;
	}

	public void setSituacao(EnumSituacaoProjeto situacao) {
		this.situacao = situacao;
	}

	public List<Alocado> getAlocados() {
		return this.alocados;
	}

	public void setAlocados(List<Alocado> alocados) {
		this.alocados = alocados;
	}

	public Alocado addAlocado(Alocado alocado) {
		getAlocados().add(alocado);
		alocado.setProjeto(this);

		return alocado;
	}

	public Alocado removeAlocado(Alocado alocado) {
		getAlocados().remove(alocado);
		alocado.setProjeto(null);

		return alocado;
	}

}