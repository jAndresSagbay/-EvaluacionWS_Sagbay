package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Cuota;

public class CuotaDao {
	@Inject
	private EntityManager em;
	
	public void crearCuota(Cuota cuota) {
		em.persist(cuota);
	}
	
	public List<Cuota> mostrarCuotas() {
		String jpql = "SELECT a FROM Cuota a";
		Query query = em.createQuery(jpql, Cuota.class);
		List<Cuota> transacciones = query.getResultList();
		return transacciones;
	}

}
