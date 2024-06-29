package ar.edu.unlam.pb2;


public abstract class Operacion {

	protected Integer idOperacion = 1;
	protected tipoOperacion tipo;
	
	
	
	public Operacion( tipoOperacion tipo) {
	
		this.idOperacion ++;
		this.tipo = tipo;
	}
	public Integer getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}
	public tipoOperacion getTipo() {
		return tipo;
	}
	public void setTipo(tipoOperacion tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
	
	
	
	
	

	
}
