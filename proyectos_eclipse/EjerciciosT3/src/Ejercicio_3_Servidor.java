import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_3_Servidor {

	public static void main(String[] args) {
			try {
				Numeros numero;
				int puerto = 5555;
				ServerSocket server = new ServerSocket(puerto);
				System.out.println("Esperando cliente...");
				DatagramSocket servidorSocket = new DatagramSocket(puerto);
//				cliente.setSoTimeout(10000);											
				InetAddress ipCliente;
				int puertoCliente;								
				byte[] bytesRecibidos = new byte[1024];
				String idAlumno;
				DatagramPacket paqueteSalida; 
				DatagramPacket paqueteEntrada;
				ObjectOutputStream oos = null;
//				ObjectInputStream ois = null;
				ByteArrayOutputStream baos = null;			
//				ByteArrayInputStream bais = null;
				
				Alumno[] alumnos= new Alumno[5];
				Curso curso1 = new Curso("1","DAM");
				Curso curso2 = new Curso("2","DAW");
				alumnos[0] = new Alumno("1", "Armando", curso1, 9);
				alumnos[1] = new Alumno("2", "Marcos", curso1, 8);
				alumnos[2] = new Alumno("3", "Estefania", curso1, 10);
				alumnos[3] = new Alumno("4", "Alejandro", curso2, 4);
				alumnos[4] = new Alumno("5", "Rebeca", curso2, 7);
				
				do {

					bytesRecibidos = new byte[1024];					
					paqueteEntrada = new DatagramPacket(bytesRecibidos,bytesRecibidos.length);					
					servidorSocket.receive(paqueteEntrada);							
//					bais = new ByteArrayInputStream(bytesRecibidos);
//					ois = new ObjectInputStream(bais);		
					idAlumno = new String(paqueteEntrada.getData()).trim();
					
					System.out.println("Recibido del cliente la idAlumno: \n " + idAlumno);										
					
					ipCliente = paqueteEntrada.getAddress();
					puertoCliente = paqueteEntrada.getPort();
				//TODO por terminar
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
class Curso{
	String id, descripcion;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	

	public Curso(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

class Alumno{
	String idAlumno, nombre;
	Curso curso;
	int nota;
	
	
	public Alumno() {
	}
	
	public Alumno(String idAlumno, String nombre, Curso curso, int nota) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
