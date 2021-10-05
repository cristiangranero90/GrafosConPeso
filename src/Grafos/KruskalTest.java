package Grafos;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


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
		//AGM_BFS.print();
		//System.out.println("****************************");
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
		//AGM_UnionFind.print();
	}

}
