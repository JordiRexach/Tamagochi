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
}
