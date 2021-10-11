package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testNumeroValido() {
		int numeroRandom = Utils.numeroRamdonEntre(10, 20);
		assertTrue(numeroRandom >= 10 && numeroRandom <= 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNumeroInvalido() {
		int numeroRandom = Utils.numeroRamdonEntre(20, 10);
	}

}
