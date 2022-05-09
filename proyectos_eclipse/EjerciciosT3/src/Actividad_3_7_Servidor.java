import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Actividad_3_7_Servidor {

	public static void main(String[] args) {
		try {
			Numeros numero;
			int puerto = 5555;
			ServerSocket server = new ServerSocket(puerto);
			System.out.println("Esperando cliente...");
			Socket cliente = server.accept();
			cliente.setSoTimeout(10000);				

			ObjectInputStream ois =new ObjectInputStream(cliente.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

			do {

				numero = (Numeros) ois.readObject();
				System.out.println("recibido objeto: " + numero.toString());
				
				numero.setCuadrado((long) Math.pow(numero.getNumero(), 2));
				numero.setCubo((long) Math.pow(numero.getNumero(), 3));
				
				
				oos.writeObject(numero);
				System.out.println("enviado objeto: " + numero.toString());
				
			} while (numero.getNumero() > 0);


			cliente.close();
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
