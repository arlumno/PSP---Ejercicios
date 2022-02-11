package ejerciciosT2Hilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

class repaso_ejercicio_3 {
	// desde run config > arguments
//	src\\ejerciciosT2Hilos\\archivos\\01.txt
//	src\\ejerciciosT2Hilos\\archivos\\02.txt
//	src\\ejerciciosT2Hilos\\archivos\\03.txt

	public static void main(String[] args) {
		File archivo;
		for (String ruta : args) {
			archivo = new File(ruta);
			if (!archivo.exists()) {
				System.out.println("no existe");
			} else {
				System.out.println(archivo.getName());
				(new contarLetras(archivo)).start();
			}

		}
		System.out.println("Fin");
	}

}

class contarLetras extends Thread {
	long tiempoInicio;
	long tiempoFin;
	long tiempoTotal;
	File archivo;
	int contador = 0;

	public contarLetras(File archivo) {
		this.archivo = archivo;
	}

	@Override
	public void run() {
		tiempoInicio = System.currentTimeMillis();
		try {
			FileReader fr = new FileReader(archivo);
			while (fr.read() != -1) {
				contador++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		tiempoFin = System.currentTimeMillis();
		tiempoTotal = tiempoFin - tiempoInicio;
		System.out.println("[" + archivo.getName() + "] Se han contado " + contador + " caracteres" + " [Tiempo: "
				+ tiempoTotal + "]");

	}

}
