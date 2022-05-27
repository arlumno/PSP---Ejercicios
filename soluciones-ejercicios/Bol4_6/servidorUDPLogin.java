package Ejs_boletines.Bol4_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 
 * Realizar una comunicación cliente-servidor, el protocolo 
 * de transporte que usaremos será UDP. Realiza un programa 
 * cliente-servidor que solicite al usuario (parte cliente) un 
 * usuario y una contraseña. El servidor recibirá esa información 
 * y se encargará de compararla con dos valores de usuario y 
 * contraseña predeterminados (por ejemplo, “alumno” y “java”), 
 * guardados en dos variables. El programa informará por consola 
 * (en la del servidor) de la coincidencia o disparidad de los datos 
 * introducidos por el usuario con los mantenidos en esas dos variables.
 * 
 * */

public class servidorUDPLogin {
	public static void main(String[] args) {
		String login = "alumno";
		String password = "java";

		byte[] bufer = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			System.out.println("Esperando datagrama");

			DatagramPacket reciboU = new DatagramPacket(bufer, bufer.length);
			socket.receive(reciboU);

			String user = new String(reciboU.getData(), 0, reciboU.getLength());

			System.out.println("Nombre de usuario: " + user.trim());
			user = user.trim();

			if (user.equals(login)) {
				System.out.println("Nombre de usuario correcto");
			} else {
				System.out.println("Nombre de usuario incorrecto");
			}

			System.out.println("Esperando datagrama");
			DatagramPacket reciboP = new DatagramPacket(bufer, bufer.length);
			socket.receive(reciboP);

			String pass = new String(reciboP.getData(), 0, reciboP.getLength());
			System.out.println("Contraseña: " + pass.trim());
			pass = pass.trim();
			if (pass.equals(password))
				System.out.println("Contraseña correcta");
			else
				System.out.println("Contraseña incorrecta");

			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
