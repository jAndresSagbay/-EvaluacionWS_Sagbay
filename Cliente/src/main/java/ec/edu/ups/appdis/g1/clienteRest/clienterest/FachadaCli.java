package ec.edu.ups.appdis.g1.clienteRest.clienterest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import ec.edu.ups.appdis.g1.clienteRest.model.Cuota;
import ec.edu.ups.appdis.g1.clienteRest.model.Fachada;
import ec.edu.ups.appdis.g1.clienteRest.model.Respuesta;


public class FachadaCli {
	private String WS_SAVE = "http://localhost:8080/EvaluacionWSSagbay/ws/serv/guardar";
	
	private String WS_GET= "http://localhost:8080/EvaluacionWSSagbay/ws/serv/cuotas";
	
	
	public Respuesta registra(Fachada transaccionFachada) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_SAVE);
		Respuesta respuesta = target.request().post(Entity.json(transaccionFachada), Respuesta.class);

		return respuesta;
	}
	
	
	public List<Cuota> getCuotas() {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_GET);

		List<Cuota> cuotas = target.request().get(new GenericType<List<Cuota>>() {});
		
		client.close();
		
		return cuotas;		
	}

	/*public Respuesta registraDeposito(TransaccionFachada transaccionFachada) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_SAVE_DEPOSITO_CUENTA_MISMO_BANCO);
		Respuesta respuesta = target.request().post(Entity.json(transaccionFachada), Respuesta.class);

		return respuesta;
	}

	public Respuesta registraRetiro(TransaccionFachada transaccionFachada) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_SAVE_RETIRO_CUENTA_MISMO_BANCO);
		Respuesta respuesta = target.request().post(Entity.json(transaccionFachada), Respuesta.class);

		return respuesta;
	}
*/
}
