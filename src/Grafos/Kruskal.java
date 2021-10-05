package Grafos;

import java.util.HashSet;
import java.util.Set;

import utils.Arista;

public class Kruskal {

	// Para BFS y UnionFind
	private static HashSet<Arista> aristasAparecidas;
	private static GrafoConPeso AGM;

	// Solo para UnionFind
	private static int[] raices;

	public static GrafoConPeso kruskalBFS(GrafoConPeso grafo) {
		long startTime = System.nanoTime();

		// aristasAparecidas = new HashSet<>();
		// AGM = new GrafoConPeso(grafo.vertices());
		inicializarBFS(grafo.vertices());

		int i = 1;
		while (i <= grafo.vertices() - 1) {
			Arista aristaMinima = aristaMinimaSinCircuitoBFS(grafo);
			if (aristaMinima == null)
				break;
			aristasAparecidas.add(aristaMinima);
			AGM.agregarArista(aristaMinima.getX(), aristaMinima.getY(), aristaMinima.getPeso());
			i++;
		}

		long endTime = System.nanoTime() - startTime; // tiempo en que se ejecuta su método
		System.out.println("BFS en nanoseg ::: " + endTime);

		return AGM;
	}

	public static void inicializarBFS(int cantVertices) {
		aristasAparecidas = new HashSet<>();
		AGM = new GrafoConPeso(cantVertices);
	}

	/**
	 * Recibe un GrafoConPeso y retorna la arista mas pequeña que no se encuentre en
	 * el conjunto de aristasAparecidas y que no genere circuto en el arbol generado
	 * minimo AGM, si no hay una arista para elegir se retorna null.
	 * 
	 * @param GrafoConPeso
	 * @param HashSet<Arista> aristasAparecidas
	 * @param GrafoConPeso    AGM
	 * @return Arista, la mas pequeña que no haga circuito en AGM y que no este en
	 *         "aristasAparecidas", sino null.
	 */
	public static Arista aristaMinimaSinCircuitoBFS(GrafoConPeso grafo) {
		int pesoMinimo = Integer.MAX_VALUE;
		Arista aristaMinima = new Arista();
		int[][] matrizAdyacencia = grafo.getA();

		for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAdyacencia[i].length; j++) {

				int pesoArista = matrizAdyacencia[i][j];

				Arista posibleArista = new Arista(i, j, pesoArista);

				boolean aristaLibre = !aristasAparecidas.contains(posibleArista);

				if (aristaLibre && pesoArista < pesoMinimo && pesoArista > 0) {

					Set<Integer> alcanzablesVerticeI = BFSPeso.alcanzables(AGM, i);
					Set<Integer> alcanzablesVerticeJ = BFSPeso.alcanzables(AGM, j);

					boolean generaCircuito = false;

					for (Integer vertice : alcanzablesVerticeI) {
						if (alcanzablesVerticeJ.contains(vertice))
							generaCircuito = true;
						break;
					}

					if (!generaCircuito) {
						pesoMinimo = pesoArista;
						aristaMinima.setX(i);
						aristaMinima.setY(j);
					}
				}
			}
		}

		aristaMinima.setPeso(pesoMinimo);

		if (pesoMinimo == Integer.MAX_VALUE)
			return null;

		return aristaMinima;
	}

	public static GrafoConPeso kruskalUnionFind(GrafoConPeso grafo) {

		long startTime = System.nanoTime();

		inicializarUnionFind(grafo.vertices());
		
		int i = 1;
		while (i <= grafo.vertices() - 1) {
			Arista aristaMinima = aristaMinimaSinCircuitoUnionFind(grafo);
			if (aristaMinima == null)
				break;
			aristasAparecidas.add(aristaMinima);
			AGM.agregarArista(aristaMinima.getX(), aristaMinima.getY(), aristaMinima.getPeso());
			i++;
		}

		long endTime = System.nanoTime() - startTime; // tiempo en que se ejecuta 
		System.out.println("Union Find en nanoseg ::: " + endTime);

		return AGM;
	}

	public static void inicializarUnionFind(int cantVertices) {
		aristasAparecidas = new HashSet<>();
		AGM = new GrafoConPeso(cantVertices);
		// Se setea a cada vertice como raiz de si mismo.
		raices = new int[cantVertices];
		for (int i = 0; i < cantVertices; i++) {
			raices[i] = i;
		}
	}

	public static Arista aristaMinimaSinCircuitoUnionFind(GrafoConPeso grafo) {

		int pesoMinimo = Integer.MAX_VALUE;
		Arista aristaMinima = new Arista();
		int[][] matrizAdyacencia = grafo.getA();

		for (int i = 0; i < matrizAdyacencia.length; i++) {
			for (int j = 0; j < matrizAdyacencia[i].length; j++) {

				int pesoArista = matrizAdyacencia[i][j];

				Arista posibleArista = new Arista(i, j, pesoArista);

				boolean aristaLibre = !aristasAparecidas.contains(posibleArista);

				if (aristaLibre && pesoArista < pesoMinimo && pesoArista > 0) {

					boolean generaCircuito = find(i, j);

					if (!generaCircuito) {
						pesoMinimo = pesoArista;
						aristaMinima.setX(i);
						aristaMinima.setY(j);
					}
				}
			}
		}
		union(aristaMinima.getX(), aristaMinima.getY());
		aristaMinima.setPeso(pesoMinimo);

		if (pesoMinimo == Integer.MAX_VALUE)
			return null;

		return aristaMinima;
	}

	// Determina cual es la raiz del vertice que recibe (int i).
	public static int root(int i) {
		while (raices[i] != i) {
			i = raices[i];
		}
		return i;
	}

	// Determina si 2 vertices estan en la misma componente conexa.
	public static boolean find(int i, int j) {
		return root(i) == root(j);
	}

	// Hace que la raiz de vertice apunte a la raiz del otro. (El array de raices
	// aqui se llama "A").
	public static void union(int i, int j) {
		int rootI = root(i);
		int rootJ = root(j);
		raices[rootI] = rootJ;
	}
}
