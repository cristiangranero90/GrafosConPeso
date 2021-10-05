package utils;

import java.util.Set;
import java.util.TreeSet;

import Grafos.GrafoConPeso;
import Grafos.Kruskal;

public class GeneradorGrafosConPeso {

	private static Set<GrafoConPeso> grafos = new TreeSet<>();

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

	public static GrafoConPeso generadorDeGrafoConPeso(int vertices, int aristas) {

		GrafoConPeso grafo = new GrafoConPeso(vertices);

		for (int i = 0; i < aristas; i++) {
			Arista aristaValida = GeneradorGrafosConPeso.generarAristaValida(grafo);
			grafo.agregarArista(aristaValida.getX(), aristaValida.getY(), aristaValida.getPeso());
		}

		return grafo;
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

		return new Arista(verticeX, verticeY, peso);
	}

	public static int numeroRamdonEntre(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
	
	// Generar 50 grafos cada grafo con 10 vertices mas que el anterior.
	private static void grafosParaAnalizar() {
		int vertices = 3;
		int aristas = 5;
		for (int i = 0; i < 50; i++) {
			vertices++;
			aristas++;
			if(vertices > 20) aristas = aristas + 4;
			grafos.add(generadorDeGrafoConPeso(vertices, aristas));
		}
	}

	public static void main(String[] args) {
		
		grafosParaAnalizar();
		
		StringBuilder breakLine = new StringBuilder("***************************************");
		StringBuilder descripcionGrafo = new StringBuilder();
		System.out.println(breakLine.toString());		
		int i = 1;
		for (GrafoConPeso grafo : grafos) {
			
			descripcionGrafo.append("Grafo ").append(i).append(" - Vertices : ")
			.append(grafo.vertices()).append(", Aristas : ").append(grafo.cantAristas());
			
			System.out.println(descripcionGrafo.toString());
			descripcionGrafo.delete(0,descripcionGrafo.length());
			
			Kruskal.kruskalBFS(grafo);
			Kruskal.kruskalUnionFind(grafo);
			
			System.out.println(breakLine.toString());
			i++;
		}
	}
}
