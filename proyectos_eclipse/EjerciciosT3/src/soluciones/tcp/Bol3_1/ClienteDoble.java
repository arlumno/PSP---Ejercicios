package soluciones.tcp.Bol3_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteDoble {
	public static void main(String[] args) {
		DataOutputStream salida;
		DataInputStream entrada;
		Socket socket;
		int num;
		Scanner in = new Scanner(System.in);
		
		try {
			socket = new Socket("127.0.0.1", 4000);
			
			if (socket != null)
				System.out.println("Conectado con el servidor");
			
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Introduce un número entero");
			num = in.nextInt();
			
			salida.writeInt(num);
			int resultado = entrada.readInt();
			
			System.out.println("El doble de: " + num + " es: " + resultado);
			socket.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
