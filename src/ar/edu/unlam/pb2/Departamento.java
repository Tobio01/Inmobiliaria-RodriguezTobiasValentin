package ar.edu.unlam.pb2;

public class Departamento extends Propiedad {
	private String letraDepto;
	private Integer piso;

	public Departamento(String ciudad, String calle, Integer altura, String letraDepto, Integer piso,
			double mtsCuadrados, boolean estaDisponibleVenta, boolean estaDisponibleAlquiler, Integer codigo, double precioVenta, double precioAlquiler) {
		super(ciudad, calle, altura, mtsCuadrados, estaDisponibleVenta, estaDisponibleAlquiler, codigo, precioVenta, precioAlquiler);

		this.letraDepto = letraDepto;
		this.piso = piso;

	}

	public String getLetraDepto() {
		return letraDepto;
	}

	public void setLetraDepto(String letraDepto) {
		this.letraDepto = letraDepto;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	@Override
	public String toString() {
		return "\nPropiedad: \n .Ciudad = " + ciudad + "\n .Calle = " + calle + "\n .Altura = " + altura + "\n .Piso = "
				+ piso + "\n .Letra = " + letraDepto + "\n .MTS2 = " + mtsCuadrados + "\n .Codigo = " + codigo
				+ "\n .Disponibilidad Venta = " + estaDisponibleVenta + "\n .Disponibilidad Alquiler = "
				+ estaDisponibleAlquiler + "\n .Precio Venta = $" + precioVenta + "\n .Precio Alquiler = $"
				+ precioAlquiler + "\n.............................................";
	}

}
