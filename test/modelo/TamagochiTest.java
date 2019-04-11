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
}
