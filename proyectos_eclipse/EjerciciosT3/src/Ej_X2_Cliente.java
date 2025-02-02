import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ej_X2_Cliente {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			String texto;
			int num = 0;
			Numero numero = null;
			int puertoServidor = 5555;
			boolean error;
			Socket cliente = new Socket("localhost", puertoServidor);			
			System.out.println("Iniciando");
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

			do {
				do {
					error = false;
					System.out.println("Escribe un numero, 0 para finalizar:");
					texto = lector.nextLine();
					try {
						num = Integer.parseInt(texto);
						
						numero = new Numero(num);
						
						oos.writeObject(numero);
					} catch (NumberFormatException e) {
						error = true;
						System.out.println("Error- no ha introducido un numero ");
					}
				} while (error);
				

				if (!numero.isFin()) {
					System.out.println("Enviado: " + numero.toString());
					numero = (Numero) ois.readObject();
					System.out.println("Recibido: " + numero.toString());
				}
			} while (!numero.isFin());

			System.out.println("Fin de la conexi�n al servidor.");
			lector.close();
			ois.close();
			oos.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
