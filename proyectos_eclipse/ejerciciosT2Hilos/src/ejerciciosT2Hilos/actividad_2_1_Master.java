package ejerciciosT2Hilos;

public class actividad_2_1_Master {

	public static void main(String[] args) {
		actividad_2_1_Thread_Tic h1 = new actividad_2_1_Thread_Tic("TIC");	
		actividad_2_1_Thread_Tic h2 = new actividad_2_1_Thread_Tic("TAC",actividad_2_1_Thread_Tic.TIEMPO_ESPERA/2);
		h1.start();
		h2.start();
	
	}

}
