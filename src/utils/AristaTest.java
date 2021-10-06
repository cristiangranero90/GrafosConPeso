package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AristaTest {

	@Test(expected = IllegalArgumentException.class)
	public void testVerticesIguales() {
		Arista arista = new Arista(2,2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPesoMayoACero() {
		Arista arista = new Arista(2,2,0);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerticeXMayorACero() {
		Arista arista = new Arista(2,0,10);	
	}
	@Test(expected = IllegalArgumentException.class)
	public void testVerticeYMayorACero() {
		Arista arista = new Arista(0,2,10);	
	}
	
	

}
