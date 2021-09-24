package Grafos;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFSPeso {

	private static boolean[] marcados;
	private static ArrayList<Integer> L;	
	
	public static boolean esConexo(GrafoConPeso grafo) {
		
		if (grafo == null) {
			throw new IllegalArgumentException("Se intento agregar un grafo que es nulo." );
		}
		if (grafo.vertices() == 0) {
			return true;
		}
		return alcanzables(grafo, 0).size() == grafo.vertices();
	}

	public static Set<Integer> alcanzables(GrafoConPeso grafo, int origen) {
		Set<Integer> retorno = new HashSet<>();
		inicializar(grafo, origen);
		
		while(L.size() > 0) {
			int i = L.get(0);
			marcados[i] = true;
			retorno.add(i);
			
			agregarVecinosPendientes(grafo, i);
			L.remove(0);
		}
		
		return retorno;
	}

	private static void agregarVecinosPendientes(GrafoConPeso grafo, int i) {
		
		for (int vertice : grafo.vecinos(i)) {
			if (!marcados[vertice] && L.contains(vertice) == false) {
				L.add(vertice);
			}
		}		
	}

	private static void inicializar(GrafoConPeso grafo, int origen) {
		L = new ArrayList<Integer>();
		L.add(origen);
		marcados = new boolean[grafo.vertices()];
	}	
}
