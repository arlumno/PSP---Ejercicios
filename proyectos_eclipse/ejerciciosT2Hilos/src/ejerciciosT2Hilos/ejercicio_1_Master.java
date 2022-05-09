package ejerciciosT2Hilos;

public class ejercicio_1_Master {

	public static void main(String[] args) {
		ejercicio_1_Thread h1 = new ejercicio_1_Thread();
		ejercicio_1_Thread h2 = new ejercicio_1_Thread();
		ejercicio_1_Thread h3 = new ejercicio_1_Thread();
		ejercicio_1_Thread h4 = new ejercicio_1_Thread();
		ejercicio_1_Thread h5 = new ejercicio_1_Thread();
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		
	}

}
