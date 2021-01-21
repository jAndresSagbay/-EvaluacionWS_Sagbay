package ec.edu.ups.appdis.g1.EvaluacionWSSagbay.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Credito implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numeroMesePlazo;
	private double monto;
	private Date fechaSolicitud;
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "credito_cuota_id")
    private List<Cuota> cuotas;
	
	
	public void addCredito(Cuota cuota) {
		if (cuotas == null) {
			cuotas = new ArrayList<>();
		}
		///cuenta.setFechaRegistro(new Date());
		cuotas.add(cuota);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumeroMesePlazo() {
		return numeroMesePlazo;
	}


	public void setNumeroMesePlazo(int numeroMesePlazo) {
		this.numeroMesePlazo = numeroMesePlazo;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public List<Cuota> getCuotas() {
		return cuotas;
	}


	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}


	@Override
	public String toString() {
		return "Credito [id=" + id + ", numeroMesePlazo=" + numeroMesePlazo + ", monto=" + monto + ", fechaSolicitud="
				+ fechaSolicitud + ", cuotas=" + cuotas + "]";
	}
	
	

}
