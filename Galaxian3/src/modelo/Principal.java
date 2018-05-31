package modelo;

import java.util.ArrayList;

import excepciones.NoTopTenExcepcion;

public class Principal {

	//Aquí se harán los diferentes tipos de ordenamientos
	
	public static final int TOP_TEN = 10;
	private Puntaje[] puntajesTop;
	
	public Principal() {
		puntajesTop = new Puntaje[TOP_TEN];
	}
	
	public void ordenarPuntajesPorPuntos(){
		for (int i = 0; i < TOP_TEN; i++){
			if (puntajesTop [i] != null){
				for (int j = i; j > 0 && puntajesTop[j].compararPorPunto(puntajesTop[j-1]) > 0; j--){
					Puntaje temp = puntajesTop[j];
					puntajesTop[j] = puntajesTop[j-1];
					puntajesTop[j-1] = temp;
				}
			}
		}
	}
	
	public void ordenarPuntajesPorNombre(){
		for (int i = 0; i < TOP_TEN; i++){
			if (puntajesTop[i] != null){
				for (int j = i; j > 0 && puntajesTop[j].compararPorNombre(puntajesTop[j-1]) < 0; j--){
					Puntaje temp = puntajesTop[j];
					puntajesTop[j] = puntajesTop[j-1];
					puntajesTop[j-1] = temp;
				}
			}
		}
	}
	
	public void addPuntaje (Puntaje p){
		ordenarPuntajesPorPuntos();
		if (puntajesTop[TOP_TEN - 1] == null || puntajesTop[TOP_TEN - 1].getPuntos() < p.getPuntos()){
			puntajesTop[TOP_TEN - 1] = p;
			ordenarPuntajesPorPuntos();
		}
	}
	
	public Puntaje[] getPuntajesTop() {
		return puntajesTop;
	}

	public void setPuntajesTop(Puntaje[] puntajesTop) {
		this.puntajesTop = puntajesTop;
	}

	public ArrayList <Puntaje> busquedaBinariaPuntajePorJugador(String nombreJugador) throws NoTopTenExcepcion{
		ordenarPuntajesPorNombre();
		boolean encontrado = false;
		ArrayList <Puntaje> puntajesJugador = new ArrayList<Puntaje>();
		int inicio = 0;
		int fin = TOP_TEN;
		int medio = 0;
		while (!encontrado && inicio <= fin){
			medio = (inicio + fin) / 2;
			if (puntajesTop[medio] == null){
				fin = medio - 1;
			}else if (nombreJugador.equals(puntajesTop[medio].getUsuario().getNick())){
				encontrado = true;
			} else if (nombreJugador.compareTo(puntajesTop[medio].getUsuario().getNick()) < 0){
				fin = medio - 1;
			} else {
				inicio = medio + 1;
			}
		}
		if (!encontrado){
			throw new NoTopTenExcepcion(nombreJugador);
		}
		for (int i = medio; i < TOP_TEN && puntajesTop[i] != null && puntajesTop[i].getUsuario().getNick().equals(nombreJugador); i++){
			puntajesJugador.add(puntajesTop[i]);
		}
		
		for (int i = medio - 1; i >= 0 && puntajesTop[i] != null && puntajesTop[i].getUsuario().getNick().equals(nombreJugador); i--){
			puntajesJugador.add(puntajesTop[i]);
		}
		
		return puntajesJugador;
	}
}
