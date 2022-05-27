package ActividadesGarceta.Actividad3_5_2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class actividad3_5Servidor {
	public static void main(String[] arg) throws IOException {
		Scanner sc = new Scanner(System.in);
		int Puerto = 6000;// Puerto por el que escucha
		System.out.println("Introduzca el número de conexiones activas: ");
		int numC = sc.nextInt();
		
		// INICIO EL SERVIDOR
		ServerSocket Servidor = new ServerSocket(Puerto);
		System.out.println("Escuchando en el puerto " + Puerto);

		// Acepto peticiones de 3 clientes
		for (int i = 1; i <= numC; i++) {
			Socket Cliente = Servidor.accept(); // ACEPTA PETICION
			System.out.println("Sirviendo al cliente " + i);

			// CREO FLUJO DE SALIDA AL CLIENTE
			OutputStream aux = Cliente.getOutputStream();
			DataOutputStream flujo = new DataOutputStream(aux);

			// LE ENVIO UN SALUDO
			flujo.writeUTF("Saludo al cliente " + i);
			Cliente.close(); // cierro el socket cliente
		}
		Servidor.close(); // cierro socket servidor
		System.out.println("No hay más clientes...");
	}// main
}// fin
