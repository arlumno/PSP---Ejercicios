package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Actividad_3_5_Cliente {
	public static void main(String[] args) {
		try {

			int puerto = 5555;
			Socket cliente = new Socket("localhost", puerto);
			
			
//			OutputStream os = cliente.getOutputStream();
//			DataOutputStream salida = new DataOutputStream(os);

			InputStream is = cliente.getInputStream();
			DataInputStream entrada = new DataInputStream(is);

			System.out.println("[Servidor]: " + entrada.readUTF());
			
			entrada.close();
//			salida.close();
			cliente.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
