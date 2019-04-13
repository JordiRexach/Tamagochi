package modelo;

import junit.framework.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class TamagochiTest {
	// NOTA: la mascota está por defecto contenta (no tiene hambre)

	@Test
	public void comer_MascotaHambrientaComeYSePoneContenta(){
		Tamagochi mascota = new Tamagochi();
		mascota.setEstaHambrienta(true);
		mascota.comer();
		Assert.assertTrue("La mascota esta contenta", mascota.estaContenta());
	}
	
	@Test
	public void comer_MascotaContentaNivelDeFelicidadAumentaUnPunto(){
		Tamagochi mascota = new Tamagochi();
		final int nivelAnterior = mascota.getNivelFelicidad();
		mascota.comer();
		Assert.assertTrue("La mascota subió un nivel de felicidad", mascota.getNivelFelicidad() - nivelAnterior == 1);
	}
	
	@Test
	public void comer_MascotaEstaDeMalHumorHaceMasDe80MinutosYSePoneContenta() {
		Tamagochi mascota = new Tamagochi();

		mascota.setTiempoDeMalHumor(85);
		mascota.setNivelFelicidad(0);
		mascota.setEstaHambrienta(false);

		mascota.comer();
		Assert.assertTrue("La mascota se pone contenta", mascota.estaContenta());
	}
	
	@Test
	public void comer_MascotaEstaDeMalHumorHaceMenosDe80MinutosYNoSePoneContenta() {
		Tamagochi mascota = new Tamagochi();

		mascota.setTiempoDeMalHumor(40);
		mascota.setNivelFelicidad(0);
		mascota.setEstaHambrienta(false);

		mascota.comer();
		Assert.assertTrue("La mascota sigue igual", mascota.getTiempoDeMalHumor() == 40);
	}
	
	@Test
	public void jugar_MascotaContentaSubeDosNivelesDeFelicidad() {
		Tamagochi mascota = new Tamagochi();
		mascota.jugar();
		Assert.assertTrue("La mascota sube dos niveles de felicidad", mascota.getNivelFelicidad() > 1);
	}

	@Test
	public void jugar_MascotaContentaSePoneHambrientaSiJuegaMasDeCincoVeces() {
		Tamagochi mascota = new Tamagochi();
		mascota.jugar();
		mascota.jugar();
		mascota.jugar();
		mascota.jugar();
		mascota.jugar();
		mascota.jugar();
		Assert.assertTrue("La mascota tiene hambre", !mascota.estaContenta() && mascota.getNivelFelicidad() > 0);
	}
	
	@Test
	public void jugar_MascotaEstaDeMalHUmorYSePoneContenta() {
		Tamagochi mascota = new Tamagochi();
		mascota.setNivelFelicidad(0);
		mascota.jugar();
		Assert.assertTrue("La mascota esta contenta", mascota.estaContenta());
	}
	
	@Test
	public void jugar_MascotaEstaHambrientaYSePoneDeMalHumor() {
		Tamagochi mascota = new Tamagochi();
		mascota.setEstaHambrienta(true);
		mascota.jugar();
		Assert.assertTrue("La mascota no puso de mal humor", !mascota.estaContenta());
	}
}
