package Grafos;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import utils.Arista;


public class KruskalTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void kruskalBFS() {
		GrafoConPeso grafo = new GrafoConPeso(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(2, 3, 8);
		GrafoConPeso AGM_BFS =  Kruskal.kruskalBFS(grafo);
		assertTrue(AGM_BFS.existeArista(0, 1));
		assertTrue(AGM_BFS.existeArista(2, 1));
		assertTrue(AGM_BFS.existeArista(2, 3));
	}

	@Test
	public void kruskalUnionFind() {
		GrafoConPeso grafo = new GrafoConPeso(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(2, 3, 8);
		GrafoConPeso AGM_UnionFind =  Kruskal.kruskalUnionFind(grafo);
		assertTrue(AGM_UnionFind.existeArista(0, 1));
		assertTrue(AGM_UnionFind.existeArista(2, 1));
		assertTrue(AGM_UnionFind.existeArista(2, 3));
	}
	
	@Test
	public void testAristaMinimaBFSValida() {
		GrafoConPeso grafo = new GrafoConPeso(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(2, 3, 8);
		
		HashSet<Arista> aristasAparecidas = new HashSet<>();
		aristasAparecidas.add(new Arista(0,1,5));
		aristasAparecidas.add(new Arista(1,2,2));
		
		GrafoConPeso AGM = new GrafoConPeso(grafo.vertices());
		
		AGM.agregarArista(0, 1, 5);
		AGM.agregarArista(1, 2, 2);
	
		Kruskal.setAGM(AGM);
		Kruskal.setAristasAparecidas(aristasAparecidas);
		
		Arista aristaMinima = Kruskal.aristaMinimaSinCircuitoBFS(grafo);
		
		assertTrue(aristaMinima.getX() == 2 || aristaMinima.getX() == 3);
		assertTrue(aristaMinima.getY() == 2 || aristaMinima.getY() == 3);
	}
	
	@Test
	public void testAristaMinimaBFSInvalida() {
		GrafoConPeso grafo = new GrafoConPeso(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(2, 3, 8);
		
		HashSet<Arista> aristasAparecidas = new HashSet<>();
		aristasAparecidas.add(new Arista(0,1,5));
		aristasAparecidas.add(new Arista(1,2,2));
		
		GrafoConPeso AGM = new GrafoConPeso(grafo.vertices());
		
		AGM.agregarArista(0, 1, 5);
		AGM.agregarArista(1, 2, 2);
	
		Kruskal.setAGM(AGM);
		Kruskal.setAristasAparecidas(aristasAparecidas);
		
		Arista aristaMinima = Kruskal.aristaMinimaSinCircuitoBFS(grafo);
		
		assertFalse((aristaMinima.getX() == 2 && aristaMinima.getY() == 0) || (aristaMinima.getX() == 0 && aristaMinima.getY() == 2));
		
	}
	
	@Test
	public void testAristaMinimaUnionFindValido() {
		GrafoConPeso grafo = new GrafoConPeso(4);
		
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(2, 3, 8);
		
		int[] raices = new int[grafo.vertices()];
		for (int i = 0; i < grafo.vertices(); i++) {
			raices[i] = i;
		}
		
		HashSet<Arista> aristasAparecidas = new HashSet<>();
		aristasAparecidas.add(new Arista(0,1,5));
		aristasAparecidas.add(new Arista(1,2,2));
		
		Kruskal.setRaices(raices);
		
		Kruskal.union(0, 1);
		Kruskal.union(1, 2);
		
		GrafoConPeso AGM = new GrafoConPeso(grafo.vertices());
		
		Kruskal.setAGM(AGM);
		Kruskal.setAristasAparecidas(aristasAparecidas);
		
		Arista aristaMinima = Kruskal.aristaMinimaSinCircuitoUnionFind(grafo);
					
		assertTrue(aristaMinima.getX() == 2 || aristaMinima.getX() == 3);
		assertTrue(aristaMinima.getY() == 2 || aristaMinima.getY() == 3);
	}
	
	@Test
	public void testAristaMinimaUnionFindInvalido() {
		GrafoConPeso grafo = new GrafoConPeso(4);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(2, 3, 8);
		int[] raices = new int[grafo.vertices()];
		
		for (int i = 0; i < grafo.vertices(); i++) {
			raices[i] = i;
		}
		
		HashSet<Arista> aristasAparecidas = new HashSet<>();
		aristasAparecidas.add(new Arista(0,1,5));
		aristasAparecidas.add(new Arista(1,2,2));
		
		GrafoConPeso AGM = new GrafoConPeso(grafo.vertices());
		
		AGM.agregarArista(0, 1, 5);
		AGM.agregarArista(1, 2, 2);
	
		Kruskal.setAGM(AGM);
		Kruskal.setAristasAparecidas(aristasAparecidas);
		Kruskal.setRaices(raices);
		
		Arista aristaMinima = Kruskal.aristaMinimaSinCircuitoUnionFind(grafo);
		
		assertFalse((aristaMinima.getX() == 2 && aristaMinima.getY() == 0) || (aristaMinima.getX() == 0 && aristaMinima.getY() == 2));
	}
}
