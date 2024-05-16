package ar.edu.unlam.pb2;

import java.util.Scanner;

public class Main {
	static Scanner teclado = new Scanner(System.in);

	static Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

	public static void main(String[] args) {
		int opcion = 0;

		do {
			mostrarMenu();
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {

			case 1:

				System.out.println("Ingrese que tipo de propiedad quiere agregar" + "\n 1. CASA" + "\n 2. DEPARTAMENTO"
						+ "\n 3. PH" + "\n 4. TERRENO" + "\n 5. CAMPO" + "\n 6. REGRESAR ");
				int opcionPropiedad = teclado.nextInt();
				teclado.nextLine();
				switch (opcionPropiedad) {
				case 1:
					inmobiliaria.agregarPropiedad(crearCasa());
					break;

				case 2:
					inmobiliaria.agregarPropiedad(crearDpto());
					break;
				case 3:
					inmobiliaria.agregarPropiedad(crearPh());
					break;
				case 4:
					inmobiliaria.agregarPropiedad(crearTerreno());
					break;
				case 5:
					inmobiliaria.agregarPropiedad(crearCampo());
					break;
				case 6:
					break;
				default:
					System.out.println("Opcion incorrecta");
				}

				break;
			case 2:
				System.out.println("Ingrese el codigo de la propiedad");
				int codigoPropiedad = teclado.nextInt();
				teclado.nextLine();
				if (inmobiliaria.buscarPropiedadPorCodigo(codigoPropiedad) == null) {
					System.err.println("No se ha encontrado ninguna propiedad con ese codigo");
				} else {
					modificarPropiedad(inmobiliaria.buscarPropiedadPorCodigo(codigoPropiedad));
				}
				break;
			case 3:
				if (inmobiliaria.agregarCliente(crearCliente())) {
					System.out.println("Se ha agregado el cliente correctamente :)");
				} else {
					System.err.println("Ya existe un cliente con ese numero de DNI");
				}
				break;
			case 4:
				System.out.println(inmobiliaria.ordenarListadoPorPrecio().toString());
				break;
			case 5:
				System.out.println(inmobiliaria.ordenarListadoPorUbicacion().toString());
				break;
			case 6:
				System.out.println("Ingrese el precio Minimo de busqueda");
				double precioMin = teclado.nextDouble();
				teclado.nextLine();
				System.out.println("Ingrese el precio Maximo de busqueda");
				double precioMax = teclado.nextDouble();
				teclado.nextLine();

				if (inmobiliaria.obtenerListadoRangoPrecio(precioMin, precioMax).isEmpty()) {
					System.out.println("No se encontraron propiedades");
				} else {
					System.out.println(inmobiliaria.obtenerListadoRangoPrecio(precioMin, precioMax).toString());

				}
				break;
			case 7:
				System.out.println("Ingrese la ubicacion a buscar");
				String ubicacion = teclado.nextLine();

				System.out.println(inmobiliaria.obtenerListadoUbicacion(ubicacion).toString());

				break;
			case 8:
				System.out.println("Ingrese 1 para buscar propiedades disponibles para la venta o 2 para alquiler");
				int opcionVentaAlquiler = teclado.nextInt();
				if (opcionVentaAlquiler == 1) {
					System.out.println(inmobiliaria.obtenerListadoVenta().toString());
				} else if (opcionVentaAlquiler == 2) {
					System.out.println(inmobiliaria.obtenerListadoAlquiler().toString());
				} else {
					System.out.println("Opcion Incorrecta");
				}

				break;
			case 9:
				System.out.println("Ingrese el numero de DNI del cliente");
				int dni = teclado.nextInt();
				teclado.nextLine();
				if (inmobiliaria.buscarCliente(dni) == null) {
					System.out.println("No se encontraron clientes con ese numero de DNI");
				} else {
					System.out.println("Ingrese el codigo de la propiedad a vender");
					int codigo = teclado.nextInt();
					teclado.nextLine();
					inmobiliaria.ventaPropiedad(codigo, inmobiliaria.buscarCliente(dni));
				}
				break;
			case 10:
				System.out.println("Ingrese el numero de DNI del cliente");
				int dniAlquiler = teclado.nextInt();
				teclado.nextLine();
				if (inmobiliaria.buscarCliente(dniAlquiler) == null) {
					System.out.println("No se encontraron clientes con ese numero de DNI");
				} else {
					System.out.println("Ingrese el codigo de la propiedad a vender");
					int codigoAlquiler = teclado.nextInt();
					teclado.nextLine();
					inmobiliaria.alquilerPropiedad(codigoAlquiler, inmobiliaria.buscarCliente(dniAlquiler));
				}
				break;
			case 0:
				System.out.println("Gracias por usar el programa");
				break;
			default:
				System.out.println("Opcion incorrecta");
			}

		} while (opcion != 0);

	}

