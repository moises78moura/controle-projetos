package br.com.controle.mb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.model.Projeto;
import br.com.controle.model.enuns.EnumSituacaoProjeto;
import br.com.controle.service.ProjetoService;

/**
 * 
 * @author moises
 *
 */
@Named
@RequestScoped
public class ProjetoBean implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Projeto projeto;
	
	@Inject
	private ProjetoService projetoService;
	
	private List<EnumSituacaoProjeto> situacoes;

	@PostConstruct
	public void init() {
		projeto = new Projeto();
		situacoes = Arrays.asList(EnumSituacaoProjeto.values());
	}
	
	public void salvar() {
		projetoService.salvar(projeto);
		this.init();
		FacesContext instance = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!","Projeto cadastrado com sucesso!");
		instance.addMessage("", msg);
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<EnumSituacaoProjeto> getSituacoes() {
		return situacoes;
	}

	
}
