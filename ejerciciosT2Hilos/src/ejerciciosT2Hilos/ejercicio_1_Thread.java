package ejerciciosT2Hilos;

public class ejercicio_1_Thread extends Thread {
	public void run(){
		System.out.println("[Id: " + getId() + "] --- > Hola mundo");
	}
}
