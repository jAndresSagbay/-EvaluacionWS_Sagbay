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
	
	public Respuesta crearPoliza(Fachada fachada) {
		
		Respuesta respuesta = new Respuesta();
		Cliente clienteCuenta= clientedao.buscarClienteCuenta(fachada.getNumeroCuenta());
		boolean cuentaexiste=clienteCuenta.getCuenta()==fachada.getNumeroCuenta();
		
		boolean cuentacedulaexiste= clienteCuenta.getCedula().equals(fachada.getCedula());
		System.out.println(cuentacedulaexiste);
		 if (cuentaexiste==false) {
			respuesta.setCodigo(50);
			respuesta.setMensaje("Error cuenta incorrecta");
		
		} else if (cuentacedulaexiste==false) {
				respuesta.setCodigo(50);
				respuesta.setMensaje("Error cedula incorrecta");
				
		}else if (cuentaexiste==true && cuentacedulaexiste==true) {
			
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
				
				System.out.println("CREDITO >>>> >>>> "+credito.toString());
			clienteCuenta.addCredito(credito);
			System.out.println(clienteCuenta.toString());
			clientedao.actualizarCliente(clienteCuenta);
			respuesta.setCodigo(1);
			respuesta.setMensaje("ok");
			}
			
		}
		
		return respuesta;
	}

	public List<Cuota> mostrarCuotas() {
		return this.cuotadao.mostrarCuotas();
	}

}
