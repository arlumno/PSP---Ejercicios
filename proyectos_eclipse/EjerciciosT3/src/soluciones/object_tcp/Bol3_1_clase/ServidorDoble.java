package soluciones.object_tcp.Bol3_1_clase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDoble {
	public static void main(String[] args) {
		ServerSocket servidor;
		Socket socket;
		ObjectOutputStream salida;
		ObjectInputStream entrada;
		Numero num;
		
		System.out.println("Esperando por el cliente");
		
		try {
			servidor = new ServerSocket(4000);
			socket = new Socket();
			socket = servidor.accept();
			
			if (socket != null)
				System.out.println("Conectado con el cliente");
			
			entrada = new ObjectInputStream(socket.getInputStream());
			num = (Numero) entrada.readObject();
			
			num.setCuadrado((int)Math.pow(num.getNumero(), 2));
			num.setCubo((int)Math.pow(num.getNumero(), 3));

			salida = new ObjectOutputStream(socket.getOutputStream());
			salida.writeObject(num);
			socket.close();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
