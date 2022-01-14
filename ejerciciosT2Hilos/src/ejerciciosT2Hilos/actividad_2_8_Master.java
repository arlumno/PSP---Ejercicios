package ejerciciosT2Hilos;


public class actividad_2_8_Master {

	public static void main(String[] args) {
		actividad_2_8_Saldo saldo = new actividad_2_8_Saldo(200);
		System.out.println("Saldo inicial " + saldo.getSaldo());
		
		Thread h1 = new actividad_2_8_Thread("Ana", 100, saldo);
		Thread h2 = new actividad_2_8_Thread("Maria", 33, saldo);
		Thread h3 = new actividad_2_8_Thread("Belen", 52, saldo);
		Thread h4 = new actividad_2_8_Thread("Paco", 79, saldo);
		Thread h5 = new actividad_2_8_Thread("Ramón", 1, saldo);
		Thread h6 = new actividad_2_8_Thread("José", 501, saldo);
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();		
			h4.join();
			h5.join();
			h6.join();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Saldo final " + saldo.getSaldo());
	}

}
