package br.com.controle.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_departamento database table.
 * 
 */
@Entity
@Table(name="tb_departamento")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=255)
	private String descricao;

	@Column(nullable=false, length=60)
	private String nome;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal orcamento;

	@Column(length=10)
	private String sigla;

	@Column(name="TELEFONE_RAMAL", length=12)
	private String telefoneRamal;

	//bi-directional many-to-one association to Colaborador
	@OneToMany(mappedBy="departamento")
	private List<Colaborador> colaboradores;

	public Departamento() {
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

	public String getTelefoneRamal() {
		return this.telefoneRamal;
	}

	public void setTelefoneRamal(String telefoneRamal) {
		this.telefoneRamal = telefoneRamal;
	}

	public List<Colaborador> getColaboradores() {
		return this.colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Colaborador addColaboradore(Colaborador colaboradore) {
		getColaboradores().add(colaboradore);
		colaboradore.setDepartamento(this);

		return colaboradore;
	}

	public Colaborador removeColaboradore(Colaborador colaboradore) {
		getColaboradores().remove(colaboradore);
		colaboradore.setDepartamento(null);

		return colaboradore;
	}

}