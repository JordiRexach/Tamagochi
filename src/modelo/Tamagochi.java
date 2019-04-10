package modelo;

public class Tamagochi {
	private Boolean estaHambrienta = true;
	private int nivelFelicidad = 0;

	public void comer() {
		if (estaHambrienta){
			nivelFelicidad += 1;
		}
		
	}

	public boolean estaContenta() {		
		return nivelFelicidad > 0;
	}
	
	public void estaHambrienta() {
		estaHambrienta = true;
	}

}
