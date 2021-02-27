package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Cliente;
@Stateless
public class ClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	public Cliente buscarClienteCedulaP(String cedula) {
		Cliente cli = em.find(Cliente.class, cedula);
		System.out.println("en dao "+cli.getCedula());
		//return em.find(Cliente.class, cedula);
		return cli;
	}
	
	public Cliente buscarClientecuenta(int cuenta) {
		Cliente cli = em.find(Cliente.class, cuenta);
		System.out.println(cli.getCuenta());
		//return em.find(Cliente.class, numero);
		return cli;
	}
	
	
	
	
	public Cliente buscarClienteCedula(String cedula) {
		Cliente cli = new Cliente();
		try {
			String jpql = "SELECT c FROM Cliente c where c.cedula = :cedula";
			Query query = em.createQuery(jpql, Cliente.class);
			query.setParameter("cedula", cedula);
			cli = (Cliente) query.getSingleResult();
		} catch (Exception e) {
			cli = null;
		}

		return cli;
	}
	
	public Cliente buscarClienteCuenta(int cuenta) {
		System.out.println("Numero de cuenta en dao "+cuenta);
		Cliente cli = new Cliente();
		try {
			String jpql = "SELECT c FROM Cliente c where c.cuenta = :cuenta";
			Query query = em.createQuery(jpql, Cliente.class);
			query.setParameter("cuenta", cuenta);
			cli = (Cliente) query.getSingleResult();
			System.out.println("en dao >>>>> "+cli.toString());
		} catch (Exception e) {
			cli = null;
		}

		return cli;
	}
	public void actualizarCliente(Cliente cliente ) {
		em.merge(cliente);
	}

}
