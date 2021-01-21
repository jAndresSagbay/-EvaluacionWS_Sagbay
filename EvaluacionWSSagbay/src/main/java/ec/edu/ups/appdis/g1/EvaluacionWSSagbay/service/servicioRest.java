package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Cuota;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Fachada;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.on.GestionON;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.utils.Respuesta;

@Path("serv")
public class servicioRest {
	@Inject
	private GestionON gestionon;
	
	@POST
	@Path("/guardar")
	@Produces("application/json")
	@Consumes("application/json")

	public Respuesta transacciones(Fachada trx) {
		Respuesta r = new Respuesta();
		try {
			r =gestionon.CrearPoliza(trx);
		} catch (Exception e) {
			e.printStackTrace();
			r.setCodigo(99);
			r.setMensaje(e.getMessage());
		}
		return r;
	}
	
	@GET
	@Path("cuotas")
	@Produces("application/json")

	public List<Cuota> getCuotas() {
		try {
			return gestionon.mostrarCuotas();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
