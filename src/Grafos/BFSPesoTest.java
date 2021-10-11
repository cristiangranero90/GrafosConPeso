package Grafos;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class BFSPesoTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		BFSPeso.esConexo(null);
	}

	@Test
	public void vacioTest() {
		GrafoConPeso g = new GrafoConPeso(1);
		assertTrue(BFSPeso.esConexo(g));
	}

	@Test
	public void alcanzablesTest() {
		GrafoConPeso g = inicializarGrafo();
		Set<Integer> alcanzables = BFSPeso.alcanzables(g, 0);
		int[] esperados = { 0, 1, 2, 3 };
		assertEquals(esperados.length, alcanzables.size());
	}

	@Test
	public void conexoTest() {
		GrafoConPeso g = inicializarGrafo();
		g.agregarArista(3, 4, 5);
		assertTrue(BFSPeso.esConexo(g));
	}

	@Test
	public void noConexoTest() {
		GrafoConPeso g = inicializarGrafo();
		assertFalse(BFSPeso.esConexo(g));
	}

	@Test
	public void damePesoDeAristaTest() {
		GrafoConPeso grafo = inicializarGrafo();
		assertEquals(grafo.obtenerPesoArista(2, 3), 5);
	}

	@Test
	public void damePesoDeAristaInexistenteTest() {
		GrafoConPeso grafo = inicializarGrafo();
		assertEquals(grafo.obtenerPesoArista(1, 2), 0);
	}

	private GrafoConPeso inicializarGrafo() {
		GrafoConPeso grafoConPeso = new GrafoConPeso(5);
		grafoConPeso.agregarArista(0, 1, 3);
		grafoConPeso.agregarArista(0, 2, 3);
		grafoConPeso.agregarArista(2, 3, 5);
		return grafoConPeso;
	}

}
