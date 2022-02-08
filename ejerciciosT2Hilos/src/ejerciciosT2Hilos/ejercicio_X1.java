package ejerciciosT2Hilos;

class ejercicio_X1 {

	public static void main(String[] args) {
		Contador contador = new Contador();
		ContadorHilo h1 = new ContadorHilo(contador, "hilo 1");
		ContadorHilo h2 = new ContadorHilo(contador, "hilo 2");
		ContadorHilo h3 = new ContadorHilo(contador, "hilo 3");
		ContadorHilo h4 = new ContadorHilo(contador, "hilo 4");
		h1.start();
		h2.start();
		h3.start();
		h4.start();
	}

}

class Contador {
	int numero;
	public Contador() {
		numero = 0;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}

class ContadorHilo extends Thread{
	Contador contador;
	String nombre;
	public ContadorHilo(Contador contador, String nombre) {
		this.contador = contador;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		int sleep = (int) ((10* Math.random()) + 1)*100;
		int resultado;
		for(int i = 0; i <3; i ++) {
			resultado = contador.getNumero()+1;
			contador.setNumero(resultado);
			System.out.println("[" + nombre +"]" + resultado);
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
