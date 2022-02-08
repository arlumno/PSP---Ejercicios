package ejerciciosT2Hilos;
//E_CONTAR.pdf
public class ejercicio_X4 {

	public static void main(String[] args) {
		ContarThread ct1 = new ContarThread(5);
		ct1.start();
		try {
			ct1.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ContarThread ct2 = new ContarThread(5);
		ct2.start();
		
		while(ct1.isAlive() || ct2.isAlive()){
			System.out.println("Sigo contando...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin del progama");		
	}

}

class ContarThread extends Thread{
	private int maxContar;
	public ContarThread(int maxContar) {
		this.maxContar = maxContar;
	}
	@Override
	public void run() {
		for(int i = 0; i < maxContar; i++) {
			System.out.println("Repetición [" + i+"]");
			System.out.println("Nombre del hilo: " + getName());
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
}

