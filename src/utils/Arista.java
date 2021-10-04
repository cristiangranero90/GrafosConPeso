package utils;

public class Arista {

	private int x;
	private int y;
	private int peso;
	
	public Arista(int x, int y, int peso) {
		super();
		this.x = x;
		this.y = y;
		this.peso = peso;
	}
	
	public Arista(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Arista() {
		super();
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Arista [x=" + x + ", y=" + y + ", peso=" + peso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
	

}
	
