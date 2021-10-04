package utils;

import java.util.HashSet;
import java.util.Set;

import Grafos.GrafoConPeso;

public class GeneradorGrafosConPeso {
	private static Set<GrafoConPeso> grafos = new HashSet<>();

	public static Set<GrafoConPeso> generadorDeGrafosConPeso(int cantGrafos, int vertices, int aristas) {

		while (cantGrafos > 0) {
			GrafoConPeso grafo = new GrafoConPeso(vertices);

			for (int i = 0; i < aristas; i++) {
				Arista aristaValida = GeneradorGrafosConPeso.generarAristaValida(grafo);
				grafo.agregarArista(aristaValida.getX(), aristaValida.getY(), aristaValida.getPeso());
			}

			grafos.add(grafo);
			cantGrafos--;
		}

		return grafos;
	}

	private static Arista generarAristaValida(GrafoConPeso grafo) {
		int vertices = grafo.vertices();

		int verticeX = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
		int verticeY = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
		int peso = GeneradorGrafosConPeso.numeroRamdonEntre(1, 100);

		while (verticeX == verticeY) {
			verticeX = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
			verticeY = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
		}

		while (grafo.existeArista(verticeX, verticeY)) {
			verticeX = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
			verticeY = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
			while (verticeX == verticeY) {
				verticeX = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
				verticeY = GeneradorGrafosConPeso.numeroRamdonEntre(0, vertices - 1);
			}
		}
		
		return new Arista(verticeX, verticeY,peso);
	}

	public static int numeroRamdonEntre(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			System.out.println(GeneradorGrafosConPeso.numeroRamdonEntre(1, 10));
		}
	}

}
