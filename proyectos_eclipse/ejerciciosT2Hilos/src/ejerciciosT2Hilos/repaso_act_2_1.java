package ejerciciosT2Hilos;


class repaso_act_2_1 {

	public static void main(String[] args) {
		SendText sT = new SendText();
		TicTac t1 = new TicTac("TIC", sT);
		TicTac t2 = new TicTac("TAC", sT);
		TicTac t3 = new TicTac("TOC", sT);
		TicTac t4 = new TicTac("", sT);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		Thread.currentThread().setName("Manito");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.activeCount());
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			System.out.println("--- FIN DEL PROGRAMA ---");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class TicTac extends Thread {
	private String text;
	public SendText sT;
	private int turno;

	public TicTac(String text, SendText sT) {
		this.text = text;
		this.sT = sT;
		this.turno = sT.asignarTurno();
//		System.out.println("arrancado con turno:" + turno);
	}

	@Override
	public void run() {
		while (sT.continuar) {
			if (turno == sT.getTurnoActual()) {
				sT.imprimir(text, turno);						
			}
		}

	}
}

class SendText {
	public boolean continuar = true;
	int ciclos = 0;
	int maxCiclos = 30;
	int delay = 400;
	private int turnos = 0;
	private int turnoActual;

	public SendText() {		
		turnoActual = 1;
	}

	public synchronized void imprimir(String text, int turno) {

		while (ciclos <= maxCiclos) {
			while (turno != turnoActual) {				
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println(text);
			ciclos++;
			avanzarTurnoActual();			
			
			
			try {
				Thread.sleep(delay);
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		continuar = false;

		notifyAll();
	}


	public synchronized int getTurnoActual() {
		return turnoActual;
	}
	
	public void avanzarTurnoActual() {
		if (turnoActual == turnos) {
			turnoActual = 1;
		}else {
			turnoActual++;
		}		
	}
	
	public synchronized int asignarTurno() {
		turnos++;
		return turnos;
	}
}