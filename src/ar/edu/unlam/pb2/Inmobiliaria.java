package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private Integer numTelefono;
	private ArrayList<Propiedad> propiedades;
	private ArrayList<Cliente> clientes;

	public Inmobiliaria(String nombre, String direccion, Integer numTelefono) {

		this.nombre = nombre;
		this.direccion = direccion;
		this.numTelefono = numTelefono;
		this.propiedades = new ArrayList<Propiedad>();
		this.clientes = new ArrayList<Cliente>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(Integer numTelefono) {
		this.numTelefono = numTelefono;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean agregarPropiedad(Propiedad propiedadNueva) {

		if (propiedadNueva instanceof Departamento) {

			Departamento deptoNueva = (Departamento) propiedadNueva;
			for (Propiedad propiedadExistente : propiedades) {
				if (propiedadExistente instanceof Departamento) {
					Departamento deptoExistente = (Departamento) propiedadExistente;
					if (deptoNueva.getCiudad().equals(deptoExistente.getCiudad())
							&& deptoNueva.getCalle().equals(deptoExistente.getCalle())
							&& deptoNueva.getAltura().equals(deptoExistente.getAltura())
							&& deptoNueva.getLetraDepto().equals(deptoExistente.getLetraDepto())
							&& deptoNueva.getPiso().equals(deptoExistente.getPiso())) {
						System.err.println(
								"¡No se puede ingresar una propiedad con la misma direccion de las que ya estan agregadas!");
						return false;
					}
				}
			}
		} else {

			for (Propiedad propiedadExistente : propiedades) {
				if (propiedadNueva.getCiudad().equals(propiedadExistente.getCiudad())
						&& propiedadNueva.getCalle().equals(propiedadExistente.getCalle())
						&& propiedadNueva.getAltura().equals(propiedadExistente.getAltura())) {
					System.err.println(
							"¡No se puede ingresar una propiedad con la misma direccion de las que ya estan agregadas!");
					return false;
				}
			}
		}

		propiedades.add(propiedadNueva);
		propiedadNueva.setCodigo(propiedades.size());
		return true;
	}

	public Propiedad buscarPropiedadPorCodigo(int codigo) {

		for (Propiedad propiedadEncontrada : propiedades) {
			if (propiedadEncontrada.getCodigo() == codigo) {
				return propiedadEncontrada;
			} else {
				System.err.println("No se encontro Ninguna Propiedad");
			}
		}
		return null;

	}

	public boolean agregarCliente(Cliente clienteNuevo) {
		for (Cliente clienteExistente : clientes) {
			if (clienteExistente.getDni() == clienteNuevo.getDni()) {
				return false;
			}
		}

		clientes.add(clienteNuevo);
		return true;
	}

	public Cliente buscarCliente(int dni) {

		for (Cliente clientes : clientes) {
			if (clientes.getDni() == dni) {
				return clientes;
			}
		}
		return null;

	}

	public ArrayList<Propiedad> ordenarListadoPorPrecio() {

		Collections.sort(propiedades);

		return propiedades;

	}

	public ArrayList<Propiedad> ordenarListadoPorUbicacion() {

		Collections.sort(propiedades, (Propiedad p1, Propiedad p2) -> p1.getCiudad().compareTo(p2.getCiudad()));
		return propiedades;
	}

	public double obtenerValorPromedioDeLasCasas() {
		double valorPromedio = 0;
		double valorCasasTotal = 0;
		Integer valorDivisor = 0;

		for (Propiedad propiedadExistente : propiedades) {
			if (propiedadExistente instanceof Casa) {
				valorCasasTotal += propiedadExistente.getPrecioVenta();
				valorDivisor++;

			}

		}
		valorPromedio = valorCasasTotal / valorDivisor;
		return valorPromedio;

	}

	public double obtenerValorPromedioDeLosDepartamentos() {
		double valorPromedio = 0;
		double valorCasasTotal = 0;
		Integer valorDivisor = 0;

		for (Propiedad propiedadExistente : propiedades) {
			if (propiedadExistente instanceof Departamento) {
				valorCasasTotal += propiedadExistente.getPrecioVenta();
				valorDivisor++;

			}

		}
		valorPromedio = valorCasasTotal / valorDivisor;
		return valorPromedio;

	}

	public ArrayList<Propiedad> obtenerListadoRangoPrecio(double precioMin, double precioMax) {
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();

		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes.getPrecioVenta() >= precioMin
					&& propiedadesExistentes.getPrecioVenta() <= precioMax) {
				propiedadesListado.add(propiedadesExistentes);
				
			} 
		}
		if (propiedadesListado.isEmpty()) {
			return null;
		} else {
			return propiedadesListado;
		}
		

	}

	public ArrayList<Propiedad> obtenerListadoUbicacion(String ubicacion) {
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();

		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes.getCiudad().equalsIgnoreCase(ubicacion)) {
				propiedadesListado.add(propiedadesExistentes);

			}
		}
		if (propiedadesListado.isEmpty()) {
			return null;
		} else {
			return propiedadesListado;
		}
	}

	public ArrayList<Propiedad>obtenerListadoVenta(){
 
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();
		
		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes.isEstaDisponibleVenta()) {
				propiedadesListado.add(propiedadesExistentes);
			}
		}
		if (propiedadesListado.isEmpty()) {
			return null;
		} else {
			return propiedadesListado;
		}
	}
	public ArrayList<Propiedad>obtenerListadoAlquiler(){
		 
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();
		
		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes.isEstaDisponibleAlquiler()) {
				propiedadesListado.add(propiedadesExistentes);
			}
		}
		if (propiedadesListado.isEmpty()) {
			return null;
		} else {
			return propiedadesListado;
		}
	}

	public void ventaPropiedad(int codigo, Cliente cliente) {
		boolean propiedadEncontrada = false;
		for (Propiedad propiedad : propiedades) {
			if (propiedad.getCodigo() == codigo) {
				propiedadEncontrada = true;
				if (!propiedad.isEstaDisponibleVenta()) {
					System.err.println("La propiedad no está disponible");
				} else if (cliente.getDinero() < propiedad.getPrecioVenta()) {
					System.err.println("No cuenta con el dinero suficiente para comprar esta propiedad");
				} else {
					propiedad.setEstaDisponibleVenta(false);
					double dineroClienteActual = cliente.getDinero() - propiedad.getPrecioVenta();
					cliente.setDinero(dineroClienteActual);
					System.out.println("¡Felicidades! Usted compró la propiedad");
				}
				break;
			}
		}
		if (!propiedadEncontrada) {
			System.err.println("No existe ninguna propiedad con ese código");
		}
	}

	public void alquilerPropiedad(int codigo, Cliente cliente) {
		boolean propiedadEncontrada = false;
		for (Propiedad propiedad : propiedades) {
			if (propiedad.getCodigo() == codigo) {
				propiedadEncontrada = true;
				if (!propiedad.isEstaDisponibleAlquiler()) {
					System.err.println("La propiedad no está disponible");
				} else if (cliente.getDinero() < propiedad.getPrecioAlquiler()) {
					System.err.println("No cuenta con el dinero suficiente para alquilar esta propiedad");
				} else {
					propiedad.setEstaDisponibleAlquiler(false);
					double dineroClienteActual = cliente.getDinero() - propiedad.getPrecioAlquiler();
					cliente.setDinero(dineroClienteActual);
					System.out.println("¡Felicidades! Usted alquilo la propiedad");
				}
				break;
			}
		}
		if (!propiedadEncontrada) {
			System.err.println("No existe ninguna propiedad con ese código");
		}
	}

}
