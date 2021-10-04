package Grafos;

import java.util.ArrayList;

public class ArbolGeneradorMinimo {
	
	public static GrafoConPeso kruskal(GrafoConPeso grafo){
		
		ArrayList<Arista> conjuntoAristas = new ArrayList<>();
		GrafoConPeso arbolMinimo = new GrafoConPeso(grafo.vertices());
		
		int i = 0;
		while (i < grafo.vertices() - 1) {
			Arista arista = aristaMinima(grafo, conjuntoAristas, arbolMinimo);
			if (arista != null) {
				conjuntoAristas.add(arista);
				arbolMinimo.agregarArista(arista.getI(), arista.getJ(), arista.getPeso());
			}			
		}		
		return arbolMinimo;
	}
	
	public static Arista aristaMinima(GrafoConPeso grafo, ArrayList<Arista> conjuntoAristas, GrafoConPeso arbolMinimo) {
		
		int pesoMinimo = 10000000;
		Arista arista = new Arista(0,0,0);
		
		for (int i = 0; i < grafo.vertices(); i++) {
			for (int j = 0; j < grafo.vertices(); j++) {
				
				if (i != j && grafo.existeArista(i, j) 
						&& grafo.damePesoDeArista(i, j) < pesoMinimo
						&& !conjuntoAristas.contains(arista)) {
					
					pesoMinimo = grafo.damePesoDeArista(i, j);
					arista.setI(i);
					arista.setJ(j);
					arista.setPeso(pesoMinimo);
					
					if (!aristaAlcanzable(arista, arbolMinimo)) {						
						return arista;
					}
				}
			}
		}
		return null;
	}

	private static boolean aristaAlcanzable(Arista arista, GrafoConPeso arbolMinimo) {		
		
		return BFSPeso.esConexoOrigen(arbolMinimo, arista.getI()); 		
	}
	

}