	public static void mostrarMenu() {
		System.out.println(".Ingrese una opcion");

		System.out.println("\n ----> 1. Agregar propiedad <----" + "\n ----> 2. Modificar propiedad <----"
				+ "\n ----> 3. Agregar Cliente <----" + "\n ----> 4. Listado ordenado por Precio <----"
				+ "\n ----> 5. Listado ordenado por Ubicacion <----" + "\n ----> 6. Buscar propiedad Precio <----"
				+ "\n ----> 7. Buscar propiedad por Ubicacion <----"
				+ "\n ----> 8. Buscar propiedad por Venta o Alquiler <----" + "\n ----> 9. Vender Propiedad <----"
				+ "\n ----> 10. Alquilar propiedad <----" + "\n ----> 0. Salir <----");
	}

	public static Casa crearCasa() {

		System.out.println("...Ingrese la ciudad donde se encuentra la propiedad...");
		String ciudad = teclado.nextLine();
		System.out.println("...Ingrese la calle donde se encuentra la propiedad...");
		String calle = teclado.nextLine();
		System.out.println("...Ingrese la altura donde se encuentra la propiedad...");
		Integer altura = teclado.nextInt();
		teclado.nextLine();
		System.out.println("...Ingrese los metros cuadrados de la propiedad...");
		double mtsCuadrados = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de venta de la propiedad...");
		double precioVenta = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de alquiler de la propiedad...");
		double precioAlquiler = teclado.nextDouble();
		teclado.nextLine();

		Casa nueva = new Casa(ciudad, calle, altura, mtsCuadrados, true, true, 0, precioVenta, precioAlquiler);

		return nueva;

	}

	public static Departamento crearDpto() {

		System.out.println("...Ingrese la ciudad donde se encuentra la propiedad...");
		String ciudad = teclado.nextLine();
		System.out.println("...Ingrese la calle donde se encuentra la propiedad...");
		String calle = teclado.nextLine();
		System.out.println("...Ingrese la altura donde se encuentra la propiedad...");
		Integer altura = teclado.nextInt();
		teclado.nextLine();
		System.out.println("...Ingrese el piso de la propiedad...");
		int piso = teclado.nextInt();
		teclado.nextLine();
		System.out.println("...Ingrese la letra de la propiedad...");
		String letra = teclado.nextLine();
		System.out.println("...Ingrese los metros cuadrados de la propiedad...");
		double mtsCuadrados = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de venta de la propiedad...");
		double precioVenta = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de alquiler de la propiedad...");
		double precioAlquiler = teclado.nextDouble();
		teclado.nextLine();

		Departamento nueva = new Departamento(ciudad, calle, altura, letra, piso, mtsCuadrados, true, true, 0,
				precioVenta, precioAlquiler);

		return nueva;

	}

	public static PH crearPh() {

		System.out.println("...Ingrese la ciudad donde se encuentra la propiedad...");
		String ciudad = teclado.nextLine();
		System.out.println("...Ingrese la calle donde se encuentra la propiedad...");
		String calle = teclado.nextLine();
		System.out.println("...Ingrese la altura donde se encuentra la propiedad...");
		Integer altura = teclado.nextInt();
		teclado.nextLine();
		System.out.println("...Ingrese los metros cuadrados de la propiedad...");
		double mtsCuadrados = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de venta de la propiedad...");
		double precioVenta = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de alquiler de la propiedad...");
		double precioAlquiler = teclado.nextDouble();
		teclado.nextLine();

		PH nueva = new PH(ciudad, calle, altura, mtsCuadrados, true, true, 0, precioVenta, precioAlquiler);

		return nueva;

	}

	public static Campo crearCampo() {

		System.out.println("...Ingrese la ciudad donde se encuentra la propiedad...");
		String ciudad = teclado.nextLine();
		System.out.println("...Ingrese la calle donde se encuentra la propiedad...");
		String calle = teclado.nextLine();
		System.out.println("...Ingrese la altura donde se encuentra la propiedad...");
		Integer altura = teclado.nextInt();
		teclado.nextLine();
		System.out.println("...Ingrese los metros cuadrados de la propiedad...");
		double mtsCuadrados = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de venta de la propiedad...");
		double precioVenta = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de alquiler de la propiedad...");
		double precioAlquiler = teclado.nextDouble();
		teclado.nextLine();

		Campo nueva = new Campo(ciudad, calle, altura, mtsCuadrados, true, true, 0, precioVenta, precioAlquiler);

		return nueva;

	}

