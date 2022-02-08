package ejerciciosT2Hilos;

class Ejercicio_11 {
	public static void main(String[] args) {
		Arbitro arbitro = new Arbitro(3);
		Jugador player1 = new Jugador("Player1", arbitro);
		Jugador player2 = new Jugador("Player2", arbitro);
		Jugador player3 = new Jugador("Player3", arbitro);
		player1.start();
		player2.start();
		player3.start();
	}
	
}

class Jugador extends Thread {
	String nombre;
	Arbitro arbitro;
	int turno;
	public Jugador(String nombre, Arbitro arbitro) {
		 this.nombre = nombre;
		 this.arbitro = arbitro;
		 this.turno = arbitro.siguienteTurno();
	 }
	 
	 @Override
	 public void run() {
		 while(!arbitro.isFinJuego()) {				 
			 if(arbitro.getTurno() != turno) {
				 try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }else{
				 arbitro.comprobarJugada(generarNumero(),nombre, turno);			
			 }
		 }
	 }
	 
	 public int generarNumero() {
		 return (int) ( 10* Math.random());
	 }
	 
	 public String getNombre() {
		return nombre;
	 }
}




class Arbitro {
	int numeroJugadores;
	int turno;
	int numeroObjetivo;
	boolean finJuego = false;
	
	public Arbitro(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
		turno = 1;
		numeroObjetivo = (int) ( 10* Math.random());
		System.out.println("Numero de jugadores: " + numeroJugadores);
		System.out.println("Numero a adivinar: " + numeroObjetivo);
	}
	
	public int siguienteTurno() {
		int aux = turno;
		turno++;
		if(turno > numeroJugadores) {
			turno = 1;
		}
		return aux;
	}
	
	public int getTurno() {
		return turno;
	}
	
	public boolean isFinJuego() {
		return finJuego;
	}
	
	public synchronized void comprobarJugada(int numero, String nombre, int turnoJugador){	
		if(turnoJugador == turno) {				
			if(numero == numeroObjetivo) {
				finJuego = true;
				System.out.println("[" + nombre + "]: ¡¡HA GANADO!!: " + numero);
			}else{
				System.out.println("[" + nombre + "]: Ha fallado: " + numero);
				siguienteTurno();
			}
			notify();
		}		
	}
}