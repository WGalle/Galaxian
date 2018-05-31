package excepciones;


public class NoEstaRegistradoExcepcion extends Exception {

	private static final long serialVersionUID = 1L;

	public NoEstaRegistradoExcepcion(String nombre) {
		super("El jugador " + nombre + " no está registrado.");
	}

}
