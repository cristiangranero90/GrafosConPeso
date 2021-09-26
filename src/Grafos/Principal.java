package Grafos;

public class Principal {

	public static void main(String[] args) {
		
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 3, 15);
		grafo.agregarArista(1, 2, 12);
		grafo.agregarArista(3, 4, 21);
		grafo.agregarArista(2, 4, 22);
		
		System.out.println(grafo.toString());

	}

}
