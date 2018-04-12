package br.com.controle.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.controle.infra.persistencia.GenericDaoJpa;
import br.com.controle.model.Bairro;
import br.com.controle.model.Cidade;
import br.com.controle.model.Departamento;
import br.com.controle.model.Estado;
import br.com.controle.model.Projeto;

@Stateless
@LocalBean
public class ProjetoService {

	@Inject
	private GenericDaoJpa jpa;

	public void salvar(Projeto projeto) {
		jpa.save(projeto);
	}

	public List<Departamento> listarDepartamentos() {

		List<Departamento> departamentos = new ArrayList<>();

		departamentos = jpa.findAllByNamedQuery(Departamento.class, "Departamento.findAll");
		return departamentos;

	}

	public List<Estado> listarEstados() {

		List<Estado> estados = new ArrayList<>();
		estados = jpa.findAllByNamedQuery(Estado.class, "Estado.findAll");
		return estados;
	}

	public List<Cidade> listarCidades() {

		List<Cidade> cidades = new ArrayList<>();
		cidades = jpa.findAllByNamedQuery(Cidade.class, "Cidade.findAll");
		return cidades;
	}

	public List<Cidade> buscarCidadesPorEstado(Estado estado) {
		return jpa.findByProperty(Cidade.class, "estado", estado);
	}

	public List<Bairro> buscarBairrosPorCidade(Cidade cidade) {
		return jpa.findByProperty(Bairro.class, "cidade", cidade);
	}

}
