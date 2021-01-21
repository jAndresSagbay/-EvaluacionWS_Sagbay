package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Cliente;
@Stateless
public class ClienteDao {
	@Inject
	private EntityManager em;
	
	public Cliente buscarClienteCedulaP(String cedula) {
		Cliente cli = em.find(Cliente.class, cedula);
		System.out.println(cli.getCedula());
		return em.find(Cliente.class, cedula);
	}
	
	public Cliente buscarClientecuenta(int numero) {
		Cliente cli = em.find(Cliente.class, numero);
		System.out.println(cli.getCuenta());
		return em.find(Cliente.class, numero);
	}

}
