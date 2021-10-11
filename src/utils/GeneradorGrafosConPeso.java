package utils;

import Grafos.GrafoConPeso;

public class GeneradorGrafosConPeso {

	public static GrafoConPeso generadorDeGrafoConPeso(int vertices, int aristas) {

		if (aristas > (vertices * (vertices - 1)) / 2)
			throw new IllegalArgumentException(
					"Aristas debe ser menor o igual a (vertices*(vertices-1))/2, y los datos entregados son : Vertices : "
							+ vertices + " Aristas : " + aristas);
		if (aristas <= 0)
			throw new IllegalArgumentException("Aristas debe ser mayor a 0");
		if (vertices <= 0)
			throw new IllegalArgumentException("Vertices debe ser mayor a 0");

		GrafoConPeso grafo = new GrafoConPeso(vertices);

		for (int i = 0; i < aristas; i++) {
			Arista aristaValida = GeneradorGrafosConPeso.generarAristaValida(grafo);
			grafo.agregarArista(aristaValida.getX(), aristaValida.getY(), aristaValida.getPeso());
		}

		return grafo;
	}

	public static Arista generarAristaValida(GrafoConPeso grafo) {
		int vertices = grafo.vertices();

		int verticeX = Utils.numeroRamdonEntre(0, vertices - 1);
		int verticeY = Utils.numeroRamdonEntre(0, vertices - 1);
		int peso = Utils.numeroRamdonEntre(1, 100);

		while (verticeX == verticeY) {
			verticeX = Utils.numeroRamdonEntre(0, vertices - 1);
			verticeY = Utils.numeroRamdonEntre(0, vertices - 1);
		}

		while (grafo.existeArista(verticeX, verticeY)) {
			verticeX = Utils.numeroRamdonEntre(0, vertices - 1);
			verticeY = Utils.numeroRamdonEntre(0, vertices - 1);
			while (verticeX == verticeY) {
				verticeX = Utils.numeroRamdonEntre(0, vertices - 1);
				verticeY = Utils.numeroRamdonEntre(0, vertices - 1);
			}
		}

		return new Arista(verticeX, verticeY, peso);
	}
}
