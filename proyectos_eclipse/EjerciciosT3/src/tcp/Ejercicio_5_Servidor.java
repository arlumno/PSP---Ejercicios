package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio_5_Servidor {
	public static void main(String[] args) {
		try {
			ServerSocket servidor;
			servidor = new ServerSocket(44444);
			System.out.println("Servidor iniciado...");
			while(true) {
				Socket cliente = new Socket();
				cliente = servidor.accept();
				Ejercicio_5_Hilo hilo = new Ejercicio_5_Hilo(cliente);
				hilo.start();
			}
					
//			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


class Ejercicio_5_Hilo extends Thread{
	Socket cliente;
	DataInputStream entrada;
	DataOutputStream salida;
	OutputStream os;
	InputStream is;
	String texto;
	boolean fin = false;
	
	public Ejercicio_5_Hilo(Socket cliente) {
		this.cliente = cliente;
		System.out.println("Nuevo cliente ->  IP:" + cliente.getInetAddress() + " - Puerto:" + cliente.getPort());
	}	
	
	@Override
	public void run() {
		try {
			while(!fin) {				
				is = cliente.getInputStream();
				entrada = new DataInputStream(is);
				texto = entrada.readUTF();
				
				if(texto.equals("*")) {
					fin = true;
				}else{
					os = cliente.getOutputStream();
					salida = new DataOutputStream(os);
					salida.writeUTF(texto.toUpperCase());					
				}
			}
			System.out.println("Desconexión del cliente: " + cliente.getInetAddress() + " / " + cliente.getPort());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}