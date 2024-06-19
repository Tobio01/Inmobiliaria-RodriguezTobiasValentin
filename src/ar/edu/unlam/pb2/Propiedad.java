package ar.edu.unlam.pb2;

public abstract class Propiedad implements Comparable<Propiedad> {

	protected String ciudad;
	protected String calle;
	protected Integer altura;
	protected double mtsCuadrados;
	protected Integer codigo;
	protected boolean estaDisponibleVenta;
	protected boolean estaDisponibleAlquiler;
	protected Double precioVenta;
	protected double precioAlquiler;
	protected Cliente dueño;

	public Propiedad(String ciudad, String calle, Integer altura, double mtsCuadrados, boolean estaDisponibleVenta,
			boolean estaDisponibleAlquiler, Integer codigo, Double precioVenta, double precioAlquiler, Cliente dueño) {

		this.ciudad = ciudad;
		this.calle = calle;
		this.altura = altura;
		this.mtsCuadrados = mtsCuadrados;
		this.codigo = codigo;
		this.estaDisponibleVenta = true;
		this.estaDisponibleAlquiler = true;
		this.precioAlquiler = precioAlquiler;
		this.precioVenta = precioVenta;
		this.dueño = dueño;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public double getMtsCuadrados() {
		return mtsCuadrados;
	}

	public void setMtsCuadrados(double mtsCuadrados) {
		this.mtsCuadrados = mtsCuadrados;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public boolean isEstaDisponibleVenta() {
		return estaDisponibleVenta;
	}

	public void setEstaDisponibleVenta(boolean estaDisponibleVenta) {
		this.estaDisponibleVenta = estaDisponibleVenta;
	}

	public boolean isEstaDisponibleAlquiler() {
		return estaDisponibleAlquiler;
	}

	public void setEstaDisponibleAlquiler(boolean estaDisponibleAlquiler) {
		this.estaDisponibleAlquiler = estaDisponibleAlquiler;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	

	public Cliente getDueño() {
		return dueño;
	}

	public void setDueño(Cliente dueño) {
		this.dueño = dueño;
	}

	@Override
	public String toString() {
		return "\nPropiedad: \n .Ciudad = " + ciudad + "\n .Calle = " + calle + "\n .Altura = " + altura + "\n .MTS2 = "
				+ mtsCuadrados + "\n .Codigo = " + codigo + "\n .Disponibilidad Venta = " + estaDisponibleVenta
				+ "\n .Disponibilidad Alquiler = " + estaDisponibleAlquiler + "\n .Precio Venta = $" + precioVenta
				+ "\n .Precio Alquiler = $" + precioAlquiler + "\n.............................................";
	}

	public int compareTo(Propiedad propiedad) {
		if (propiedad.getPrecioVenta() > precioVenta) {
			return -1;
		} else if (propiedad.getPrecioVenta() > precioVenta) {
			return 0;
		} else {
			return 1;
		}
	}

}
