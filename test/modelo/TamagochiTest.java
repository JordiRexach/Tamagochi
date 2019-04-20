package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
class TamagochiTest {

	@Test
	void comer_mascotaHambrientaYSePoneContenta() {
		Tamagochi mascota = new Tamagochi();
		mascota.comer();
		Assert.assertTrue("Mascota no esta feliz", mascota.estaContenta());
	}
	
	@Test
	void comer_mascotaPasaAContentaYSuNivelIncrementaUnaUnidad() {
		Tamagochi mascota = new Tamagochi();
		int nivelAnterior = mascota.getNivel();
		mascota.comer();
		Assert.assertTrue("Mascota no subio de nivel", mascota.getNivel() > nivelAnterior);		
	} 

	@Test
	void comer_mascotaEstaDeMalHumorMasDe80MinYPasaAContenta() {
		Tamagochi mascota = new Tamagochi();
		int tiempoMalHumor = 81;
		mascota.sePoneDeMalHumor(tiempoMalHumor);
		mascota.comer();
		Assert.assertTrue("Mascota no esta contenta", mascota.estaContenta());		
	} 

	@Test
	void comer_mascotaEstaDeMalHumorMenosOIgualA80MinYNoPasaAContenta() {
		Tamagochi mascota = new Tamagochi();
		int tiempoMalHumor = 80;
		mascota.sePoneDeMalHumor(tiempoMalHumor);
		mascota.comer();
		Assert.assertFalse("Mascota esta contenta", mascota.estaContenta());		
	} 
	
	@Test
	void jugar_MascotaContentaIncrementaNivelDosUnidades() {
		Tamagochi mascota = new Tamagochi();
		int nivelAnterior;
		mascota.sePoneContenta();
		nivelAnterior = mascota.getNivel();
		//System.out.println(mascota.getNivel());
		mascota.jugar();
		//System.out.println(mascota.getNivel()  - nivelAnterior);
		Assert.assertTrue("Nivel no incrementó 2 Unidades", (mascota.getNivel()  - nivelAnterior) == 2);
	}

	@Test
	void jugar_MascotaContentaJuega5VecesYSePoneHambrienta() {
		Tamagochi mascota = new Tamagochi();
		mascota.sePoneContenta();
		//Juega 5 veces
		IntStream.rangeClosed(1, 5).forEach(i -> mascota.jugar());
		//Si juega 5 veces su nivel incrementa por dos por cada vez que juega
		//System.out.println(mascota.getNivel());
		Assert.assertTrue("Mascota no esta hambrienta", mascota.estaHambrienta());
	}
	
	@Test
	void jugar_MascotaMalHumorSePoneContenta() {
		Tamagochi mascota = new Tamagochi();
		mascota.sePoneDeMalHumor(1);
		mascota.jugar();
		Assert.assertTrue("Mascota no esta contenta", mascota.estaContenta());
	}

	@Test
	void jugar_MascotaHambrientarSePoneMalHumor() {
		Tamagochi mascota = new Tamagochi();
		//Ya lo inicializo en hambrienta
		mascota.jugar();
		Assert.assertTrue("Mascota no esta de mal humor", mascota.estaDeMalHumor());
	}
}
