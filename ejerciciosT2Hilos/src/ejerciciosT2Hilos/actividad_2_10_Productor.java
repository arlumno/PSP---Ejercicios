package ejerciciosT2Hilos;

public class actividad_2_10_Productor extends Thread{
	String cadena;
	private actividad_2_10_Cola cola = new actividad_2_10_Cola();
	
	public actividad_2_10_Productor(String cadena) {
		this.cadena = cadena;			
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
}
