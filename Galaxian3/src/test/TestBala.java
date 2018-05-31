package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Bala;

class TestBala {

	private Bala bala;
	
	private void escenario1() {
		bala = new Bala(2, 2, 'E');
	}
	
	@Test
	public void testMover() {
		escenario1();
		bala.mover(3);
		assertTrue(bala.getPosY() >= 3);
	}

}
