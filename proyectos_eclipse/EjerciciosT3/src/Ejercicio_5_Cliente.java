import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio_5_Cliente {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			String texto = "";
			int puertoServidor = 44444;
			
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
					texto = entrada.readUTF();
					System.out.println("Recibido: " + texto);					
				}
				
				
			} while (!texto.equals("*"));
			System.out.println("Fin de la conexión al servidor.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
