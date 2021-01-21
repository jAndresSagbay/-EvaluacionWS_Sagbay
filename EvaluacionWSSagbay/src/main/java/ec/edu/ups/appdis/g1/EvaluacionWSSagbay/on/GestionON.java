package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.on;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao.ClienteDao;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao.CreditoDao;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.dao.CuotaDao;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Cliente;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Credito;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Cuota;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model.Fachada;
import ec.edu.ups.appdis.g1.EvaluacionWSSagbay.utils.Respuesta;


@Stateless
public class GestionON {
	@Inject
	ClienteDao clientedao;
	@Inject
	CreditoDao creditodao;
	@Inject
	CuotaDao cuotadao;
	
	public Respuesta CrearPoliza(Fachada fachada) {
		Respuesta respuesta= new Respuesta();
		
		
		Cliente clienteCuenta= clientedao.buscarClientecuenta(fachada.getNumeroCuenta());
		Cliente clienteCedula  = clientedao.buscarClienteCedulaP(fachada.getCedula());
		if (clienteCuenta== null) {
			respuesta.setCodigo(50);
			respuesta.setMensaje("Error cuenta incorrecta");
			
		}else if (clienteCedula== null) {
				respuesta.setCodigo(50);
				respuesta.setMensaje("Error cedula incorrecta");
				
		}else if (clienteCedula == null && clienteCuenta == null) {
			respuesta.setCodigo(50);
			respuesta.setMensaje("Error cliente no existe");
		
		}else {
			Credito credito= new Credito();
			credito.setFechaSolicitud(new Date());
			credito.setMonto(fachada.getValorDecredito());
			credito.setNumeroMesePlazo(fachada.getNumerodemesesplazo());
			Double valorCuotasDouble=(fachada.getValorDecredito()/fachada.getNumerodemesesplazo());
			for (int i = 0; i < fachada.getNumerodemesesplazo(); i++) {
				Cuota cuota= new Cuota();
				cuota.setNumeroCuota(i+1);
				cuota.setValor(valorCuotasDouble);
				cuota.setFechaAsignada(new Date());
				credito.addCredito(cuota);
			}
						
			
			creditodao.crearCredito(credito);
		}
		
		return respuesta;
	}

	public List<Cuota> mostrarCuotas() {
		return this.cuotadao.mostrarCuotas();
	}

}
