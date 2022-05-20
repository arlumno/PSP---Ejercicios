package object_tcp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejemplo_381_Adivina_Cliente {

	public static void main(String[] args) {
		try {
			Socket servidor = new Socket("localhost", 6001);

			ObjectOutputStream salida = new ObjectOutputStream(servidor.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(servidor.getInputStream());

			Scanner lector = new Scanner(System.in);
			String sms = "";
			
			DatosPartida partida = (DatosPartida) entrada.readObject();
			int idJugador = partida.getIdJugador();
			System.out.println("Conectado con id de jugador: " + idJugador);
			System.out.println(partida.getSms());
			
			if(partida.isGameOver()){
				sms = "*";
			}
			
			while(!partida.isGameOver() && !sms.equals("*")) {
				System.out.println("Intento: " + (partida.getIntentos() + 1)+ " -> Introduce un número:");
				sms = lector.nextLine();
				partida = new DatosPartida();
				
				partida.setSms(sms);
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
