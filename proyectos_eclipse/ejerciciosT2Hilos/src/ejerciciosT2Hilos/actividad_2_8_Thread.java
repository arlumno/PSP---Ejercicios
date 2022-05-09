package ejerciciosT2Hilos;

import java.beans.PersistenceDelegate;

public class actividad_2_8_Thread extends Thread{
	actividad_2_8_Saldo saldo;
	int importe;
	String persona;
	public actividad_2_8_Thread(String persona, int importe, actividad_2_8_Saldo saldo) {
		this.saldo = saldo;
		this.persona = persona;
		this.importe = importe;
	}
	@Override
	public void run() {
		saldo.addSaldo(persona, importe);
	}
}
