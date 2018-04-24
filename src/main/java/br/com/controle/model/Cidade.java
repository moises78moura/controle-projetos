package br.com.controle.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tb_cidade database table.
 * 
 */
@Entity
@Table(name="tb_cidade")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="CODIGO_IBGE")
	private Integer codigoIbge;

	@Column(nullable=false, length=100)
	private String nome;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="FK_TB_ESTADO", nullable=false)
	private Estado estado;

	//bi-directional many-to-one association to Bairro
	@OneToMany(mappedBy="cidade", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
	private List<Bairro> bairros;


	public Cidade() {
	}

	public Cidade(Long id, Estado estado, String nome, Integer codigoIbge) {
		
		this.id = id;
		this.estado = estado;
		this.nome = nome;
		this.codigoIbge = codigoIbge;
		this.bairros = new ArrayList<Bairro>();
		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoIbge() {
		return this.codigoIbge;
	}

	public void setCodigoIbge(Integer codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Bairro> getBairros() {
		return this.bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Bairro addBairro(Bairro bairro) {
		getBairros().add(bairro);
		bairro.setCidade(this);

		return bairro;
	}

	public Bairro removeBairro(Bairro bairro) {
		getBairros().remove(bairro);
		bairro.setCidade(null);

		return bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoIbge == null) ? 0 : codigoIbge.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (codigoIbge == null) {
			if (other.codigoIbge != null)
				return false;
		} else if (!codigoIbge.equals(other.codigoIbge))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}