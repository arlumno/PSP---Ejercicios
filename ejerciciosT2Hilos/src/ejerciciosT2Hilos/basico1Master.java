package ejerciciosT2Hilos;

public class basico1Master {

	public static void main(String[] args) {
		basico1Thread h1 = new basico1Thread("A");
		basico1Thread h2 = new basico1Thread("AA");
		basico1Thread h3 = new basico1Thread("AAA");
		h1.setPriority(1);
		h3.setPriority(3);
		h1.start();
		h2.start();
		h3.start();
		System.out.println("--- Encendiendo motores --- ");
	
	}

}
