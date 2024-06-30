package ar.edu.unlam.pb2;

import java.util.Objects;

import javax.print.attribute.standard.MediaSize.Other;

public class Cliente {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Double dinero;
	private Integer numTelefono;
	
	
	
	public Cliente(String nombre, String apellido, Integer dni, Double dinero, Integer numTelefono) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.dinero = dinero;
		this.numTelefono = numTelefono;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Double getDinero() {
		return dinero;
	}
	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
	public Integer getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(Integer numTelefono) {
		this.numTelefono = numTelefono;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		Cliente cliente = (Cliente) obj;
		return Objects.equals(dni, cliente.dni);
	}




	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", dinero=" + dinero
				+ ", numTelefono=" + numTelefono + "]";
	}
	
	
	
	
	
}
