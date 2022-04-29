import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Actividad_3_2_Client {

	public static void main(String[] args) {
		try {
			String host = "localhost";
			int port = 9876;
			
			System.out.println("Conectando a: " + host + ":" + port);
			Socket cliente = new Socket(host, port); 
			
			InetAddress i = cliente.getInetAddress();
			
			listarInfoSocket(cliente,"");
			listarInfoInetAddress(i,"");
			
			cliente.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
	
	public static void listarInfoInetAddress(InetAddress inetAddress, String name) {
		String tag = "[" + name + "]";
		System.out.println(tag +" Host Remoto: " + inetAddress.getHostName());
		System.out.println(tag +" Ip Host remoto: " + inetAddress.getHostAddress());
			
	}

}
