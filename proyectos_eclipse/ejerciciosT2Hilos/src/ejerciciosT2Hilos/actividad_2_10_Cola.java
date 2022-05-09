package ejerciciosT2Hilos;

public class actividad_2_10_Cola {
	private int numero;
	private boolean ready = false;
	
	public int getNumero() {			
		if(ready) {
			ready = false;
			return numero;
		}
		return -1;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
		ready = true;
	}
}
