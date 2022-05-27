package EjerciciosGarceta.E4;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class ClienteTCP {
	public static void main(String[] args) throws Exception {

		String Host = "localhost";
		int Puerto = 6000;// puerto remoto
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket Cliente = null;
		try {
		Cliente = new Socket(Host, Puerto);
		}
		catch(ConnectException s){
			System.out.println("SERVIDOR NO CONECTADO...");
			System.exit(1);;
		}

		// CREO FLUJO DE SALIDA AL SERVIDOR
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		ObjectInputStream flujoEntrada = new ObjectInputStream(Cliente.getInputStream());
		
		Integer idcliente = (Integer) flujoEntrada.readObject();
		System.out.println("SOY EL CLIENTE: " + idcliente);
		
		String cadena ="";
		Profesor profe =new Profesor();
		while (true) {
			System.out.println("=====================================================");
			System.out.print("Introduce identificador a consultar: ");
			cadena = in.readLine();

			if (cadena.trim().equals("*"))
				break;

			try {
				 Integer.parseInt(cadena);
			} catch (NumberFormatException nex) {
				System.out.println("\tIdentificador incorrecto: ");
				continue;
			}

			// ENVIANDO AL SERVIDOR
			try{
			  flujoSalida.writeUTF(cadena);
			}
			catch(SocketException se){
				System.out.println("ERROR AL ENVIAR DATOS AL SERVIDOR (el proceo finalizará)...");
				break;				
			}
			
			// RECIBIENDO DEL SERVIDOR
			profe = (Profesor) flujoEntrada.readObject();	
			
			// visualizo datos
			System.out.printf("\tNombre: %s, Especialidad: %d - %s %n", profe.getNombre(), profe.getEspe().getId(),
					profe.getEspe().getNombreespe());
			
			Asignatura[] asig = profe.getAsignaturas();
			try {
				for (int j = 0; j < asig.length; j++) {
					System.out.printf("\t\tAsignatura: %d - %s %n", asig[j].getId(), asig[j].getNombreasig());
				}
			} catch (java.lang.NullPointerException m) {
			}

		} // WHILE TRUE

		// CERRAR STREAMS Y SOCKETS
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();

		System.out.print("Fin de cliente... ");
	}// main

}
