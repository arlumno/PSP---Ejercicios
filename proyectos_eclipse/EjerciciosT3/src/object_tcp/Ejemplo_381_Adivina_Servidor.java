package object_tcp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejemplo_381_Adivina_Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(6001);
			System.out.println("Servidor iniciado...");
			int numeroMagico = (int) (1 + 25 * Math.random());
			System.out.println("Numero a adivinar: -- " + numeroMagico + " --");

			ArbitroAdivina arbitro = new ArbitroAdivina(numeroMagico);

			int idJugador = 0;

			while (true) {
				Socket cliente = new Socket();
				cliente = servidor.accept();
				idJugador++;
				PartidaThread partida = new PartidaThread(arbitro, cliente, idJugador);
				partida.start();
				System.out.println("Se ha añadido un nuevo jugador.");
				System.out.println(idJugador + ": " + cliente.getInetAddress() + "/" + cliente.getLocalPort());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class ArbitroAdivina {
	private int numeroMagico;
	private boolean gameOver = false;
	private int ganador;

	public ArbitroAdivina(int numeroMagico) {
		this.numeroMagico = numeroMagico;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	public synchronized String nuevaJugada(int idJugador, int numero) {
		String resultado = "";
		if (!isGameOver()) {
			if (numero > numeroMagico) {
				resultado = "Te has pasado de alto..";
			} else if (numero < numeroMagico) {
				resultado = "Demasiado bajo..";
			} else if (numero == numeroMagico) {
				resultado = "El jugador id: " + idJugador + "¡HA ACERTADO! el número: " + numeroMagico;
				setGameOver(true);
				setGanador(idJugador);
			}
		} else {
			System.out.println("La partida ha finalizado, el ganador es: " + ganador);
		}
		return resultado;
	}
}

class PartidaThread extends Thread {
	ArbitroAdivina arbitroAdivina;
	Socket cliente;
	int idJugador;
	ObjectInputStream entrada;
	ObjectOutputStream salida;
	int intentos = 0;

	public PartidaThread(ArbitroAdivina arbitroAdivina, Socket cliente, int idJugador) {
		super();
		this.arbitroAdivina = arbitroAdivina;
		this.cliente = cliente;
		this.idJugador = idJugador;

		try {
			salida = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new ObjectInputStream(cliente.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		System.out.println("Cliente conectado, id: " + idJugador);
		DatosPartida partida = new DatosPartida("Adivina un numero entre 1 y 25", intentos, idJugador);
		if (arbitroAdivina.isGameOver()) {
			partida.setSms("La partida ya ha finalizado, no puede continuar jugando.");
			partida.setGameOver(true);
		}
		try {
			salida.reset();
			salida.writeObject(partida);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!arbitroAdivina.isGameOver() || !(partida.getIntentos() == 5)) {
			int numero = 0;
			try {
				partida = (DatosPartida) entrada.readObject();
				numero = Integer.parseInt(partida.getSms());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String resultadoJugada = arbitroAdivina.nuevaJugada(idJugador, numero);
			if (arbitroAdivina.isGameOver()) {
				partida.setGameOver(true);
				if (idJugador == arbitroAdivina.getGanador()) {
					partida.setGanador(true);
				}
			}

			try {
				salida.reset();
				salida.writeObject(partida);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (arbitroAdivina.isGameOver()) {
			System.out.println("El juego Ha finalizado.");
			System.out.println("\t ==> Desconectado: " + idJugador);
		}
		try {
			entrada.close();
			salida.close();
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class DatosPartida implements Serializable {
	String sms;
	int intentos;
	int idJugador;
	boolean ganador = false;
	boolean gameOver = false;

	public DatosPartida(String sms, int intentos, int idJugador) {
		super();
		this.sms = sms;
		this.intentos = intentos;
		this.idJugador = idJugador;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public DatosPartida() {

	}
}