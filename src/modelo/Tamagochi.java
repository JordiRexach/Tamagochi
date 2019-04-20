package modelo;

import java.util.stream.IntStream;

public class Tamagochi {
	private static int limiteDetiempoMalHumor = 80;
	private Estado estado = new Estado();
	private int cantidadDeVecesJugados = 0; //No jugo nunca 
	
	public boolean estaContenta() {
		return estado.esContenta();
	}

	public boolean estaHambrienta() {
		return estado.esHambrienta();
	}

	public boolean estaDeMalHumor() {
		return estado.esMalHumor();
	}
	
	public void comer() {
		if(estado.esHambrienta()) {
			estado.cambiarAContenta();
			estado.subirNivelFelicidad();
		}else if(estado.esMalHumor() && estado.getTiempoMalHumor() > limiteDetiempoMalHumor){
			estado.cambiarAContenta();
		}
	}

	public void jugar() {
		//Se incrementa el nivel de felicidad dos veces
		IntStream.rangeClosed(1, 2).forEach(i -> estado.subirNivelFelicidad());
		//Se incrementa las veces que jugo la mascota
		this.incrementarCantidadDeVecesJugado();
		//Se comprueba si estaba de mal humor
		
		if(estado.esMalHumor()) {
			//Se pone contenta
			estado.cambiarAContenta();
		}else if(estado.esHambrienta()) {
			estado.cambiarAMalHumor(1);
		}
		
		if( this.jugoMasDe5Veces()) {
			estado.cambiarAHambrienta();
		}
		
		//System.out.println(cantidadDeVecesJugados);
	}
	
	private void incrementarCantidadDeVecesJugado() {
		cantidadDeVecesJugados += 1;
	}

	private boolean jugoMasDe5Veces() {
		return cantidadDeVecesJugados > 5;
	}

	public int getNivel() {
		return estado.getNivelFelicidad();
	}
	
	public void sePoneDeMalHumor(int tiempoMalHumor) {
		estado.cambiarAMalHumor(tiempoMalHumor);
	}

	public void sePoneContenta() {
		estado.cambiarAContenta();
	}
}
