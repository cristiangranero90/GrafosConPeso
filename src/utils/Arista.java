package utils;

public class Arista {

	private int x;
	private int y;
	private int peso;

	public Arista(int x, int y, int peso) {
		super();

		verificarPesoValido(peso);
		verificarVerticesIguales(x, y);
		verificarVerticeValido(x);
		verificarVerticeValido(y);

		this.x = x;
		this.y = y;
		this.peso = peso;
	}

	private void verificarVerticeValido(int x2) {
		if (x2 < 0)
			throw new IllegalArgumentException("Vertice debe ser mayor a 0, valor dado : " + x2);
	}

	private void verificarVerticesIguales(int x2, int y2) {
		if (x2 == y2)
			throw new IllegalArgumentException("Los vertices no pueden ser iguales");
	}

	private void verificarPesoValido(int peso2) {
		if (peso2 < 0)
			throw new IllegalArgumentException("Peso debe ser mayor a 0, valor dado : " + peso2);
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
