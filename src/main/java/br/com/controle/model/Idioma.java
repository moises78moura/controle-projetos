package br.com.controle.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the tb_idiomas database table.
 * 
 */
@Entity
@Table(name="tb_idiomas")
@NamedQuery(name="Idioma.findAll", query="SELECT i FROM Idioma i")
public class Idioma extends BaseEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=45)
	private String idioma;

	@Column(nullable=false, length=2)
	private String sigla;

	//bi-directional many-to-one association to Pais
	
	@OneToMany(mappedBy="idioma", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Pais> pais;

	public Idioma() {
	}

	public Idioma(Long id, String idioma, String sigla) {
		this.id = id;
		this.idioma = idioma;
		this.sigla = sigla;
		this.pais = new ArrayList<Pais>();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Pais> getPais() {
		return this.pais;
	}

	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}

	public Pais addPai(Pais pai) {
		getPais().add(pai);
		pai.setIdioma(this);

		return pai;
	}

	public Pais removePai(Pais pai) {
		getPais().remove(pai);
		pai.setIdioma(null);

		return pai;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		Idioma other = (Idioma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

}