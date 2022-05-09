package ejerciciosT2Hilos;

import java.util.ArrayList;

public class ejercicio_3_Master_Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> archivos= new ArrayList<String>();
		archivos.add(".\\src\\ejerciciosT2Hilos\\archivos\\01.txt");
		archivos.add(".\\src\\ejerciciosT2Hilos\\archivos\\02.txt");
		archivos.add(".\\src\\ejerciciosT2Hilos\\archivos\\03.txt");
		archivos.add(".\\src\\ejerciciosT2Hilos\\archivos\\04.txt");
		ejercicio_3_Thread_Gestor_Ficheros gestor = new ejercicio_3_Thread_Gestor_Ficheros(archivos);
		gestor.start();
	}

}
