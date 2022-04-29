import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Actividad_3_2_Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int port = 9876;
			ServerSocket server = new ServerSocket(port);
			System.out.println("Escuchando por puerto: "+ server.getLocalPort());
			
			System.out.println("Esperando por cliente 1...");
			Socket clienteA = server.accept();
			listarInfoSocket(clienteA,"Cliente A");
			
			System.out.println("Esperando por cliente 2...");
			Socket clienteB = server.accept();
			listarInfoSocket(clienteB,"Cliente B");
			
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void listarInfoSocket(Socket socket, String name) {
		String tag = "[" + name + "]";
		System.out.println(tag +" Puerto local: " + socket.getLocalPort());
		System.out.println(tag +" Puerto remoto: " + socket.getRemoteSocketAddress());
		System.out.println(tag +" Nombre Host: " + socket.getInetAddress());		
	}
}
