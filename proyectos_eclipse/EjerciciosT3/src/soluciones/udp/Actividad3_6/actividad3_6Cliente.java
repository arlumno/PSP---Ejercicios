package soluciones.udp.Actividad3_6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Scanner;

public class actividad3_6Cliente {

	private static Scanner sc;

	public static void main(String[] args) throws IOException {

		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345; // puerto al que envio
		byte[] mensaje = new byte[1024];

		DatagramPacket envio;
		DatagramPacket recibo;
		DatagramSocket socket = new DatagramSocket();

		String cadena;
		socket.setSoTimeout(5000);
		sc = new Scanner(System.in);
		System.out.print("Introduce cadena: ");
		cadena = sc.nextLine();
		while (!cadena.equals("*")) {
			mensaje = new byte[1024];
			mensaje = cadena.getBytes();
			envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
			socket.send(envio);// envio datagrama

			// recibo cadena del servidor
			byte[] buferrec = new byte[1024]; // para recibir el datagrama
			recibo = new DatagramPacket(buferrec, buferrec.length);

			try {
				socket.receive(recibo);
				String mayuscula = new String(recibo.getData()).trim();
				System.out.print("\tMayúsculas: " + mayuscula);
			} catch (InterruptedIOException i) {
				System.out.println("\tPAQUETE PERDIDO, SIN MAYUSCULAS.");
			}

			System.out.print("\nIntroduce cadena: ");
			cadena = sc.nextLine();
		}

		envio = new DatagramPacket("*".getBytes(), "*".getBytes().length, destino, port);
		socket.send(envio);// envio datagrama
		socket.close(); // cierro el socket
		System.out.println("Fin de cliente ");
		sc.close();
	}

}
