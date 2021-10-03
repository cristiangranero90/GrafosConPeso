package Grafos;
import java.util.HashSet;
import java.util.Set;

public class GrafoConPeso {
	
	int[][] A;

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
	
	public int damePesoDeArista(int i, int j) {		
		verficarVertices(i , j);
		verificarIguales(i, j);
		
		return A[i][j];
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
	
	public String toString() {
		StringBuilder grafoString = new StringBuilder();
		for(int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (j == A.length-1) {
					grafoString.append(A[i][j] + "\n");					
				} 
				else {
					grafoString.append(A[i][j] + " ");
				}				
			}
		}
		return grafoString.toString();
	}
}
