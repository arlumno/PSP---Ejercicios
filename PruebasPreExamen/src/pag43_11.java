import java.util.Random;

class pag43_11 {

	public static void main(String[] args) {
		Arbitro arbitro = new Arbitro(3);
		Jugador j1 = new Jugador(1, arbitro);
		Jugador j2 = new Jugador(2, arbitro);
		Jugador j3 = new Jugador(3, arbitro);
		j1.start();
		j2.start();
		j3.start();
		try {
			j1.join();	j2.join();	j3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Partida finalizada");
	}

}

class Arbitro {
	int numeroMagico;
	int turnoActual = 1;
	boolean gameOver;
	int numJugadores;

	public Arbitro(int numJugadores) {
		this.numJugadores = numJugadores;
		this.gameOver = false;
		numeroMagico =  (int) (Math.random() * 10 + 1);
		System.out.println("El numero mágico es: " + numeroMagico);
	}

	public int getTurnoActual() {
		return turnoActual;
	}

	public void nextTurn() {
		if (turnoActual == numJugadores) {
			turnoActual = 1;
		} else {
			turnoActual++;
		}
	}

	public synchronized boolean isGameOver() {
		return gameOver;
	}

	public void endGame() {
		gameOver = true;
	}
	
	public synchronized void validarJugada(int jugador, int jugada) {
		while (jugador != turnoActual && !gameOver) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!gameOver) {
			System.out.println("[Jugador " + jugador + "] prueba con el número " + jugada);
			if (jugada == numeroMagico) {
				endGame();
				System.out.println("¡¡El jugador " + jugador + " HA GANADO!");
			}else {
				System.out.println("El jugador " + jugador + " no ha hacertado");
			}
		}
		nextTurn();
		notifyAll();
	}

}


class Jugador extends Thread{	
	int numeroJugador;
	Arbitro arbitro;
	
	public Jugador(int numeroJugador, Arbitro arbitro) {
		this.numeroJugador = numeroJugador;
		this.arbitro = arbitro;
	}
	
	@Override
	public void run() {	
		System.out.println("Jugador " + numeroJugador + " se une a la partida.");
		while(!arbitro.gameOver) {
			arbitro.validarJugada(numeroJugador, (int) (Math.random() * 10 + 1));
		}
	}
	
	
}