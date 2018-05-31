package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Principal;

class testPrincipal {

	private Principal principal;
	
	private void escenario1() {
		principal = new Principal();
	}
	
	@Test
	public void testOrdenarPorPuntos() {
		escenario1();
		
		principal.ordenarPuntajesPorPuntos();
		
	}
	

}
