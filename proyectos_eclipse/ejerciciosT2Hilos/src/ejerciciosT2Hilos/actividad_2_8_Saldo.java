package ejerciciosT2Hilos;

import java.util.Random;


public class actividad_2_8_Saldo {
	private final int MAX_TIEMPO = 100;
	Random aleatorio = new Random();
	int saldo;
	
	public actividad_2_8_Saldo(int saldo) {
		this.saldo = saldo;
	}
	
	public void esperar() {
		try {
			Thread.sleep(aleatorio.nextInt(MAX_TIEMPO));
		}catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	
	public int getSaldo() {
		esperar();
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		esperar();
		this.saldo = saldo;
	}
	
//	synchronized void addSaldo(String persona, int importe) {
	void addSaldo(String persona, int importe) {
		System.out.println("   " + persona + " va a ingresar "+ importe +" saldo inicial: " + getSaldo());
		setSaldo(getSaldo() + importe);		
		System.out.println("   " + persona + " saldo final: " + getSaldo());		
	}
}
