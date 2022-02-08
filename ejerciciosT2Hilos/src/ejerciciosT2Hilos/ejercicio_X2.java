package ejerciciosT2Hilos;
//E_Localidades.pdf
class ejercicio_X2 {

	public static void main(String[] args) {
		Cajero cajero = new Cajero("LaTaquilla");
		Terminal t1 = new Terminal(cajero, "Tpv 01");
		Terminal t2 = new Terminal(cajero, "Tpv 02");
		Terminal t3 = new Terminal(cajero, "Tpv 03");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			System.out.println("Localidades vendidas: " + cajero.mostrarLocalidadeS());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class Cajero{
	private int localidades = 0;
	private String nombre;	
	
	public Cajero(String nombre) {
		this.nombre = nombre;
		System.out.println("Creado cajero: " + nombre);
	}
	
	public synchronized void sumarLocalidades(int ventas) {
		localidades += ventas;
	}
	
	public int mostrarLocalidadeS() {
		return localidades;
	}
}

class Terminal extends Thread{
	private String nombre;
	private Cajero cajero;
	private final int MAX_VENTAS = 20000;
	private int ventas = 0;	
	
	public Terminal(Cajero cajero, String nombre) {
		this.nombre = nombre;
		this.cajero = cajero;
	}
	
	@Override
	public void run() {
		while(ventas < MAX_VENTAS) {
			cajero.sumarLocalidades(1);
			ventas++;			
		}
		System.out.println("Terminal " + nombre + " ha vendido " + ventas + " localidades" );
	}
	
}