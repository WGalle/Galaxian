package modelo;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Juego implements Serializable{
	
	public static final int LARGO_VENTANA=665;
	public static final int ANCHO_VENTANA=975;

	private Nave primera;
	
	private Usuario primero;
	
	private ArrayList<Nave> naves;
	private ArrayList<Usuario> usuarios;
	
	public Juego() {
		primera=null;
		primero=null;
		
		naves=new ArrayList<Nave>();
		usuarios=new ArrayList<Usuario>();
		
		inicializarNaves();
	}
	
	public void agregarUsuario(String nick, int puntaje, int nivel, int vidas) {
		usuarios.add(new Usuario(nick, puntaje, nivel, vidas));
	}
	
	public void agregarNaves(Nave nueva) {
		naves.add(nueva);
	}
	
//	public void addUsuario(String nick, int puntaje, int nivel, int vidas) {
//		try {
//			//creo flujo de datos interno
//			ObjectInputStream mostrar=new ObjectInputStream(/**Indico de donde voy a tomar el archivo a leer*/new FileInputStream("src/datos/Usuarios.dat"));
//			usuarios=(ArrayList<Usuario>) mostrar.readObject();//Retorna un objeto de tipo Object que debe ser casteado a ArrayList<Usuario>
//			mostrar.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//			usuarios=new ArrayList<Usuario>();
//		}
//		usuarios.add(new Usuario(nick, puntaje, nivel, vidas));
//	}
	
	public void inicializarNaves() {
		agregarNaves(new NaveEnemiga(Nave.AZUL, 283, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.VERDE, 323, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 363, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.REINA,403, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.AZUL, 443, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.VERDE, 483, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 523, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.REINA, 563, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.AZUL, 603, 150, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.VERDE, 363, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 403, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.REINA, 443, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.AZUL, 483, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.VERDE, 523, 110, Nave.LARGO, Nave.ANCHO, null, 300));
		agregarNaves(new NaveEnemiga(Nave.ROJA, 563, 110, Nave.LARGO, Nave.ANCHO, null, 300));
	}
	
	public Nave getPrimera() {
		return primera;
	}

	public void setPrimera(Nave primera) {
		this.primera = primera;
	}

	public Usuario getPrimero() {
		return primero;
	}

	public void setPrimero(Usuario primero) {
		this.primero = primero;
	}
	
	public ArrayList<Nave> getNaves(){
		return naves;
	}
	
	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}
	
	public void detenerNave() {
		primera.setEnMovimiento(false);
	}

	public void moverNaveUsuarioDerecha (){
		primera.mover(1);
	}
	
	public void moverNaveUsuarioIzquierda (){
		primera.mover(-1);
	}
	
	public ArrayList<Nave> toArrayNave() {
		ArrayList<Nave> naves=new ArrayList<Nave>();
		Nave temp=primera;
		while(temp!=null){
			naves.add(temp);
			temp=temp.getSiguiente();
		}
		return naves;
	}
	
	public ArrayList<Usuario> toArrayUsuario() {
		ArrayList<Usuario> naves=new ArrayList<Usuario>();
		Usuario temp=primero;
		while(temp!=null){
			naves.add(temp);
			temp=temp.getSiguiente();
		}
		return naves;
	}
	
	public void guardar() {
		try {
			//Creo flujo de datos externo
			ObjectOutputStream escribir=new ObjectOutputStream(/**Indico la ruta de donde se va a guardar*/new FileOutputStream("src/datos/usuarios.dat"));
			escribir.writeObject(primero);
			escribir.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
