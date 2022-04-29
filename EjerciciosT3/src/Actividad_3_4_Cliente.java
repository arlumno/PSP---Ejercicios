import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad_3_4_Cliente {

	public static void main(String[] args) {
		try {

			int puerto = 5555;
			Socket cliente = new Socket("localhost", puerto);

			OutputStream os = cliente.getOutputStream();
			DataOutputStream salida = new DataOutputStream(os);

			InputStream is = cliente.getInputStream();
			DataInputStream entrada = new DataInputStream(is);

			Scanner lector = new Scanner(System.in);
			System.out.println("Indica un numero");
			boolean error;
			String texto;
			int numero = 0;
			do {
				try {
					texto = lector.nextLine();
					numero = Integer.parseInt(texto);
					error = false;
				} catch (NumberFormatException e) {
					System.out.println("Debe introducir un numero");
					error = true;
				}
			} while (error);

			salida.writeInt(numero);

			System.out.println("[Servidor]: " + entrada.readInt());

			entrada.close();
			salida.close();
			cliente.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
