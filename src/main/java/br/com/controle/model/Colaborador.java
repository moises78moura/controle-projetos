package br.com.controle.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.controle.infra.persistencia.util.GenericEnumConverter;
import br.com.controle.model.enuns.EnumSexo;


/**
 * The persistent class for the tb_colaborador database table.
 * 
 */
@Entity
@Table(name="tb_colaborador")
@NamedQuery(name="Colaborador.findAll", query="SELECT c FROM Colaborador c")
public class Colaborador extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=60)
	private String email;

	@Column(nullable=false)
	private Integer funcao;

//	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private LocalDate nascimento;

	@Column(nullable=false)
	private Integer nivel;

	@Column(nullable=false, length=60)
	private String nome;

	@Column(precision=10, scale=2)
	private BigDecimal remuneracao;

	@Convert( converter=GenericEnumConverter.class )
	@Column(nullable=false, length=1)
	private EnumSexo sexo;

	//bi-directional many-to-one association to Alocado
	@OneToMany(mappedBy="colaborador")
	private List<Alocado> alocados;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="FK_DEPARTAMENTO", nullable=false)
	private Departamento departamento;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="FK_ENDERECO", nullable=false)
	private Endereco endereco;

	public Colaborador() {
		endereco = new Endereco();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFuncao() {
		return this.funcao;
	}

	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}

	public LocalDate getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getRemuneracao() {
		return this.remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public EnumSexo getSexo() {
		return this.sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public List<Alocado> getAlocados() {
		return this.alocados;
	}

	public void setAlocados(List<Alocado> alocados) {
		this.alocados = alocados;
	}

	public Alocado addAlocado(Alocado alocado) {
		getAlocados().add(alocado);
		alocado.setColaborador(this);

		return alocado;
	}

	public Alocado removeAlocado(Alocado alocado) {
		getAlocados().remove(alocado);
		alocado.setColaborador(null);

		return alocado;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}