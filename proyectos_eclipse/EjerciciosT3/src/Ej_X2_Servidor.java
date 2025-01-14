import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Realizar un programa cliente que lea un entero por teclado y se lo env�e a un programa servidor que le devolver� el doble del numero.
 * El cliente tiene que escribirla en la consola tanto el numero enviado com oel doble recibido. 
 * */

public class Ej_X2_Servidor {

	public static void main(String[] args) {
		try {
			int puerto = 5555;
			ServerSocket server = new ServerSocket(puerto);

			System.out.println("A la espera del cliente...");

			Socket cliente = server.accept();

			ObjectInputStream objetoEntrada =new ObjectInputStream(cliente.getInputStream());
			ObjectOutputStream objetoSalida = new ObjectOutputStream(cliente.getOutputStream());


			Numero numero;

			while (true) {
				numero = (Numero) objetoEntrada.readObject();
				if(numero.isFin()) {
					System.out.println("Fin del servicio");
					break;
				}
				
				numero.realizarOperaciones();
				objetoSalida.writeObject(numero);
				
			}

			objetoEntrada.close();
			objetoSalida.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Numero implements Serializable{
	int numero;
	boolean fin = false;
	int cuadrado;
	int cubo;
	public Numero(int numero) {
		this.numero = numero;
		// TODO Auto-generated constructor stub
	}
	
	public boolean isFin() {
		return fin;
	}
	
	
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	public void realizarOperaciones() {
		cuadrado = numero * numero ;
		cubo =   cuadrado * numero ;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getCuadrado() {
		return cuadrado;
	}
	public int getCubo() {
		return cubo;
	}
	
	public String toString() {
		return "Numeros [numero=" + numero + ", cuadrado=" + cuadrado + ", cubo=" + cubo + "]";
	}
	
}