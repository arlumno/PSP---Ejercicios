package soluciones.tcp.Actividad3_5_2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class actividad3_5Cliente {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el número de conexiones activas: ");
		int numC = sc.nextInt();

		String Host = "localhost";
		int Puerto = 6000;
		System.out.println("Conectando con el servidor...");

		// Creo clientes
		for (int i = 1; i <= numC; i++) {
			// ABRIR SOCKET
			Socket Cliente = null;

			try {
				Cliente = new Socket(Host, Puerto);
			} catch (ConnectException c) {
				System.out.println("SERVIDOR CERRADO. ");
				return;
			}
			// RECIBO SALUDO DEL SERVIDOR
			InputStream aux = Cliente.getInputStream();
			DataInputStream flujo = new DataInputStream(aux);

			System.out.println("Recibiendo del servidor: " + flujo.readUTF());

			System.out.println("CLIENTE " + i + " CERRADO. ");

			Cliente.close();// Cierra el socket
		}
	}// main
}//
