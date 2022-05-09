package ejerciciosT2Hilos;

public class actividad_2_7_Counter {
	private int counter;
	public actividad_2_7_Counter(int counter) {
		this.counter = counter;
	}
	public synchronized void  incrementar() {
	//public void  incrementar() {		
		counter++;
	}
	public synchronized void decrementar() {
	//public void decrementar() {
		counter--;
	}
	public int getCounter() {
		return counter;
	}
}
