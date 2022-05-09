package ejerciciosT2Hilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ejercicio_3_Thread_Contador extends Thread {
	private File file;	
	public String nombre;
	
	public ejercicio_3_Thread_Contador(String rutaArchivo,String nombre) {
		this.file = new File(rutaArchivo);
		this.nombre = nombre;
	}
	
	public void run() {
		long inicio = System.currentTimeMillis();
		long fin;
		long tiempo; 
		int contador = 0;
		
		if(file.exists()) {
			try(FileReader fr= new FileReader(file);) {							
				int letra;
				while((letra = fr.read()) != -1){
					contador++;
				}

			}catch (Exception e) {
				System.out.println("["+ nombre +"] Error en el acceso al flujo de datos " + e.toString());
			}
		}else{
			System.out.println("["+ nombre +"] El archivo " + file.getPath() + " NO existe");
		}
		
		fin= System.currentTimeMillis();
		tiempo = fin - inicio;
		System.out.println("["+ nombre +"] Tiempo de procesamiento " + tiempo + "ms - Total Letras: " + contador);
	}
}
