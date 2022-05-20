package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Ej_X3_Cliente {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		try {

			int puertoServidor = 12345;
			int puertoLocal = 54321;
			InetAddress ipServer = InetAddress.getLocalHost();
			String texto;
			DatagramSocket socket = new DatagramSocket(puertoLocal);
			socket.setSoTimeout(4000);				
			boolean fin = false;
			byte[] mensajeSalida;
			byte[] mensajeEntrada;
			DatagramPacket paqueteEntrada;
			DatagramPacket paqueteSalida;

			while (!fin) {
				mensajeSalida = new byte[1024];
				System.out.println("Introduce el texto:");
				texto = lector.nextLine();
				mensajeSalida = texto.getBytes();
				paqueteSalida = new DatagramPacket(mensajeSalida, mensajeSalida.length, ipServer, puertoServidor);
				socket.send(paqueteSalida);
				
				if (texto.equals("*")) {
					fin = true;
				}
				mensajeEntrada = new byte[1024];
				paqueteEntrada = new DatagramPacket(mensajeEntrada, mensajeEntrada.length, ipServer, puertoServidor);
				try {
					socket.receive(paqueteEntrada);
					String textoEntrada = new String(paqueteEntrada.getData());
					System.out.println("Recibido del servidor: " + textoEntrada);
				} catch (SocketTimeoutException e) {
					System.out.println("Se ha perdido un paquete. Vuelva a intentarlo");
				}

			}
			System.out.println("Fin del programa");
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
