package ejerciciosT2Hilos;

public class ejercicio_2_Master {

	public static void main(String[] args) {
		Thread h1 = new Thread(new ejercicio_2_Thread("uno"));
		Thread h2 = new Thread(new ejercicio_2_Thread("dos"));
		Thread h3 = new Thread(new ejercicio_2_Thread("tres"));
		Thread h4 = new Thread(new ejercicio_2_Thread("cuatro"));
		Thread h5 = new Thread(new ejercicio_2_Thread("cinco"));
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
	}

}
