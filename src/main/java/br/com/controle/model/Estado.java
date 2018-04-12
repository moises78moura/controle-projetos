package br.com.controle.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the tb_estado database table.
 * 
 */
@Entity
@Table(name="tb_estado")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false)
	private Integer codigo;

	@Column(nullable=false, length=60)
	private String nome;

	@Column(nullable=false, length=2)
	private String uf;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="estado", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Cidade> cidades;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="FK_TB_PAIS", nullable=false)
	private Pais pais;

	public Estado() {
	}

	public Estado(Long id, Pais pais, String nome, String uf, Integer codigo) {
		this.id = id;
		this.pais = pais;
		this.nome = nome;
		this.uf = uf;
		this.codigo = codigo;
		this.cidades = new ArrayList<Cidade>();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade addCidade(Cidade cidade) {
		getCidades().add(cidade);
		cidade.setEstado(this);

		return cidade;
	}

	public Cidade removeCidade(Cidade cidade) {
		getCidades().remove(cidade);
		cidade.setEstado(null);

		return cidade;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Estado other = (Estado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
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
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	
}