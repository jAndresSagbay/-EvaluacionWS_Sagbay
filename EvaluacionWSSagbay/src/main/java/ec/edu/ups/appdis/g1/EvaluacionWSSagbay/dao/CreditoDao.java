package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Credito;

@Stateless
public class CreditoDao {
	@Inject
	private EntityManager em;
	
	public Credito buscarCredito(int numero) {
		Credito cli = em.find(Credito.class, numero);
		System.out.println(cli.getId());
		return em.find(Credito.class, numero);
	}

	public void crearCredito(Credito credito) {
		em.persist(credito);
	}
	
	
}
