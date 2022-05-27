package ActividadesGarceta.Actividad3_5;

import java.io.*;
import java.net.*;
public class actividad3_5Servidor {
  public static void main(String[] arg) throws IOException {
	int Puerto = 6000;// Puerto por el que escucha
	// INICIO EL SERVIDOR
	ServerSocket Servidor = new ServerSocket(Puerto);
	System.out.println("Escuchando en el puerto " + Puerto);
        
	//Acepto peticiones de 3 clientes
	for (int i = 1; i <= 3; i++) {
		Socket Cliente = Servidor.accept(); // ACEPTA PETICION
		System.out.println("Sirviendo al cliente " + i);

		// CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream aux = Cliente.getOutputStream();
		DataOutputStream flujo = new DataOutputStream(aux);

		// LE ENVIO UN SALUDO
		flujo.writeUTF("Saludo al cliente " + i);
		Cliente.close(); //cierro el socket cliente
	}
	Servidor.close();	//cierro socket servidor
	System.out.println("No hay m�s clientes...");
  }// main
}// fin
