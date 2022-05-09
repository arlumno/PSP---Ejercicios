import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad_3_7_Cliente {

	public static void main(String[] args) {
		try {			
			Scanner lector = new Scanner(System.in);

			Numeros numero = null;
			int puerto = 5555;
			int num = 0;
			Socket cliente = null;
			
			while(cliente == null) {				
				try {
					cliente = new Socket("localhost", puerto);			
					cliente.setSoTimeout(4000);				
				}catch (ConnectException e) {
					System.out.println("Error al conectar con el servidor. Reintentando en 5 secs...");
					Thread.sleep(5000);
				}
			}
			

			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

			boolean error;
			do {
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
				
				oos.writeObject(numero);
				System.out.println("Enviado objeto: " + numero.toString());
				
				if (num > 0) {
					numero = (Numeros) ois.readObject();
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

class Numeros implements Serializable {
	int numero;
	long cuadrado;
	long cubo;

	public Numeros(int numero) {
		this.numero = numero;
	}

	public Numeros() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(long cuadrado) {
		this.cuadrado = cuadrado;
	}

	public long getCubo() {
		return cubo;
	}

	public void setCubo(long cubo) {
		this.cubo = cubo;
	}

	@Override
	public String toString() {
		return "Numeros [numero=" + numero + ", cuadrado=" + cuadrado + ", cubo=" + cubo + "]";
	}

}