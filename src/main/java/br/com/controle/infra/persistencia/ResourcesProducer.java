package br.com.controle.infra.persistencia;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class ResourcesProducer {

	@Produces
	@PersistenceContext( unitName = "controle_projeto_pu")
	private EntityManager entityManager;
}
