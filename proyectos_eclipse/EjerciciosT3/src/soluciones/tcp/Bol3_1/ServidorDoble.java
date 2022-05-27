package soluciones.tcp.Bol3_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Realizar un programa cliente que lea un entero por teclado y se 
 * lo envíe a un programa servidor que le devolverá el doble 
 * del número. El cliente tiene que escribirla en la consola 
 * tanto el número enviado como el doble recibido.
 * 
 * */

public class ServidorDoble {
	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		DataOutputStream salida;
		DataInputStream entrada;
		
		System.out.println("Esperando por el cliente");
		
		try {
			servidor = new ServerSocket(4000);
			socket = new Socket();
			socket = servidor.accept();
			
			if (socket != null)
				System.out.println("Conectado con el cliente");
			
			entrada = new DataInputStream(socket.getInputStream());
			int numero = entrada.readInt();
			
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeInt(numero * 2);
			socket.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
