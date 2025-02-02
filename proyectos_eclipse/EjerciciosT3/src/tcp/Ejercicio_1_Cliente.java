package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio_1_Cliente {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			String texto = "";
			int numero;
			int puertoServidor = 5555;
			
			Socket cliente = new Socket("localhost", puertoServidor);
			
			OutputStream os = cliente.getOutputStream();
			DataOutputStream salida = new DataOutputStream(os);
	
			InputStream is = cliente.getInputStream();
			DataInputStream entrada = new DataInputStream(is);
		
			do {
				System.out.println("Escribe un texto:");
				texto = lector.nextLine();
				salida.writeUTF(texto);
				
				if(!texto.equals("*")) {
					numero = entrada.readInt();
					System.out.println("Recibido: " + numero);					
				}							
			} while (!texto.equals("*"));
			
			System.out.println("Fin de la conexi�n al servidor.");
			lector.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
