package soluciones.object_tcp.Bol3_1_clase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteDoble {
	public static void main(String[] args) {
		ObjectOutputStream salida;
		ObjectInputStream entrada;
		Numero num = new Numero();
		Socket socket;
		Scanner in = new Scanner(System.in);
		
		try {
			socket = new Socket("127.0.0.1", 4000);
			salida = new ObjectOutputStream(socket.getOutputStream());
			
			if (socket != null)
				System.out.println("Conectado con el servidor");
			
			System.out.println("Introduce un número entero");
			num.setNumero(in.nextInt());
			salida.writeObject(num);

			entrada = new ObjectInputStream(socket.getInputStream());
			num = (Numero) entrada.readObject();
			
			System.out.println("El cuadrado de: " + num.getNumero() + " es: " + num.getCuadrado() + ", y el cubo: " + num.getCubo());
			socket.close();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
