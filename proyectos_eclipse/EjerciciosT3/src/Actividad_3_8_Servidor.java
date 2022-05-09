import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Actividad_3_8_Servidor {

	public static void main(String[] args) {
		try {
			Numeros numero;
			int puerto = 5555;
			ServerSocket server = new ServerSocket(puerto);
			System.out.println("Esperando cliente...");
			DatagramSocket servidorSocket = new DatagramSocket(puerto);
//			cliente.setSoTimeout(10000);				
			
			
			InetAddress ipCliente;
			int puertoCliente;
			
			byte[] bytesRecibidos = new byte[1024];
			DatagramPacket paqueteSalida; 
			DatagramPacket paqueteEntrada;
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			ByteArrayOutputStream baos = null;			
			ByteArrayInputStream bais = null;
			
			do {

				bytesRecibidos = new byte[1024];
				
				paqueteEntrada = new DatagramPacket(bytesRecibidos,bytesRecibidos.length);
				
				servidorSocket.receive(paqueteEntrada);		
				
				bais = new ByteArrayInputStream(bytesRecibidos);
				ois = new ObjectInputStream(bais);		
				numero = new Numeros();
				numero = (Numeros) ois.readObject();
				
				bais.close();				
				ois.close();
				
				System.out.println("Recibido del cliente: \n " + numero.toString());					
				
				numero.setCuadrado((long) Math.pow(numero.getNumero(), 2));
				numero.setCubo((long) Math.pow(numero.getNumero(), 3));
				
				
				ipCliente = paqueteEntrada.getAddress();
				puertoCliente = paqueteEntrada.getPort();
				
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.reset();
				oos.writeObject(numero);
				byte[] bytesEnviados = baos.toByteArray();
				paqueteSalida = new DatagramPacket(bytesEnviados, bytesEnviados.length, ipCliente, puertoCliente);
				servidorSocket.send(paqueteSalida);
				
				baos.close();
				oos.close();
				
				System.out.println("Enviado objeto: " + numero.toString());
				
			} while (numero.getNumero() > 0);


			servidorSocket.close();
		} catch(SocketTimeoutException e) {
			System.out.println("El cliente se ha desconectado. ");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
