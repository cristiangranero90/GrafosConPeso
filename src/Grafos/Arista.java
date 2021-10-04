package Grafos;

import java.util.Objects;

public class Arista {
	
	int i;
	int j;
	int peso;
	
	public Arista() {
		this.i = 0;
		this.j = 0;
		this.peso = 0;
	}
	
	public Arista(int i, int j, int peso) {
		
		this.i = i;
		this.j = j;
		this.peso = peso;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		// TODO Auto-generated method stub
		return this.peso;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		return i == other.i && j == other.j ||
				 j == other.i && i == other.j;
	}
	
	
	
}
