package excepciones;

public class NoTopTenExcepcion extends Exception {
	
	public NoTopTenExcepcion(String nombre) {
		super("El jugador "+ nombre + "no est� dentro del top ten de mejores puntajes.");
	}
}
