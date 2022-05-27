package EjerciciosGarceta.E3;

import java.io.*;
import java.net.*;

public class clienteUDPalum {
	public static void main(String args[]) throws Exception {
		// SOCKET cliente
		DatagramSocket clientSocket = new DatagramSocket();
		
		// FLUJO PARA ENTRADA ESTANDAR
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// DATOS DEL SERVIDOR
		InetAddress IPServidor = InetAddress.getLocalHost();// localhost
		int puerto = 9876; // puerto por el que escucha

		while (true) {
			System.out.print("Introduce identificador a consultar: ");
			String cadena = in.readLine();
			
			/*Integer identificador = 0;
			
			try {
				identificador = Integer.parseInt(cadena);
			} catch (NumberFormatException nex) {
				continue;
			}*/
			
			if(cadena.trim().equals("*")) break;
			// convertimos objeto a bytes
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bs);
			os.writeObject(cadena); // 
			os.close();
			
			// ENVIANDO AL SERVIDOR
			byte[] enviados = bs.toByteArray();			
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
			clientSocket.send(envio);

			// RECIBIENDO DEL SERVIDOR
			byte[] recibidos = new byte[1024];
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
			
			try {
				// TIEMPO DE ESPERA
				clientSocket.setSoTimeout(5000);
				clientSocket.receive(recibo);
				// CONVERTIMOS bytes a objeto
				ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
				ObjectInputStream is = new ObjectInputStream(bais);
				Alumno alumno = (Alumno) is.readObject();
				is.close();
				// visualizo datos
				System.out.printf("\tNombre: %s, Curso: %s - %s, Nota: %d %n", 
						alumno.getNombre(), alumno.getCurso().getId(),
						alumno.getCurso().getDescripcion(),
						alumno.getNota());
			} catch (InterruptedIOException ii) {
				System.out.println("\t2<<FINALIZADO TIEMPO DE ESPERA - PAQUETE PERDIDO>>");				
			}
		}
		clientSocket.close();// cerrar socket
		System.out.print("Fin de cliente... ");
	}
}