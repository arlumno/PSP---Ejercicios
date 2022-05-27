package Ejs_boletines.Bol4_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clienteUDPLogin {
	public static void main(String[] args) throws IOException {
		InetAddress destino = InetAddress.getLocalHost();
		int port = 12345;
		byte[] mensaje = new byte[1024];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket socket = new DatagramSocket(34567);

		System.out.println("Introduzca usuario:");
		String user = in.readLine();
		mensaje = user.getBytes();

		DatagramPacket envioU = new DatagramPacket(mensaje, mensaje.length, destino, port);
		socket.send(envioU);

		System.out.println("Introduzca contraseña:");
		String pass = in.readLine();
		mensaje = pass.getBytes();

		DatagramPacket envioP = new DatagramPacket(mensaje, mensaje.length, destino, port);
		socket.send(envioP);

		socket.close();
	}
}
