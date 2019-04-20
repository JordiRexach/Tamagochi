package modelo;

public class Estado {
	private static String feliz 	 = "feliz"; 
	private static String hambrienta = "hambrienta"; 
	private static String mal_humor  = "mal_humor"; 
	private String nombre = hambrienta;
	private int nivelFelicidad = -1; //Significa que no esta feliz
	private int tiempoMalHumor = 0;  //Significa que no esta de mal humor
	
	private void setTiempoMalHumor(int tiempoMalHumor) {
		this.tiempoMalHumor = tiempoMalHumor;
	}

	public int getTiempoMalHumor() {
		return tiempoMalHumor;
	}

	public int getNivelFelicidad() {
		return nivelFelicidad;
	}

	public void cambiarAContenta() {
		nombre = feliz; 
		nivelFelicidad = 0;
	}

	public void cambiarAHambrienta() {
		nombre = hambrienta; 
		this.resetearNivel();
	}

	public void cambiarAMalHumor(int tiempoMalHumor) {
		nombre = mal_humor; 
		this.setTiempoMalHumor(tiempoMalHumor);
		this.resetearNivel();	
	}
	
	private void resetearNivel() {
		nivelFelicidad = -1;
	}
	
	public void subirNivelFelicidad() {
		nivelFelicidad += 1;
	}
	
	public Boolean esContenta() {
		return nombre == feliz;
	}

	public Boolean esMalHumor() {
		return nombre == mal_humor;
	}
	public Boolean esHambrienta() {
		return nombre == hambrienta;
	}
}
