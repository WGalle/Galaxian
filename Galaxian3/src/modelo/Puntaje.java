package modelo;

public class Puntaje {
	
	private Usuario usuario;
	private int puntos;
	
	public Puntaje(Usuario usuario, int puntos) {
		this.usuario = usuario;
		this.puntos = puntos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int compararPorPunto(Puntaje pun) {
		int r = 0;
		if (pun == null){
			r = 1;
		} else {
			r = puntos - pun.puntos;
		}
		return r;
	}
	
	public int compararPorNombre(Puntaje pun) {
		int r = 0;
		if (pun == null){
			r = -1;
		} else {
			r = usuario.getNick().compareToIgnoreCase(pun.usuario.getNick());
		}
		return r;
	}
}
