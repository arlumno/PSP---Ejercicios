package ejerciciosT2Hilos;

public class ejercicio_10_Master {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ejercicio_10_Cola cola = new ejercicio_10_Cola();
		ejercicio_10_Productor productor = new ejercicio_10_Productor(cola, ".//src//ejerciciosT2Hilos//archivos//1.txt");
		ejercicio_10_Consumidor c1= new ejercicio_10_Consumidor(cola, "consumidor 1");
		ejercicio_10_Consumidor c2= new ejercicio_10_Consumidor(cola, "consumidor 2");
		ejercicio_10_Consumidor c3= new ejercicio_10_Consumidor(cola, "consumidor 3");
		productor.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
