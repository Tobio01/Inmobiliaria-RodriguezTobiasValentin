package ar.edu.unlam.pb2;

public class Venta extends Operacion {

	private Propiedad propiedadVenta;
	private Cliente comprador;

	public Venta(tipoOperacion tipo, Propiedad propiedadVenta, Cliente comprador) {
		super(tipo);

		this.propiedadVenta = propiedadVenta;
		this.comprador = comprador;
	}

	public Propiedad getPropiedadVenta() {
		return propiedadVenta;
	}

	public void setPropiedadVenta(Propiedad propiedadVenta) {
		this.propiedadVenta = propiedadVenta;
	}

	public Cliente getCliente() {
		return comprador;
	}

	public void setCliente(Cliente cliente) {
		this.comprador = cliente;
	}

	public Boolean ejecutar(Propiedad propiedadVenta) {
		if (!propiedadVenta.isEstaDisponibleVenta()) {
			return false;
		} else if (comprador.getDinero() < propiedadVenta.getPrecioVenta()) {
			return false;
		} else {
			propiedadVenta.setEstaDisponibleVenta(false);
			double dineroClienteActual = comprador.getDinero() - propiedadVenta.getPrecioVenta();
			comprador.setDinero(dineroClienteActual);
			propiedadVenta.setDueño(comprador);
			return true;
		}
	}

}
