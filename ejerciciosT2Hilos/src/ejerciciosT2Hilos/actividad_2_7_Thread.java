package ejerciciosT2Hilos;

public class actividad_2_7_Thread extends Thread {
	actividad_2_7_Counter counter;
	public actividad_2_7_Thread(actividad_2_7_Counter counter) {
		this.counter = counter;		
	}
	public void run() {
		for(int i = 0; i <5000; i++) {
			counter.incrementar();
		}

	}
}
