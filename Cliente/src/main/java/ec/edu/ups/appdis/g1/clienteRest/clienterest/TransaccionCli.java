package ec.edu.ups.appdis.g1.clienteRest.clienterest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import ec.edu.ups.appdis.g1.clienteRest.model.Respuesta;
import ec.edu.ups.appdis.g1.clienteRest.model.TransaccionFachada;

public class TransaccionCli {

	private String WS_SAVE_TRANSFERENCIA_ENTRE_CUENTAS_MISMO_BANCO = "http://localhost:8080/SistemaBancario/ws/serv/transferir";
	private String WS_SAVE_DEPOSITO_CUENTA_MISMO_BANCO = "http://localhost:8080/SistemaBancario/ws/serv/depositar";
	private String WS_SAVE_RETIRO_CUENTA_MISMO_BANCO = "http://localhost:8080/SistemaBancario/ws/serv/retirar";

	public Respuesta registraTransferenciaentrecuentas(TransaccionFachada transaccionFachada) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(WS_SAVE_TRANSFERENCIA_ENTRE_CUENTAS_MISMO_BANCO);
		Respuesta respuesta = target.request().post(Entity.json(transaccionFachada), Respuesta.class);

		return respuesta;
	}

	public Respuesta registraDeposito(TransaccionFachada transaccionFachada) {

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

}
