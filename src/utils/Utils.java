package utils;

public class Utils {

	public static int numeroRamdonEntre(int min, int max) {
		if(min > max) throw new IllegalArgumentException("Minimo no puede sedr mayor a maximo, min : "+ min + " max : "+ max);
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
	
}
