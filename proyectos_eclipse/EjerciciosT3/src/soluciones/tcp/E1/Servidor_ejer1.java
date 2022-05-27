package soluciones.tcp.E1;

import java.io.*;
import java.net.*;

public class Servidor_ejer1 {
	public static void main(String[] arg) throws IOException {
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		String cad = "";

		System.out.println("Esperando conexion...");
		Socket Cliente = servidor.accept();
		System.out.println("Cliente conectado...");

		// CREO FLUJO DE SALIDA AL SERVIDOR
		OutputStream salida = null;
		salida = Cliente.getOutputStream();
		DataOutputStream fsalida = new DataOutputStream(salida);

		// CREO FLUJO DE ENTRADA DE SERVIDOR
		InputStream entrada = null;
		entrada = Cliente.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);

		cad = flujoEntrada.readUTF();
		while (!cad.equals("*")) {
			Integer n = cad.length();
			System.out.println("Recibiendo: " + cad + " enviando: " + n);
			fsalida.writeInt(n);
			cad = flujoEntrada.readUTF();
		}
		// CERRAR STREAMS Y SOCKETS
		System.out.println("Cerrando conexion...");

		flujoEntrada.close();
		fsalida.close();
		Cliente.close();
		servidor.close();
	}// main
}// fin