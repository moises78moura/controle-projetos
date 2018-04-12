package br.com.controle.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_endereco database table.
 * 
 */
@Entity
@Table(name="tb_endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private int cep;

	@Column(nullable=false, length=70)
	private String logradouro;

	private Integer numero;

	//bi-directional many-to-one association to Colaborador
	@OneToMany(mappedBy="endereco")
	private List<Colaborador> colaboradores;

	//bi-directional many-to-one association to Bairro
	@ManyToOne
	@JoinColumn(name="FK_TB_BAIRROS", nullable=false)
	private Bairro bairro;

	public Endereco() {
		bairro = new Bairro();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCep() {
		return this.cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Colaborador> getColaboradores() {
		return this.colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Colaborador addColaboradore(Colaborador colaboradore) {
		getColaboradores().add(colaboradore);
		colaboradore.setEndereco(this);

		return colaboradore;
	}

	public Colaborador removeColaboradore(Colaborador colaboradore) {
		getColaboradores().remove(colaboradore);
		colaboradore.setEndereco(null);

		return colaboradore;
	}

	public Bairro getBairro() {
		return this.bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}