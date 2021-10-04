package utils;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Grafos.GrafoConPeso;

public class GeneradorGrafosConPesoTest {

	private Set<GrafoConPeso> grafos;
	private int cantGrafos = 5;
	private int cantVertices = 5;
	private int cantAristas = 5;
	
	@Before
	public void setUp() throws Exception {
		int cantGrafos = 5;
		int cantVertices = 5;
		int cantAristas = 5;
		grafos = GeneradorGrafosConPeso.generadorDeGrafosConPeso(cantGrafos, cantVertices, cantAristas );
		
	}
	
	@Test
	public void cantGrafosCorrectaTest() {
		assertTrue(grafos.size() == cantGrafos);
	}

	@Test
	public void verticesCorrectosTest() {
		for (GrafoConPeso grafo : grafos) {
			boolean cantVerticesCorrectos = grafo.vertices() == cantVertices;
			assertTrue(cantVerticesCorrectos);
		}
	}
	
	@Test
	public void aristasCorrectas() {
		for (GrafoConPeso grafo : grafos) {
			boolean  cantAristasCorrectas = grafo.cantAristas() == cantAristas;
			assertTrue(cantAristasCorrectas);
		}
	}
	
	
	
	/*
	 * @Test public void verGrafos() { for (GrafoConPeso grafo : grafos) { boolean
	 * cantVerticesCorrectos = grafo.vertices() == cantVertices;
	 * assertTrue(cantVerticesCorrectos); grafo.print();
	 * System.out.println("***********************************"); } }
	 */
	 
	 
	

}
