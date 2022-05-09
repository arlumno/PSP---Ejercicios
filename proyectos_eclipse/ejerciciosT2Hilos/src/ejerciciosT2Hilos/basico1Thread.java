package ejerciciosT2Hilos;

public class basico1Thread extends Thread{

	public basico1Thread(String name) {
		super(name);
		System.out.println("-- Creando Hilo: " + getName());	
	}
	
	public void run() {
		System.out.println("["+ getName() +"]: " + toString());
		for(int i = 0; i<10 ; i++) {
			System.out.println("["+ getName()+"] -> " + i);
		}
	}

}
