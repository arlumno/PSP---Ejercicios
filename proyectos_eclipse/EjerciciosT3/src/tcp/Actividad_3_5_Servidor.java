package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad_3_5_Servidor {

	public static void main(String[] args) {
		try {
			int puerto = 5555;
			int maxClientes = 3;
			ServerSocket server = new ServerSocket(puerto);
			Socket[] clientes = new Socket[maxClientes];
			DataOutputStream[] salidas = new DataOutputStream[maxClientes];
//			DataInputStream[] entradas = new DataInputStream[maxClientes];
			
			for(int i = 0; i<maxClientes;i++) {
				System.out.println("A la espera del cliente...");
				clientes[i] = server.accept();
				
				salidas[i] = new DataOutputStream(clientes[i].getOutputStream());				
//				entradas[i] = new DataInputStream(clientes[i].getInputStream());
				salidas[i].writeUTF("Eres el cliente nº: " + (i+1));
				salidas[i].close();
				System.out.println("Cliente nummero " + (i+1) + " asignado");
			}

			server.close();
			System.out.println("Fin del servicio");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
