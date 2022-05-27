package soluciones.tcp.E1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente_ejer1 {
  public static void main(String[] args) throws IOException {
	String Host = "localhost";
	int Puerto = 6000;// puerto remoto
	Socket Cliente = new Socket(Host, Puerto);
		
	// CREO FLUJO DE SALIDA AL SERVIDOR	
	OutputStream salida = null;
	salida = Cliente.getOutputStream();
	DataOutputStream fsalida = new DataOutputStream(salida);
			 
	// CREO FLUJO DE ENTRADA DE SERVIDOR
	InputStream entrada = null;
	entrada = Cliente.getInputStream();
	DataInputStream flujoEntrada = new DataInputStream(entrada);
	
	String cadena;
	Scanner sc = new Scanner(System.in);
	System.out.print("Introduce cadena: ");
	cadena = sc.nextLine();
	while(!cadena.equals("*")){	
		fsalida.writeUTF(cadena);	
		Integer longitud = flujoEntrada.readInt();
		System.out.print("\tNúmero de caracteres: "+longitud);
		System.out.println("Introduce cadena: ");
		cadena = sc.nextLine();
	} 
	fsalida.writeUTF("*");	
	fsalida.close();
	flujoEntrada.close();
	System.out.println("Fin de proceso... ");
	Cliente.close();
	}//
}//
