package ar.edu.unlam.pb2;

public class Cliente {

	private String nombre;
	private String apellido;
	private int dni;
	private double dinero;
	private Integer numTelefono;
	
	
	
	public Cliente(String nombre, String apellido, int dni, double dinero, Integer numTelefono) {
		
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
	public void setDni(int dni) {
		this.dni = dni;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public Integer getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(Integer numTelefono) {
		this.numTelefono = numTelefono;
	}
	
	
	
	
}
