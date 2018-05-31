package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Juego;
import modelo.Nave;
import modelo.NaveEnemiga;

class testJuego {

	private Juego juego;
	
	private void escenario1() {
		juego = new Juego();
	}
	

	@Test
	public void testAgregarUsuario() {
		escenario1();
		juego.agregarUsuario("Dennys", 1, 1, 1);
		assertFalse(juego.getUsuarios().get(0).equals("Dennys"));
	}
	
	@Test
	public void testAgregarNave() {
		escenario1();
		juego.agregarNaves(new Nave(Nave.AZUL, 400, 300, Nave.LARGO, Nave.ANCHO, null));
		assertNotNull(juego.getUsuarios());
	}
}
