package ar.edu.unlam.pb2;

public class Alquiler extends Operacion {

	private Propiedad propiedadAlquiler;
	private Cliente inquilino;

	public Alquiler(tipoOperacion tipo, Propiedad propiedadAlquiler, Cliente inquilino) {
		super(tipo);

		this.propiedadAlquiler = propiedadAlquiler;
		this.inquilino = inquilino;
	}

	public Propiedad getPropiedadAlquiler() {
		return propiedadAlquiler;
	}

	public void setPropiedadAlquiler(Propiedad propiedadAlquiler) {
		this.propiedadAlquiler = propiedadAlquiler;
	}

	public Cliente getInquilino() {
		return inquilino;
	}

	public void setInquilino(Cliente inquilino) {
		this.inquilino = inquilino;
	}

	public Boolean ejecutar(Propiedad propiedadAlquiler) {
		if (!propiedadAlquiler.isEstaDisponibleAlquiler()) {
			return false;
		} else if (inquilino.getDinero() < propiedadAlquiler.getPrecioAlquiler()) {
			return false;
		} else {
			propiedadAlquiler.setEstaDisponibleAlquiler(false);
			double dineroClienteActual = inquilino.getDinero() - propiedadAlquiler.getPrecioAlquiler();
			inquilino.setDinero(dineroClienteActual);
			return true;
		}
	}

	@Override
	public String toString() {
		return "Alquiler [propiedadAlquiler=" + propiedadAlquiler + ", inquilino=" + inquilino + "]";
	}

	
}
