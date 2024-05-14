package ar.edu.unlam.pb2;

public  class Propiedad implements Comparable<Propiedad>{

	protected String ciudad;
	protected String calle;
	protected Integer altura;
	protected double mtsCuadrados;
	protected Integer codigo ;
	protected boolean estaDisponible;
	protected double precioVenta;
	protected double precioAlquiler;
	
	
	public Propiedad(String ciudad, String calle, Integer altura, double mtsCuadrados, boolean estaDisponible, Integer codigo, double precioVenta, double precioAlquiler) {
	
		this.ciudad = ciudad;
		this.calle = calle;
		this.altura = altura;
		this.mtsCuadrados = mtsCuadrados;
		this.codigo = codigo;
		this.estaDisponible = true;
		this.precioAlquiler = precioAlquiler;
		this.precioVenta = precioVenta;
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


	public boolean isEstaDisponible() {
		return estaDisponible;
	}


	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	


	public double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}


	public double getPrecioAlquiler() {
		return precioAlquiler;
	}


	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}


	@Override
	public String toString() {
		return "\nPropiedad: \n .Ciudad = " + ciudad + "\n .Calle = " + calle + "\n .Altura = " + altura + "\n .MTS2 = "
				+ mtsCuadrados + "\n .Codigo = " + codigo + "\n .Disponibilidad = " + estaDisponible + "\n .Precio Venta = $"
				+ precioVenta + "\n .Precio Alquiler = $" + precioAlquiler + "\n............................................." ;
	}
	
	public int compareTo(Propiedad propiedad) {
		if(propiedad.getPrecioVenta()>precioVenta) {
			return -1;
		} else if(propiedad.getPrecioVenta()>precioVenta) {
			return 0;
		} else {
			return 1;
		}
	}
	
	
	
	
	
	
	
	
}
