package br.com.controle.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.model.Bairro;
import br.com.controle.model.Cidade;
import br.com.controle.model.Colaborador;
import br.com.controle.model.Departamento;
import br.com.controle.model.Estado;
import br.com.controle.model.enuns.EnumSexo;
import br.com.controle.service.ProjetoService;

@Named
//@RequestScoped
@ViewScoped
public class ColaboradorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Colaborador colaborador;
	
	private Estado estado;
	
	private Cidade cidade;
	
	private Bairro bairro;
	
	private List<Departamento> departamentos;
	
	private List<Cidade> cidades;
	
	private List<EnumSexo> sexos;
	
	private List<Estado> estados;
	
	private List<Bairro> bairros;

	@Inject
	private ProjetoService projetoService;
	
	private Locale locale;
	
	@PostConstruct
	public void init() {
		colaborador = new Colaborador();
		estado = new Estado();
		cidade = new Cidade();
		bairro = new Bairro();
		departamentos = projetoService.listarDepartamentos();
		cidades = new ArrayList<>();
		estados = projetoService.listarEstados();
		sexos = Arrays.asList(EnumSexo.values());
		bairros = new ArrayList<>();
		locale = new Locale("pt_BR");
	}
	
	public void carregarCidades(AjaxBehaviorEvent ev) {
		cidades = projetoService.buscarCidadesPorEstado(estado);
	}
	
	public void carregarBairros(AjaxBehaviorEvent ev) {
		bairros = projetoService.buscarBairrosPorCidade(cidade);
	}
	
	public void salvar(){
		getCidade().setEstado(getEstado());
		getBairro().setCidade(getCidade());
		colaborador.getEndereco().setBairro(getBairro());
		projetoService.salvar(colaborador);
	}
	
	
	public Colaborador getColaborador() {
		return colaborador;
	}

	public Estado getEstado() {
		return estado;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public List<EnumSexo> getSexos() {
		return sexos;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void setSexos(List<EnumSexo> sexos) {
		this.sexos = sexos;
	}


	public List<Estado> getEstados() {
		return estados;
	}


	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Cidade buscarCidadePorId(Long id) {
		return projetoService.buscarCidadePorId(id);
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	
}
