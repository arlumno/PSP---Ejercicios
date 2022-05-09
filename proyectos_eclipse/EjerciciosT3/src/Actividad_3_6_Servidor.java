import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Actividad_3_6_Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 12345;
		DatagramPacket paqueteEntrada;
		DatagramPacket paqueteSalida;
		byte[] bufer = new byte[1024];
		boolean fin = false;
		byte[] mensajeRetorno = new byte[1024];
		String mensaje;
		InetAddress ipCliente;
		int puertoCliente;

		try {
			DatagramSocket socket = new DatagramSocket(port);

			while (!fin) {
				System.out.println("Esperando datagrama.");
				bufer = new byte[1024];				
				paqueteEntrada = new DatagramPacket(bufer, bufer.length);
				socket.receive(paqueteEntrada);
				System.out.println("Datagrama recibido.");

				mensaje = new String(paqueteEntrada.getData()).trim();
				System.out.println("Mensaje:" + mensaje);
				ipCliente = paqueteEntrada.getAddress();
				puertoCliente = paqueteEntrada.getPort();

				if (mensaje.equals("*")) {
					fin = true;
					mensajeRetorno = ("Fin").getBytes();
					System.out.println("Fin del servicio");
				} else {

					mensajeRetorno = mensaje.toUpperCase().getBytes();
				}
				paqueteSalida = new DatagramPacket(mensajeRetorno, mensajeRetorno.length, ipCliente, puertoCliente);
				socket.send(paqueteSalida);
			}

			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
