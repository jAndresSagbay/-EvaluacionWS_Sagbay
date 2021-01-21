package ec.edu.ups.appdis.g1.clienteRest.clienterest;

import java.util.List;

import ec.edu.ups.appdis.g1.clienteRest.model.Fachada;
import ec.edu.ups.appdis.g1.clienteRest.model.Respuesta;
import ec.edu.ups.appdis.g1.clienteRest.model.TransaccionFachada;



public class Main {

	public static void main(String args[]) {
		
		//CategoriasCli cli = new CategoriasCli();
		TransaccionCli cliente= new TransaccionCli();
		FachadaCli cli = new FachadaCli();
		Fachada fachada= new Fachada();
		fachada.setNumeroCuenta(1);
		fachada.setNumerodemesesplazo(2);
		fachada.setValorDecredito(200.0);
		
		Respuesta respuesta = cli.registra(fachada);
		System.out.println("Retiro: "+respuesta);
		/*
		
		TransaccionFachada trf= new TransaccionFachada();
		trf.setCuentaorigen(1);
		trf.setCuentadestino(2);
		trf.setMonto(2.75);
		trf.setTipo("transferencia");
		System.out.println(trf.toString());
		
		TransaccionFachada trfDeposito= new TransaccionFachada();

		trfDeposito.setCuentadestino(1);
		trfDeposito.setMonto(2958.25);
		trfDeposito.setTipo("deposito");
		System.out.println(trfDeposito.toString());
		
		TransaccionFachada trfRetiro= new TransaccionFachada();

		trfRetiro.setCuentadestino(1);
		trfRetiro.setMonto(10.50);
		trfRetiro.setTipo("retiro");
		System.out.println(trfRetiro.toString());*/
		
		/*
		//Cosumiendo WS-REST de tipo GET que retorna un objeto 
		Categoria cat = cli.getCategoria(100);
		System.out.println(cat);
		
		//Cosumiendo WS-REST de tipo GET que retorna una colección de objeto 
		List<Categoria> categorias = cli.getCategorias();
		System.out.println(categorias);
		
		*/
		
		//Consumiento un WS-REST de tipo POST enviando una entidad como parametro
	/*Respuesta respuesta = cliente.registraTransferenciaentrecuentas(trf);
		System.out.println("Transferencia: "+respuesta);
		
		Respuesta respuestaDeposito = cliente.registraDeposito(trfDeposito);
		System.out.println("Deposito"+respuestaDeposito);
		
		Respuesta respuestaRetiro = cliente.registraRetiro(trfRetiro);
		System.out.println("Retiro: "+respuestaRetiro);*/
		
		//ec.ups.edu.appdis.g1.clientesoap
	}
}
