package ejerciciosT2Hilos;

import java.util.ArrayList;

public class ejercicio_3_Thread_Gestor_Ficheros extends Thread {
	ArrayList<String> archivos;
	public ejercicio_3_Thread_Gestor_Ficheros(ArrayList<String> archivos) {
		this.archivos = archivos;
				
		ejercicio_3_Thread_Contador contarArchivo1 = new ejercicio_3_Thread_Contador(archivos.get(0),"contador 01");		
		ejercicio_3_Thread_Contador contarArchivo2 = new ejercicio_3_Thread_Contador(archivos.get(1),"contador 02");
		ejercicio_3_Thread_Contador contarArchivo3 = new ejercicio_3_Thread_Contador(archivos.get(2),"contador 03");
		ejercicio_3_Thread_Contador contarArchivo4 = new ejercicio_3_Thread_Contador(archivos.get(3),"contador 04");
		contarArchivo1.start();
		contarArchivo2.start();
		contarArchivo3.start();
		contarArchivo4.start();
		//ejercicio_3_Thread_Contador contarArchivo2 = new ejercicio_3_Thread_Contador(archivos.get(1));
		
	}
}
