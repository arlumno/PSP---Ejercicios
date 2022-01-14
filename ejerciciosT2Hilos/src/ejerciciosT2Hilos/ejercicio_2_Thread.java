package ejerciciosT2Hilos;

public class ejercicio_2_Thread implements Runnable{
	String m;
	public ejercicio_2_Thread(String m) {
		this.m = m;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(Thread.currentThread().getId()*10);
			System.out.println("Hola mundo " + m + "  [" + Thread.currentThread().getId() + "]");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
