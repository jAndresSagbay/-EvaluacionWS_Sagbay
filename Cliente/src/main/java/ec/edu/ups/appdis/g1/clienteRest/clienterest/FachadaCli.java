package ec.edu.ups.appdis.g1.clienteRest.clienterest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import ec.edu.ups.appdis.g1.clienteRest.model.Fachada;
import ec.edu.ups.appdis.g1.clienteRest.model.Respuesta;
import ec.edu.ups.appdis.g1.clienteRest.model.TransaccionFachada;

public class FachadaCli {
	private String WS_SAVE = "http://localhost:8080/EvaluacionWSSagaby/ws/serv/guardar";
	

	public Respuesta registra(Fachada transaccionFachada) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_SAVE);
		Respuesta respuesta = target.request().post(Entity.json(transaccionFachada), Respuesta.class);

		return respuesta;
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
