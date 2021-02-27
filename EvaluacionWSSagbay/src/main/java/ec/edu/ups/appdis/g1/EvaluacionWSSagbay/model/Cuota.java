package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cuota implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4707012973351643803L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Double valor;
	private int numeroCuota;
	private Date fechaAsignada;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public Date getFechaAsignada() {
		return fechaAsignada;
	}
	public void setFechaAsignada(Date fechaAsignada) {
		this.fechaAsignada = fechaAsignada;
	}
	@Override
	public String toString() {
		return "Cuota [id=" + id + ", valor=" + valor + ", numeroCuota=" + numeroCuota + ", fechaAsignada="
				+ fechaAsignada + "]";
	}
	
	
	
	
	

}
