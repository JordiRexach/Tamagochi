package modelo;

/**
 * Un Tamagochi puede comer y jugar, los cuales tendran efectos sobre su comportamiento.
 *
 * Por defecto, un Tamagochi está contento, esto quiere decir que:
 * --> no tiene hambre
 * --> su nivel de felicidad es 1
 * --> el tiempo de mal humor es 0
 * --> el acumulador de juegos esta en 0
 * */
public class Tamagochi {
	private boolean estaHambrienta = false;
	private int nivelFelicidad = 1;
	private int tiempoDeMalHumor = 0;
	private int acumuladorDeJuegos = 0;

	public void setEstaHambrienta(boolean estaHambrienta) {
		this.estaHambrienta = estaHambrienta;
	}
	public void setNivelFelicidad(int nivelFelicidad) {
		this.nivelFelicidad = nivelFelicidad;
	}
	public void setTiempoDeMalHumor(int tiempoDeMalHumor) {
		this.tiempoDeMalHumor = tiempoDeMalHumor;
	}

	public int getNivelFelicidad() {
		return nivelFelicidad;
	}
	public int getTiempoDeMalHumor() {
		return tiempoDeMalHumor;
	}

	public boolean estaContenta() {
		return nivelFelicidad > 0 && !estaHambrienta;
	}

	public void comer() {
		if (estaHambrienta) {
			estaHambrienta = false;
			nivelFelicidad = nivelFelicidad > 0 ? nivelFelicidad : 1;
		}
		else if (nivelFelicidad > 0) {
			nivelFelicidad += 1;
		}
		else if (tiempoDeMalHumor > 80) {
			tiempoDeMalHumor = 0;
			nivelFelicidad = 1;
		}
	}

	public void jugar() {
		acumuladorDeJuegos  += 1;
		if (estaContenta()) {
			if (acumuladorDeJuegos  > 5) {
				estaHambrienta = true;
				acumuladorDeJuegos  = 0;
			} else {
				nivelFelicidad += 2;
			}
		} else if (estaHambrienta) {
			nivelFelicidad = 0;
		} else {
			nivelFelicidad = 1;
		}
	}

	// TODO: ver qué hacer con el mensaje "puedeJugar"
	// public boolean puedeJugar() { return true }

	// TODO: estado "triste"
	// Podría interpretarse como nivel de felicidad negativa (la tristeza es lo contrario a la felicidad). El valor nulo correspondería a estar de mal humor.

	// TODO: lista de mascotas para alimentar
	// ¿Con un foreach? No termino de entender el enunciado... D:
}
