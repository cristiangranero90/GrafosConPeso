package Grafos;

import java.util.HashSet;
import java.util.Set;

public class GrafoConPeso implements Comparable<GrafoConPeso> {
	
	private int[][] A; // que tal, matrizAdyacencia ?

	public GrafoConPeso(int vertices)  {
		
		verficarVerticesConstructor(vertices);
		A = new int [vertices][vertices];
		
	}
	
	public void agregarArista(int i, int j, int peso) {		
		verficarVertices(i , j);
		verificarIguales(i, j);
		verificarPeso(peso);
		
		A[i][j] = peso;
		A[j][i] = peso;		
	}
	
	public void quitarArista(int i, int j) {
		verficarVertices(i , j);
		verificarIguales(i, j);
		
		A[i][j] = 0;
		A[j][i] = 0;	
		
	}
	
	public boolean existeArista(int i, int j) {
		verficarVertices(i , j);
		verificarIguales(i, j);
		
		return A[i][j] != 0;
	}
	
	public int vertices() {
		return A.length;
	}
	
	public Set<Integer> vecinos(int i){
		
		verficarVertices(i, i);		
		Set<Integer> ret = new HashSet<Integer>();
		
		for(int j = 0; j<vertices(); j++) if (i != j) {
			if(existeArista(i, j)) {
				ret.add(j);
			}
		}
		return ret;		
	}
	

	/*Verifica si arista existe, si existe retorna peso, sino retorna 0*/
	public int obtenerPesoArista(int i, int j) {
		if(existeArista(i, j)) return A[i][j];
		return 0; 
	}
	


	private void verificarPeso(int peso) {
		if (peso < 1) {
			throw new IllegalArgumentException("El peso no puede ser menor que 1, peso ingresado: " + peso);
		}		
	}

	private void verificarIguales(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("Los vertices no pueden ser iguales. ");
		}		
	}

	private void verficarVertices(int i, int j) {
		if (i < 0 || i > A.length) {
			throw new IllegalArgumentException("Valor invalido para: " + i); 
		}
		if (j < 0 || j > A.length) {
			throw new IllegalArgumentException("Valor invalido para: " + j); 
		}		
	}

	private void verficarVerticesConstructor(int vertices) {
		if (vertices <= 0) {
			throw new IllegalArgumentException("La cantidad de vertices es incorrecta: " + vertices);
		}
		
	}

	
	public int[][] getA() {
		return A;
	}

	public void print() {
		for (int x = 0; x < A.length; x++) {
			  System.out.print("|");
			  for (int y = 0; y < A[x].length; y++) {
			    System.out.print (A[x][y]);
			    if (y!= A[x].length-1) System.out.print("\t");
			  }
			  System.out.println("|");
			}
	}

	//TODO: TEST
	public int cantAristas() {
		int ret = 0;
		for(int i = 0 ; i < A.length ; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if(A[i][j] > 0) {
					ret++;
				}
			}
		}
		return ret/2;
	}

	@Override
	public int compareTo(GrafoConPeso o) {
		if(this.vertices() > o.vertices()) return 1;
		if(this.vertices() < o.vertices()) return -1;
		return 0;
	}
}
