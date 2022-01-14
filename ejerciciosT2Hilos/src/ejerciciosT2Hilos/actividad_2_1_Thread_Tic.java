package ejerciciosT2Hilos;

public class actividad_2_1_Thread_Tic extends Thread{
	public String texto;
	public static final long TIEMPO_ESPERA = 1000L;
	private long demora;
	public actividad_2_1_Thread_Tic(String texto,long demora) {
		this.texto = texto;
		this.demora = demora;
	}
	
	public  actividad_2_1_Thread_Tic(String texto) {
		this(texto, 0L);
	}
	
	

	public void run() {
		try {
			sleep(demora);
			while(true) {
				System.out.print(texto);
					sleep(TIEMPO_ESPERA);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
