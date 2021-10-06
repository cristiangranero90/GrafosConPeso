package Grafos;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrafoConPesoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test (expected= IllegalArgumentException.class)
	public void testGrafoPesoInvalido() {
		GrafoConPeso grafo = new GrafoConPeso(0);
	}
	@Test
	public void testGrafoPesoValido() {
		GrafoConPeso grafo = new GrafoConPeso(10);
	}

	@Test
	public void testAgregarArista() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 3, 2);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testAgregarAristaIguales() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 2, 2);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testAgregarAristaPesoInvalido() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 3, 0);
	}

	@Test
	public void testExisteArista() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 3, 10);
		
		assertTrue(grafo.existeArista(2, 3));
	}
	
	@Test
	public void testExisteAristaInversa() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 3, 10);
		
		assertTrue(grafo.existeArista(3, 2));
	}
	
	@Test
	public void testExisteAristaInvalida() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 3, 10);
		
		assertFalse(grafo.existeArista(1, 4));
	}

	@Test
	public void testQuitarArista() {
		GrafoConPeso grafo = new GrafoConPeso(6);
		grafo.agregarArista(2, 3, 10);
		
		grafo.quitarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}
	
	@Test
	public void testVecinos() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 2, 3);
		grafo.agregarArista(1, 3, 3);
		grafo.agregarArista(1, 4, 3);
		
		assertEquals(grafo.vecinos(1).size(), 3);
	}
	
	@Test
	public void testVecinosInvalidos() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 2, 3);
		grafo.agregarArista(1, 3, 3);
		grafo.agregarArista(1, 4, 3);
		
		assertFalse(grafo.vecinos(1).size() == 2);
	}
	
	@Test
	public void testCantidadAristas() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 2, 3);
		grafo.agregarArista(1, 3, 3);
		grafo.agregarArista(1, 4, 3);
		assertEquals(3, grafo.cantAristas());
	}
	
	@Test 
	public void testPesoArista() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 2, 3);
		assertEquals(grafo.obtenerPesoArista(1, 2), 3);
	}
	
	
	@Test
	public void testCantidadAristasInvalida() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 2, 3);
		grafo.agregarArista(1, 3, 3);
		grafo.agregarArista(1, 4, 3);
		assertFalse(3 != grafo.cantAristas());
	}
	
	@Test 
	public void testPesoAristaInvalido() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(1, 2, 3);
		assertFalse(grafo.obtenerPesoArista(1, 2) != 3);
	}
	

}
