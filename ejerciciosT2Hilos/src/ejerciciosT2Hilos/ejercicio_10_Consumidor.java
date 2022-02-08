package ejerciciosT2Hilos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ejercicio_10_Consumidor extends Thread {
	char letra;	
	ejercicio_10_Cola cola;
	String nombre = "";
	public ejercicio_10_Consumidor(ejercicio_10_Cola cola, String nombre) {
		this.cola = cola;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		try {
			while(!cola.getEnd() && ((letra = cola.get()) != -1)){
				System.out.println( nombre + ":" + letra);			
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
