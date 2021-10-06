package utils;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Grafos.GrafoConPeso;

public class GeneradorGrafosConPesoTest {

	@Test(expected = IllegalArgumentException.class) 
	public void testCantAritasDistitntoDeCero() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(5, 0);	
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testCantVerticesDistitntoDeCero() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(0, 5);	
	}
	
	@Test(expected = IllegalArgumentException.class) // Caso borde, de 1 a 9 es vaildo.
	public void testCantAritasValidas() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(5, 10);	
	}
	
	@Test
	public void testGeneradoArista() {
		GrafoConPeso grafo = new GrafoConPeso(3);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(0, 2, 10);
		Arista arista = GeneradorGrafosConPeso.generarAristaValida(grafo);
		grafo.agregarArista(arista.getX(), arista.getY(), 10);
		assertTrue(grafo.existeArista(1, 2));
	}
	
	@Test
	public void testGeneradorGrafoVerticesValidos() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(10, 5);
		assertTrue(grafo.vertices() == 10);
		
	}
	@Test
	public void testGeneradorGrafoAristaValidos() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(10, 5);
		assertTrue(grafo.cantAristas() == 5);
	}
	
	@Test
	public void testGeneradorGrafoVerticesInvalidos() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(10, 5);
		assertFalse(grafo.vertices() == 5);
		
	}
	@Test
	public void testGeneradorGrafoAristaInvalidos() {
		GrafoConPeso grafo = GeneradorGrafosConPeso.generadorDeGrafoConPeso(10, 5);
		assertFalse(grafo.cantAristas() == 10);
	}
	
	
}
