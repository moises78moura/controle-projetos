package br.com.controle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tb_alocado database table.
 * 
 */
@Entity
@Table(name="tb_alocado")
@NamedQuery(name="Alocado.findAll", query="SELECT a FROM Alocado a")
public class Alocado extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="CARGA_HORARIA", nullable=false)
	private Integer cargaHoraria;

	@Column(nullable=false, length=2)
	private String situacao;

	//bi-directional many-to-one association to Colaborador
	@ManyToOne
	@JoinColumn(name="FK_COLABORADOR", nullable=false)
	private Colaborador colaborador;

	//bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name="FK_PROJETO", nullable=false)
	private Projeto projeto;

	public Alocado() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}