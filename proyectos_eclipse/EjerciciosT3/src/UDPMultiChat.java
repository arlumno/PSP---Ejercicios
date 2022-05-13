//package EjemplosGarceta.Ap392_ChatUDP;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class UDPMultiChat extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;

	static MulticastSocket ms = null;
	static byte[] buf = new byte[1000];
	static InetAddress grupo = null;
	static int Puerto = 12345;// Puerto multicast

	static JTextField mensaje = new JTextField();
	private JScrollPane scrollpane1;
	static JTextArea textarea1;
	JButton boton = new JButton("Enviar");
	JButton desconectar = new JButton("Salir");
	boolean repetir = true;
	String nombre;
	// ************************
	TextoChat textoChat = new TextoChat();
	byte[] bytesRecibidos = new byte[1024];
	DatagramPacket paqueteSalida;
	DatagramPacket paqueteEntrada;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	ByteArrayOutputStream baos = null;
	ByteArrayInputStream bais = null;

	// ************************
	// constructor
	public UDPMultiChat(String nom) {
		super(" VENTANA DE CHAT UDP - Nick: " + nom);
		setLayout(null);
		this.nombre = nom;
		mensaje.setBounds(10, 10, 400, 30);
		add(mensaje);
		textarea1 = new JTextArea();
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(10, 50, 400, 300);
		add(scrollpane1);
		boton.setBounds(420, 10, 100, 30);
		add(boton);
		desconectar.setBounds(420, 50, 100, 30);
		add(desconectar);

		textarea1.setEditable(false);
		boton.addActionListener(this);
		desconectar.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}// fin constructor

	// accion cuando pulsamos botones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) { // SE PULSA EL ENVIAR
			String texto = nombre + ">> " + mensaje.getText();
			textoChat.escribir(texto);
			try {
				// ENVIANDO mensaje al grupo

				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.reset();
				oos.writeObject(textoChat);
				byte[] bytesEnviados = baos.toByteArray();
				paqueteSalida = new DatagramPacket(bytesEnviados, bytesEnviados.length, grupo, Puerto);
				ms.send(paqueteSalida);
				baos.close();
				oos.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == desconectar) { // SE PULSA DESCONECTAR
			String texto = "*** Abandona el chat: " + nombre + " ***";
			textoChat.escribir(texto);
			try {
				// ENVIANDO DESPEDIDA AL GRUPO
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.reset();
				oos.writeObject(textoChat);
				byte[] bytesEnviados = baos.toByteArray();
				paqueteSalida = new DatagramPacket(bytesEnviados, bytesEnviados.length, grupo, Puerto);
				ms.send(paqueteSalida);
				baos.close();
				oos.close();
				repetir = false;
				System.out.println("Abandona el chat: " + nombre);
				System.exit(0);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}//

	// DESDE EL MÉTODO RUN SE RECIBEN LOS MENSAJES
	// Y SE PINTAN EN LA PANTALLA
	public void run() {
		// *** SINCRONIZAR ** 
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.reset();
			oos.writeObject(textoChat);
			byte[] bytesEnviados = baos.toByteArray();
			paqueteSalida = new DatagramPacket(bytesEnviados, bytesEnviados.length, grupo, Puerto);
			ms.send(paqueteSalida);
			baos.close();
			oos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// *** FIN  SINCRONIZAR ** 
		while (repetir) {
			try {

				bytesRecibidos = new byte[1024];
				paqueteEntrada = new DatagramPacket(bytesRecibidos, bytesRecibidos.length);
				ms.receive(paqueteEntrada);
				bais = new ByteArrayInputStream(bytesRecibidos);
				ois = new ObjectInputStream(bais);

				TextoChat chatEntrada = (TextoChat) ois.readObject();
				bais.close();
				ois.close();
				
				
				if(chatEntrada.isSincronizar()) {
					if(!textoChat.isSincronizar()) { //si el chat de entrada pide sincronizar, y este chat ya está sincronizado, lo enviamos.
						baos = new ByteArrayOutputStream();
						oos = new ObjectOutputStream(baos);
						oos.reset();
						oos.writeObject(textoChat);
						byte[] bytesEnviados = baos.toByteArray();
						paqueteSalida = new DatagramPacket(bytesEnviados, bytesEnviados.length, grupo, Puerto);
						ms.send(paqueteSalida);
						baos.close();
						oos.close();
					}					
				}else{
					textoChat = chatEntrada;
				}

				reCargarChat();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SocketException s) {
				System.out.println(s.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// run

	public void reCargarChat() {
		textarea1.selectAll();
		textarea1.replaceSelection("");

		System.out.println(textoChat.conversacion.toString());

		for (String linea : textoChat.getConversacion()) {
			textarea1.append(linea + "\n");
		}
	}

	public static void main(String args[]) throws IOException {
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
		// Se crea el socket multicast
		ms = new MulticastSocket(Puerto);
		grupo = InetAddress.getByName("225.0.0.1");// Grupo
		// Nos unimos al grupo
		SocketAddress sock = new InetSocketAddress(grupo, Puerto);
		ms.joinGroup(sock, NetworkInterface.getByInetAddress(grupo));// Nos unimos al grupo
		if (!nombre.trim().equals("")) {
			UDPMultiChat server = new UDPMultiChat(nombre);
			server.setBounds(0, 0, 540, 400);
			server.setVisible(true);
			new Thread(server).start();

		} else {
			System.out.println("El nombre está vacío....");
		}
	}// main
}// ..MultiChatUDP

class TextoChat implements Serializable {
	ArrayList<String> conversacion = new ArrayList<String>();
	boolean sincronizar = true;

	public void escribir(String texto) {
		conversacion.add(texto);
		setSincronizar(false);
	}

	public ArrayList<String> getConversacion() {
		return conversacion;
	}


	@Override
	public String toString() {
		return conversacion.toString();
	}

	public boolean isSincronizar() {
		return sincronizar;
	}

	public void setSincronizar(boolean sincronizar) {
		this.sincronizar = sincronizar;
	}
}