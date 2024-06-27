package ar.edu.unlam.pb2;

public abstract class Propiedad  {

	protected String ciudad;
	protected String calle;
	protected Integer altura;
	protected Double mtsCuadrados;
	protected Integer codigo;
	protected boolean estaDisponibleVenta;
	protected boolean estaDisponibleAlquiler;
	protected Double precioVenta;
	protected Double precioAlquiler;
	protected Cliente dueño;

	public Propiedad(String ciudad, String calle, Integer altura, Double mtsCuadrados, boolean estaDisponibleVenta,
			boolean estaDisponibleAlquiler, Integer codigo, Double precioVenta, Double precioAlquiler, Cliente dueño) {

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

	public Double getMtsCuadrados() {
		return mtsCuadrados;
	}

	public void setMtsCuadrados(Double mtsCuadrados) {
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

	public Double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(Double precioAlquiler) {
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

	

}
