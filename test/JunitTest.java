import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.Casa;
import ar.edu.unlam.pb2.Cliente;
import ar.edu.unlam.pb2.Departamento;
import ar.edu.unlam.pb2.Inmobiliaria;

public class JunitTest {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		
		boolean seAgrego = inmobiliaria.agregarPropiedad(casa);

		assertTrue(seAgrego);

	}

	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, 0, 150000, 300);

		boolean seAgrego = inmobiliaria.agregarPropiedad(casa);
		boolean seAgrego2 = inmobiliaria.agregarPropiedad(casa2);

		assertTrue(seAgrego);
		assertTrue(seAgrego2);

	}

	@Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);


		boolean seAgrego = inmobiliaria.agregarPropiedad(casa);
		boolean seAgrego2 = inmobiliaria.agregarPropiedad(casa2);

		assertTrue(seAgrego);
		assertFalse(seAgrego2);

	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 70000, 200);

		boolean seAgrego = inmobiliaria.agregarPropiedad(dpto);

		assertTrue(seAgrego);

	}

	@Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 70000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 70000, 200);

		boolean seAgrego = inmobiliaria.agregarPropiedad(dpto);
		boolean seAgrego2 = inmobiliaria.agregarPropiedad(dpto2);

		assertTrue(seAgrego);
		assertTrue(seAgrego2);

	}

	@Test
	public void queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 70000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 70000, 200);

		inmobiliaria.agregarPropiedad(dpto);

		boolean seAgrego = inmobiliaria.agregarPropiedad(dpto2);

		assertFalse(seAgrego);

	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 70000, 200);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, 0, 150000, 300);


		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);

		double valorEsperado = 250000;

		assertEquals(valorEsperado, inmobiliaria.obtenerValorPromedioDeLasCasas(), 0.01);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa);

		double valorEsperado = 70000;

		assertEquals(valorEsperado, inmobiliaria.obtenerValorPromedioDeLosDepartamentos(), 0.01);
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeMeArrojeUnArrayNoNuloSiAplicanResultados() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);

		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);

		assertNotNull(inmobiliaria.obtenerListadoRangoPrecio(40000, 70000));
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);

		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);

		assertNull(inmobiliaria.obtenerListadoRangoPrecio(0, 15000));
	}

	

	@Test
	public void queSePuedaAgregarCliente() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 25528261, 200000, 1166668099);

		boolean seAgrego = inmobiliaria.agregarCliente(cliente);

		assertTrue(seAgrego);
	}

	@Test
	public void queNoSePuedaAgregarClienteConMismoDni() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 44513673, 200000, 1166668099);
		Cliente cliente2 = new Cliente("Tobias", "Rodriguez", 44513673, 200000, 1166743592);

		inmobiliaria.agregarCliente(cliente);
		boolean seAgrego = inmobiliaria.agregarCliente(cliente2);

		assertFalse(seAgrego);
	}
	
	public void queSeOrdenenPorPrecioLasPropiedades() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, 0, 150000, 300);
		Casa casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, 0, 400000, 1000);
		Casa casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, 0, 100000, 300);
		
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);
		
		inmobiliaria.ordenarListadoPorPrecio();
		
		System.out.println(inmobiliaria.getPropiedades().toString());
		
	}
	
	public void queSeOrdenenPorUbicacionLasPropiedades() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);

		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, 0, 150000, 300);
		Casa casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, 0, 400000, 1000);
		Casa casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, 0, 100000, 300);
		
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);
		
		inmobiliaria.ordenarListadoPorPrecio();
		
		System.out.println(inmobiliaria.getPropiedades().toString());
		
	}
	
	@Test
	public void queSePuedaComprarUnaPropiedad() {
		
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, 0, 150000, 300);
		Casa casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, 0, 400000, 1000);
		Casa casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, 0, 100000, 300);
		
		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 44513673, 200000, 1166668099);
		
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);
		
		inmobiliaria.ventaPropiedad(3, cliente);
		
		double dineroEsperado = 150000;
		
		assertEquals(dineroEsperado, cliente.getDinero(),0.1);
		assertFalse(dpto.isEstaDisponible());
		
		
		
		
	}
	@Test
	public void queNoSePuedaComprarUnaPropiedadSiClienteNoTieneDineroSuficiente() {
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		
		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 44513673, 40000, 1166668099);
		
		inmobiliaria.agregarPropiedad(dpto);
		
		inmobiliaria.ventaPropiedad(1, cliente);
		
		double dineroEsperado = 40000;
		
		assertEquals(dineroEsperado, cliente.getDinero(),0.1);
		assertTrue(dpto.isEstaDisponible());
	}
	@Test
	public void queSePuedaAlquilarUnaPropiedad() {
		
		Inmobiliaria inmobiliaria = new Inmobiliaria("Boxer", "Barros Pasos 1758", 44538431);
		Departamento dpto = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "A", 4, 25, true, 0, 50000, 200);
		Departamento dpto2 = new Departamento("Ramos Mejia", "Av. de Mayo", 7555, "B", 4, 25, true, 0, 90000, 200);
		Casa casa = new Casa("Parque Patricios", "Av Amancio Alcorta", 2544, 50, true, 0, 350000, 1000);
		Casa casa2 = new Casa("Nuñez", "Av Pres Figueroa Alcorta", 7597, 70, true, 0, 150000, 300);
		Casa casa3 = new Casa("La Boca", "Brandsen", 805, 50, true, 0, 400000, 1000);
		Casa casa4 = new Casa("Avellaneda", "Ricardo Enrique Bochini", 751, 70, true, 0, 100000, 300);
		
		Cliente cliente = new Cliente("Jose Luis", "Rodriguez", 44513673, 1000, 1166668099);
		
		inmobiliaria.agregarPropiedad(casa);
		inmobiliaria.agregarPropiedad(casa2);
		inmobiliaria.agregarPropiedad(dpto);
		inmobiliaria.agregarPropiedad(dpto2);
		inmobiliaria.agregarPropiedad(casa3);
		inmobiliaria.agregarPropiedad(casa4);
		
		inmobiliaria.alquilerPropiedad(2, cliente);
		
		double dineroEsperado = 700;
		
		assertEquals(dineroEsperado, cliente.getDinero(),0.1);
		assertFalse(casa2.isEstaDisponible());
		
		
		
		
	}

}
