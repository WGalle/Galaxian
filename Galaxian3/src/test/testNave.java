package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Nave;

class testNave {

	private Nave nave;
	
	private void escenario1() {
		nave = new Nave(nave.ROJA, 100, 100, nave.LARGO, nave.ANCHO, null);
	}
	
	@Test
	public void testMover() {
		escenario1();
		int x = -4;
		nave.mover(x);
		
		if(x>0) {
			assertTrue(nave.getPosX() <= nave.LARGO);
		}else if(x<0) {
			assertTrue(nave.getPosX() >= nave.LARGO);
		}	
	}
	
	@Test
	public void testDisparar() {
		
	}

}
