package modelo;

import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class TamagochiTest {
	
	@Test
	public void comer_LaMascotaHambrientaComeYSePoneFeliz(){
		Tamagochi mascota = new Tamagochi();
		mascota.comer();
		Assert.assertTrue("La mascota no esta contenta", mascota.estaContenta());
	}
	
	@Test
	public void comer_LaMascotaEstaFelizYSubeUnNivel(){
		Tamagochi mascota = new Tamagochi();
		int nivelAnterior = mascota.getNivelFelicidad();
		mascota.comer();
		Assert.assertTrue("La mascota no sube un nivel de felicidad", mascota.getNivelFelicidad() > nivelAnterior);
	}
	
	@Test
	public void comer_LaMascotaEstaDeMalHumorYSePoneFeliz() {
		Tamagochi mascota = new Tamagochi();
		mascota.setTiempoDeMalHumor(85);
		mascota.setEstaHambrienta(false);
		mascota.comer();
		Assert.assertTrue("La mascota no se pone feliz", mascota.estaContenta());
	}
	
	@Test
	public void comer_LaMascotaEstaDeMalHumorYNoSePoneFeliz() {
		Tamagochi mascota = new Tamagochi();
		mascota.setTiempoDeMalHumor(40);
		mascota.setEstaHambrienta(false);
		mascota.comer();
		Assert.assertTrue("La mascota se pone feliz", !mascota.estaContenta());
	}
	
	@Test
	public void jugar_LaMascotaEstaContentaYSubeDosNiveles() {
		Tamagochi mascota = new Tamagochi();
		mascota.setEstaHambrienta(false);
		mascota.setNivelFelicidad(1);
		mascota.jugar();
		Assert.assertTrue("La mascota no sube dos niveles de felicidad", mascota.getNivelFelicidad() > 1);
	}
	
	@Test
	public void jugar_LaMascotaEstaDeMalHUmorYSePoneContenta() {
		Tamagochi mascota = new Tamagochi();
		mascota.setEstaHambrienta(false);
		mascota.jugar();
		Assert.assertTrue("La mascota no esta contenta", mascota.estaContenta());
	}
	
	@Test
	public void jugar_LaMascotaEstaHambrientaYSePoneDeMalHumor() {
		Tamagochi mascota = new Tamagochi();
		mascota.jugar();
		Assert.assertTrue("La mascota no se pone de mal humor", !mascota.estaContenta());
	}
}
