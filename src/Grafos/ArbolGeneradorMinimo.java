package Grafos;

import java.util.ArrayList;

public class ArbolGeneradorMinimo {
	
	public static GrafoConPeso kruskal(GrafoConPeso grafo){
		
		ArrayList<Arista> conjuntoAristas = new ArrayList<>();
		
		int i = 0;
		while (i < grafo.vertices() - 1) {
			
		}
		
		
		return null;
	}
	
	public static Arista aristaMinima(GrafoConPeso grafo, ArrayList<Arista> conjuntoAristas) {
		
		int pesoMinimo = 10000000;
		Arista arista = new Arista(0,0);
		
		for (int i = 0; i < grafo.vertices(); i++) {
			for (int j = 0; j < grafo.vertices(); j++) {
				
				if (grafo.existeArista(i, j) && grafo.damePesoDeArista(i, j) < pesoMinimo) {
					pesoMinimo = grafo.damePesoDeArista(i, j);
					arista.setI(i);
					arista.setJ(j);					
				}
			}
		}
		
		return arista;
	}
	

}
