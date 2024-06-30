package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private Integer numTelefono;
	private ArrayList<Propiedad> propiedades;
	private HashSet<Cliente> clientes;
	private ArrayList<Operacion> operaciones;
	private static final Double UMBRAL_MINIMO = 10000.0;

	public Inmobiliaria(String nombre, String direccion, Integer numTelefono) {

		this.nombre = nombre;
		this.direccion = direccion;
		this.numTelefono = numTelefono;
		this.propiedades = new ArrayList<Propiedad>();
		this.clientes = new HashSet<Cliente>();
		this.operaciones = new ArrayList<Operacion>();
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

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(ArrayList<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	public Boolean agregarPropiedad(Propiedad propiedadNueva) throws UmbralMinimoException {
		if (propiedadNueva.getPrecioVenta() < UMBRAL_MINIMO) {
			throw new UmbralMinimoException("Umbral Minimo no superado");
		} else {
			propiedades.add(propiedadNueva);
			propiedadNueva.setCodigo(propiedades.size());
			return true;
		}
	}

	public Propiedad buscarPropiedadPorCodigo(Integer codigo) {

		for (Propiedad propiedadEncontrada : propiedades) {
			if (propiedadEncontrada.getCodigo() == codigo) {
				return propiedadEncontrada;
			}
		}
		return null;

	}

	public Boolean agregarCliente(Cliente clienteNuevo) {
		if (clientes.add(clienteNuevo)) {
			return true;
		} else {
			return false;
		}
	}

	public Cliente buscarCliente(Integer dni) {

		for (Cliente clientes : clientes) {
			if (clientes.getDni() == dni) {
				return clientes;
			}
		}
		return null;

	}

	public ArrayList<Propiedad> ordenarListadoPorPrecio() {

		Collections.sort(propiedades, new OrdenarPorPrecio());

		return propiedades;

	}

	public ArrayList<Propiedad> ordenarListadoPorUbicacion() {

		Collections.sort(propiedades, new OrdenarPorUbicacion());
		return propiedades;
	}

	public Double obtenerValorPromedioDeLasCasas() {
		Double valorPromedio = 0.0;
		Double valorCasasTotal = 0.0;
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

	public Double obtenerValorPromedioDeLosDepartamentos() {
		Double valorPromedio = 0.0;
		Double valorCasasTotal = 0.0;
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

	public ArrayList<Propiedad> obtenerListadoRangoPrecioDeLasCasas(Double precioMin, Double precioMax)
			throws SinResultadosException {
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();
		ordenarListadoPorPrecio();
		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes instanceof Casa)
				if (propiedadesExistentes.getPrecioVenta() >= precioMin
						&& propiedadesExistentes.getPrecioVenta() <= precioMax) {
					propiedadesListado.add(propiedadesExistentes);

				}
		}
		if (propiedadesListado.isEmpty()) {
			throw new SinResultadosException("No hay propiedades que coincidan con el atributo");
		} else {
			return propiedadesListado;
		}

	}

	public ArrayList<Propiedad> obtenerListadoRangoPrecioDeLosDptos(Double precioMin, Double precioMax)
			throws SinResultadosException {
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();
		ordenarListadoPorPrecio();
		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes instanceof Departamento)
				if (propiedadesExistentes.getPrecioVenta() >= precioMin
						&& propiedadesExistentes.getPrecioVenta() <= precioMax) {
					propiedadesListado.add(propiedadesExistentes);

				}
		}
		if (propiedadesListado.isEmpty()) {
			throw new SinResultadosException("No hay propiedades que coincidan con el atributo");
		} else {
			return propiedadesListado;
		}

	}

	public ArrayList<Propiedad> obtenerListadoUbicacionDeLasCasas(String ubicacion) throws SinResultadosException {
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();
		ordenarListadoPorUbicacion();
		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes instanceof Casa)
				if (propiedadesExistentes.getCiudad().equalsIgnoreCase(ubicacion)) {
					propiedadesListado.add(propiedadesExistentes);

				}
		}
		if (propiedadesListado.isEmpty()) {
			throw new SinResultadosException("No hay propiedades que coincidan con el atributo");
		} else {
			return propiedadesListado;
		}
	}

	public ArrayList<Propiedad> obtenerListadoUbicacionDeLosDeptos(String ubicacion) throws SinResultadosException {
		ArrayList<Propiedad> propiedadesListado = new ArrayList<Propiedad>();
		ordenarListadoPorUbicacion();
		for (Propiedad propiedadesExistentes : propiedades) {
			if (propiedadesExistentes instanceof Departamento)
				if (propiedadesExistentes.getCiudad().equalsIgnoreCase(ubicacion)) {
					propiedadesListado.add(propiedadesExistentes);

				}
		}
		if (propiedadesListado.isEmpty()) {
			throw new SinResultadosException("No hay propiedades que coincidan con el atributo");
		} else {
			return propiedadesListado;
		}
	}

	public ArrayList<Propiedad> obtenerListadoVenta() {

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

	public ArrayList<Propiedad> obtenerListadoAlquiler() {

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

	public Boolean EjecutarVentaPropiedad(Integer codigo, Cliente comprador) {
		Propiedad propiedadVenta = buscarPropiedadPorCodigo(codigo);
		Venta venta = new Venta(tipoOperacion.VENTA, propiedadVenta, comprador);

		if (propiedadVenta != null) {
			if (venta.ejecutar(propiedadVenta)) {
				operaciones.add(venta);
				return true;
			}

		}
		return false;
	}

	public Boolean EjecutarAlquilerPropiedad(Integer codigo, Cliente inquilino) {
		Propiedad propiedadAlquiler = buscarPropiedadPorCodigo(codigo);
		Alquiler alquiler = new Alquiler(tipoOperacion.ALQUILER, propiedadAlquiler, inquilino);

		if (propiedadAlquiler != null) {
			if (alquiler.ejecutar(propiedadAlquiler)) {
				operaciones.add(alquiler);
				return true;
			}
		}
		return false;
	}

	public Boolean EjecutarPermutaPropiedad(Integer codigoPropiedadA, Integer codigoPropiedadB) {
		Propiedad propiedadA = buscarPropiedadPorCodigo(codigoPropiedadA);
		Propiedad propiedadB = buscarPropiedadPorCodigo(codigoPropiedadB);
		Permuta permuta = new Permuta(tipoOperacion.PERMUTA, propiedadA, propiedadB, propiedadA.getDueño(),
				propiedadB.getDueño());

		if (propiedadA != null && propiedadB != null) {
			permuta.ejecutar(propiedadA, propiedadB);
			operaciones.add(permuta);
			return true;
		}
		return false;
	}

}