	public static Terrenos crearTerreno() {

		System.out.println("...Ingrese la ciudad donde se encuentra la propiedad...");
		String ciudad = teclado.nextLine();
		System.out.println("...Ingrese la calle donde se encuentra la propiedad...");
		String calle = teclado.nextLine();
		System.out.println("...Ingrese la altura donde se encuentra la propiedad...");
		Integer altura = teclado.nextInt();
		teclado.nextLine();
		System.out.println("...Ingrese los metros cuadrados de la propiedad...");
		double mtsCuadrados = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de venta de la propiedad...");
		double precioVenta = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("...Ingrese el precio de alquiler de la propiedad...");
		double precioAlquiler = teclado.nextDouble();
		teclado.nextLine();

		Terrenos nueva = new Terrenos(ciudad, calle, altura, mtsCuadrados, true, true, 0, precioVenta, precioAlquiler);

		return nueva;

	}

	public static Cliente crearCliente() {

		System.out.println("Ingrese el nombre del cliente");
		String nombre = teclado.nextLine();
		System.out.println("Ingrese el apellido del cliente");
		String apellido = teclado.nextLine();
		System.out.println("Ingrese el D.N.I. del cliente");
		int dni = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Ingrese el dinero del cliente");
		double dinero = teclado.nextDouble();
		teclado.nextLine();
		System.out.println("Ingrese el numero de telefono del cliente");
		Integer telefono = teclado.nextInt();
		teclado.nextLine();

		Cliente clienteNuevo = new Cliente(nombre, apellido, dni, dinero, telefono);

		return clienteNuevo;
	}

	public static void modificarPropiedad(Propiedad propiedadModificar) {
		int opcion = 0;
		do {
			System.out.println("Ingrese el valor a modificar:" + "\n 1. Ciudad" + "\n 2. Calle" + "\n 3. Altura"
					+ "\n 4. Metros Cuadrados" + "\n 5. Disponibilidad Venta" + "\n 6. Disponibilidad Alquiler"
					+ "\n 7. Precio Venta" + "\n 8. Precio Alquiler" + "\n 9. Regresar");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Valor actual: ---> " + propiedadModificar.getCiudad());
				System.out.println("...Ingrese la ciudad donde se encuentra la propiedad...");
				String ciudad = teclado.nextLine();
				propiedadModificar.setCiudad(ciudad);
				break;
			case 2:
				System.out.println("Valor actual: ---> " + propiedadModificar.getCalle());
				System.out.println("...Ingrese la calle donde se encuentra la propiedad...");
				String calle = teclado.nextLine();
				propiedadModificar.setCalle(calle);
				break;
			case 3:
				System.out.println("Valor actual: ---> " + propiedadModificar.getAltura());
				System.out.println("...Ingrese la altura donde se encuentra la propiedad...");
				Integer altura = teclado.nextInt();
				teclado.nextLine();
				propiedadModificar.setAltura(altura);
				break;
			case 4:
				System.out.println("Valor actual: ---> " + propiedadModificar.getMtsCuadrados());
				System.out.println("...Ingrese los metros cuadrados de la propiedad...");
				double mtsCuadrados = teclado.nextDouble();
				teclado.nextLine();
				propiedadModificar.setMtsCuadrados(mtsCuadrados);
				break;
			case 5:
				System.out.println("Valor actual: ---> " + propiedadModificar.isEstaDisponibleVenta());
				System.out.println("Ingrese 1 para que la propiedad este disponible, si no lo esta ingrese 2");
				int opcionNumero = teclado.nextInt();
				teclado.nextLine();
				if (opcionNumero == 1) {
					propiedadModificar.setEstaDisponibleVenta(true);
				} else if (opcionNumero == 2) {
					propiedadModificar.setEstaDisponibleVenta(false);
				} else {
					System.out.println("Opcion incorrecta");
				}
				break;
			case 6:
				System.out.println("Valor actual: ---> " + propiedadModificar.isEstaDisponibleVenta());
				System.out.println("Ingrese 1 para que la propiedad este disponible, si no lo esta ingrese 2");
				int opcionNumero1 = teclado.nextInt();
				teclado.nextLine();
				if (opcionNumero1 == 1) {
					propiedadModificar.setEstaDisponibleVenta(true);
				} else if (opcionNumero1 == 2) {
					propiedadModificar.setEstaDisponibleVenta(false);
				} else {
					System.out.println("Opcion incorrecta");
				}
				break;
			case 7:
				System.out.println("Valor actual: ---> " + propiedadModificar.getPrecioVenta());
				System.out.println("...Ingrese el precio de venta de la propiedad...");
				double precioVenta = teclado.nextDouble();
				teclado.nextLine();
				propiedadModificar.setPrecioVenta(precioVenta);
				break;
			case 8:
				System.out.println("Valor actual: ---> " + propiedadModificar.getPrecioAlquiler());
				System.out.println("...Ingrese el precio de alquiler de la propiedad...");
				double precioAlquiler = teclado.nextDouble();
				teclado.nextLine();
				propiedadModificar.setPrecioAlquiler(precioAlquiler);
				break;
			case 9:
				break;
			default:
				System.err.println("Opcion Incorrecta");
			}

		} while (opcion != 9);
	}
}
