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
public class Cliente implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7079790634436582390L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String Nombre;
	private String apellido;
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cuenta;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_credito_id")
    private List<Credito> creditos;
	
	
	public void addCredito(Credito credito) {
		if (creditos == null) {
			creditos = new ArrayList<>();
		}
		///cuenta.setFechaRegistro(new Date());
		creditos.add(credito);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getCuenta() {
		return cuenta;
	}


	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}


	public List<Credito> getCreditos() {
		return creditos;
	}


	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", Nombre=" + Nombre + ", apellido=" + apellido
				+ ", cuenta=" + cuenta + ", creditos=" + creditos + "]";
	}
	
}
