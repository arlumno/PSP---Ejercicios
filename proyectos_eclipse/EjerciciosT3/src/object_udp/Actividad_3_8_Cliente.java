package object_udp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad_3_8_Cliente {

	public static void main(String[] args) {
		try {			
			Scanner lector = new Scanner(System.in);

			Numeros numero = null;
			int puertoServidor = 5555;
			InetAddress ipServer = InetAddress.getLocalHost();
			String texto;
			DatagramSocket cliente = null;
			int num = 0;
			
			while(cliente == null) {				
				try {
					cliente = new DatagramSocket();			
					cliente.setSoTimeout(4000);				
				}catch (ConnectException e) {
					System.out.println("Error al conectar con el servidor. Reintentando en 5 secs...");
					Thread.sleep(5000);
				}
			}
			
			byte[] bytesRecibidos = new byte[1024];
			DatagramPacket paqueteSalida; 
			DatagramPacket paqueteEntrada;
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			ByteArrayOutputStream baos = null;
			ByteArrayInputStream bais = null;
			
			do {
				
				boolean error;
				do {
					System.out.println("Indica un numero:");
					try {
						num = lector.nextInt();
						numero = new Numeros(num);
						error = false;
					}catch (InputMismatchException e) {
						System.out.println("Debe introducir un numero");
						lector.nextLine();
						error = true;
					}
				}while(error);
				
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);				
				oos.writeObject(numero);
				System.out.println("Enviado objeto: " + numero.toString());
				
				byte[] bytesEnviados = baos.toByteArray();
				paqueteSalida = new DatagramPacket(bytesEnviados, bytesEnviados.length, ipServer, puertoServidor);
				cliente.send(paqueteSalida);
				baos.close();
				oos.close();
				
				
				if(num > 0) {
					bytesRecibidos = new byte[1024];
					paqueteEntrada = new DatagramPacket(bytesRecibidos,bytesRecibidos.length);
					cliente.receive(paqueteEntrada);
					bais = new ByteArrayInputStream(bytesRecibidos);
					ois = new ObjectInputStream(bais);
					
					numero = (Numeros) ois.readObject();
					
					bais.close();
					ois.close();
					System.out.println("Recibido del servidor: \n " + numero.toString());					
				}
			} while (num > 0);

			cliente.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
