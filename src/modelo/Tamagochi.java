package modelo;

public class Tamagochi {
	private Boolean estaHambrienta = true;
	private int nivelFelicidad = 0;
	private int tiempoDeMalHumor = 0;
	
	public void setEstaHambrienta(Boolean estaHambrienta) {
		this.estaHambrienta = estaHambrienta;
	}
	
	public int getNivelFelicidad() {
		return nivelFelicidad;
	}
	
	public void setNivelFelicidad(int nivelFelicidad) {
		this.nivelFelicidad = nivelFelicidad;
	}
	
	public int getTiempoDeMalHumor() {
		return tiempoDeMalHumor;
	}

	public void setTiempoDeMalHumor(int tiempoDeMalHumor) {
		this.tiempoDeMalHumor = tiempoDeMalHumor;
	}

	public void comer() {
		if (estaHambrienta){
			nivelFelicidad += 1;
		}
		
		else if (!estaContenta() & tiempoDeMalHumor > 80) {
			nivelFelicidad = 1;
		}
	}

	public boolean estaContenta() {		
		return nivelFelicidad > 0;
	}
	
	public void jugar() {
		if (!estaHambrienta) {
			if(estaContenta()) {
				nivelFelicidad += 2;
			}
			
			else {
				nivelFelicidad = 1;
			}
		}
		
		else {
			nivelFelicidad = 0;
		}
	}

}
