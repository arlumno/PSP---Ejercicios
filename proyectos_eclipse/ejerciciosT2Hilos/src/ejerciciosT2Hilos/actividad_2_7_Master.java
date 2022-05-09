package ejerciciosT2Hilos;

public class actividad_2_7_Master {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		actividad_2_7_Counter counter = new actividad_2_7_Counter(0);
		actividad_2_7_Thread h1 = new actividad_2_7_Thread(counter);
		actividad_2_7_Thread h2 = new actividad_2_7_Thread(counter);
		actividad_2_7_Thread h3 = new actividad_2_7_Thread(counter);
		actividad_2_7_Thread h4 = new actividad_2_7_Thread(counter);
		actividad_2_7_Thread h5 = new actividad_2_7_Thread(counter);
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		try {	
			System.out.println("--- Hilo 1 finalizado---");
			h1.join();		
			System.out.println("--> " + counter.getCounter());
		
			System.out.println("--- Hilo 2 finalizado---");
			h2.join();		
			System.out.println("--> " + counter.getCounter());
			
			System.out.println("--- Hilo 3 finalizado---");
			h3.join();		
			System.out.println("--> " + counter.getCounter());
			
			System.out.println("--- Hilo 4 finalizado---");
			h4.join();		
			System.out.println("--> " + counter.getCounter());
			
			System.out.println("--- Hilo 5 finalizado---");
			h5.join();		
			System.out.println("--> " + counter.getCounter());
		}catch(Exception e) {
			System.out.println("");
		}
	}

}
