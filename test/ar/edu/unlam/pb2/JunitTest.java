package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unlam.pb2.Casa;
import ar.edu.unlam.pb2.Cliente;
import ar.edu.unlam.pb2.Departamento;
import ar.edu.unlam.pb2.Inmobiliaria;
import ar.edu.unlam.pb2.Propiedad;
import ar.edu.unlam.pb2.SinResultadosException;
import ar.edu.unlam.pb2.UmbralMinimoException;

public class JunitTest {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, null);

		boolean seAgrego = inmobiliaria.agregarPropiedad(casa);

		assertTrue(seAgrego);

	}

	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, null);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);

		boolean seAgrego = inmobiliaria.agregarPropiedad(casa);
		boolean seAgrego2 = inmobiliaria.agregarPropiedad(casa2);

		assertTrue(seAgrego);
		assertTrue(seAgrego2);

	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 70000, 200,
				null);

		boolean seAgrego = inmobiliaria.agregarPropiedad(dpto);

		assertTrue(seAgrego);

	}

	@Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 70000, 200,
				null);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 70000, 200,
				null);

		boolean seAgrego = inmobiliaria.agregarPropiedad(dpto);
		boolean seAgrego2 = inmobiliaria.agregarPropiedad(dpto2);

		assertTrue(seAgrego);
		assertTrue(seAgrego2);

	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 70000, 200,
				null);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, null);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);

		double valorEsperado = 250000;

		assertEquals(valorEsperado, inmobiliaria.obtenerValorPromedioDeLasCasas(), 0.01);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, null);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa);

		double valorEsperado = 70000;

		assertEquals(valorEsperado, inmobiliaria.obtenerValorPromedioDeLosDepartamentos(), 0.01);
	}

	@Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 25528261, 200000.0, 1166668099);

		boolean seAgrego = inmobiliaria.agregarCliente(cliente);

		assertTrue(seAgrego);
	}

	@Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 44513673, 200000.0, 1166668099);
		Cliente cliente2 = new Cliente("Tobias", "Rodriguez", 44513673, 200000.0, 1166743592);

		inmobiliaria.agregarCliente(cliente);
		boolean seAgrego = inmobiliaria.agregarCliente(cliente2);

		assertFalse(seAgrego);
	}

	@Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws UmbralMinimoException {

		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, null);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);
		Casa casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, true, 0, 400000, 1000, null);
		Casa casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, true, 0, 100000, 300, null);

		Cliente comprador = new Cliente("Jose Luis", "Rodriguez", 44513673, 20000000.0, 1166668099);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);
		
		

		assertTrue(inmobiliaria.EjecutarVentaPropiedad(1, comprador));

	}

	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() throws UmbralMinimoException {

		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, null);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);
		Casa casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, true, 0, 400000, 1000, null);
		Casa casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, true, 0, 100000, 300, null);

		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 44513673, 1000.0, 1166668099);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);

		assertTrue(inmobiliaria.EjecutarAlquilerPropiedad(2, cliente));

	}

	@Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades() throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Cliente clienteX = new Cliente("Tobias", "Rodriguez", 1, 10000.0, 123);
		Cliente clienteY = new Cliente("Agustin", "Dangelo", 2, 10000.0, 1234);

		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000, clienteX);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, clienteY);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);

		inmobiliaria.agregarCliente(clienteX);
		inmobiliaria.agregarCliente(clienteY);
		
		

		assertTrue(inmobiliaria.EjecutarPermutaPropiedad(1, 2));

		

	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Propiedad casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000,
				null);
		Propiedad casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);
		Propiedad casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, true, 0, 400000, 1000, null);
		Propiedad casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, true, 0, 100000, 300, null);
		Propiedad dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Propiedad dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);

		Integer tamañoArrayListEsperado = 3;
		Propiedad propiedadEsperadaIncio = casa4;
		Propiedad propiedadEsperadaFinal = casa;

		ArrayList<Propiedad> propiedadesListado = inmobiliaria.obtenerListadoRangoPrecioDeLasCasas(0.0, 350000.0);

		assertEquals(tamañoArrayListEsperado, propiedadesListado.size(), 0.1);
		assertEquals(propiedadEsperadaIncio, propiedadesListado.get(0));
		assertEquals(propiedadEsperadaFinal, propiedadesListado.get(2));

	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Propiedad casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000,
				null);
		Propiedad casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);
		Propiedad dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Propiedad dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);
		Propiedad dpto3 = new Departamento("Palermo", "Humboldt", 985, "C", 2, 25, true, true, 0, 200000, 200, null);
		Propiedad dpto4 = new Departamento("Puerto Madero", "Av. del Libertador", 13586, "F", 8, 25, true, true, 0,
				120000, 200, null);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(dpto3);
		inmobiliaria.agregarPropiedad(dpto4);

		Integer tamañoArrayListEsperado = 3;
		Propiedad propiedadEsperadaIncio = dpto;
		Propiedad propiedadEsperadaFinal = dpto4;
		ArrayList<Propiedad> propiedadesListado = inmobiliaria.obtenerListadoRangoPrecioDeLosDptos(0.0, 190000.0);

		assertEquals(tamañoArrayListEsperado, propiedadesListado.size(), 0.1);
		assertEquals(propiedadEsperadaIncio, propiedadesListado.get(0));
		assertEquals(propiedadEsperadaFinal, propiedadesListado.get(2));

	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws UmbralMinimoException, SinResultadosException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Propiedad casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000,
				null);
		Propiedad casa2 = new Casa("Parque Patricios", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300,
				null);
		Propiedad casa3 = new Casa("Parque Patricios", "Brandsen", 805, 50, true, true, 0, 400000, 1000, null);
		Propiedad casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, true, 0, 100000, 300, null);
		Propiedad dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Propiedad dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);

		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(casa4);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);

		Integer tamañoArrayListEsperado = 3;
		Propiedad propiedadEsperadaIncio = casa;
		Propiedad propiedadEsperadaFinal = casa3;

		ArrayList<Propiedad> propiedadesListado = inmobiliaria.obtenerListadoUbicacionDeLasCasas("Parque Patricios");

		assertEquals(tamañoArrayListEsperado, propiedadesListado.size(), 0.1);
		assertEquals(propiedadEsperadaIncio, propiedadesListado.get(0));
		assertEquals(propiedadEsperadaFinal, propiedadesListado.get(2));

	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws UmbralMinimoException, SinResultadosException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Propiedad casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 350000, 1000,
				null);
		Propiedad casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);
		Propiedad dpto = new Departamento("Ramos Mejia", "Rivadavia", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Propiedad dpto2 = new Departamento("Ramos Mejia", "Av.de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);
		Propiedad dpto3 = new Departamento("Ramos Mejia", "Humboldt", 985, "C", 2, 25, true, true, 0, 200000, 200,
				null);
		Propiedad dpto4 = new Departamento("Ramos Mejia", "Libertador", 13586, "F", 8, 25, true, true, 0, 120000, 200,
				null);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(dpto3);
		inmobiliaria.agregarPropiedad(dpto4);

		Integer tamañoArrayListEsperado = 4;
		Propiedad propiedadEsperadaIncio = dpto2;
		Propiedad propiedadEsperadaFinal = dpto;
		ArrayList<Propiedad> propiedadesListado = inmobiliaria.obtenerListadoUbicacionDeLosDeptos("Ramos Mejia");

		assertEquals(tamañoArrayListEsperado, propiedadesListado.size(), 0.1);
		assertEquals(propiedadEsperadaIncio, propiedadesListado.get(0));
		assertEquals(propiedadEsperadaFinal, propiedadesListado.get(3));

	}

	@Test(expected = UmbralMinimoException.class)
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException()
			throws UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Propiedad casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 8000, 1000, null);

		inmobiliaria.agregarPropiedad(casa);

		assertTrue(inmobiliaria.getPropiedades().isEmpty());

	}

	@Test(expected = SinResultadosException.class)
	public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException()
			throws SinResultadosException, UmbralMinimoException {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Propiedad casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, true, 0, 80000, 1000, null);
		Propiedad casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, true, 0, 150000, 300, null);
		Propiedad dpto = new Departamento("Ramos Mejia", "Rivadavia", 7555, "A", 4, 25, true, true, 0, 50000, 200,
				null);
		Propiedad dpto2 = new Departamento("Ramos Mejia", "Av.de Mayo", 7555, "B", 4, 25, true, true, 0, 90000, 200,
				null);
		Propiedad dpto3 = new Departamento("Ramos Mejia", "Humboldt", 985, "C", 2, 25, true, true, 0, 200000, 200,
				null);

		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(dpto3);
		

		assertTrue(inmobiliaria.obtenerListadoUbicacionDeLasCasas("La Tablada").isEmpty());
		assertTrue(inmobiliaria.obtenerListadoUbicacionDeLosDeptos("Nuñez").isEmpty());

		assertTrue(inmobiliaria.obtenerListadoRangoPrecioDeLasCasas(0.0,70000.0 ).isEmpty());
		assertTrue(inmobiliaria.obtenerListadoRangoPrecioDeLosDptos(0.0,80000.0).isEmpty());

	}

}
