package ec.edu.ups.appdis.g1.clienteRest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fachada implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cedula ;
	private int numeroCuenta;
	private Double valorDecredito;
	private int numerodemesesplazo;
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public Double getValorDecredito() {
		return valorDecredito;
	}
	public void setValorDecredito(Double valorDecredito) {
		this.valorDecredito = valorDecredito;
	}
	public int getNumerodemesesplazo() {
		return numerodemesesplazo;
	}
	public void setNumerodemesesplazo(int numerodemesesplazo) {
		this.numerodemesesplazo = numerodemesesplazo;
	}
	@Override
	public String toString() {
		return "Fachada [cedula=" + cedula + ", numeroCuenta=" + numeroCuenta + ", valorDecredito=" + valorDecredito
				+ ", numerodemesesplazo=" + numerodemesesplazo + "]";
	}
	

}
