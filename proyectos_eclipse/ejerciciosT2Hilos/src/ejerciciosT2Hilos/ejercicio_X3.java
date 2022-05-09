package ejerciciosT2Hilos;

class ejercicio_X3 {

	public static void main(String[] args) {
		Bienvenida hi =  new Bienvenida(3);
		Alumno a1 = new Alumno(hi,"Ana");
		Alumno a2 = new Alumno(hi,"Juan");
		Alumno a3 = new Alumno(hi,"Lucía");
		Profesor prof = new Profesor(hi,"Nuria");
		a1.start();
		a2.start();
		a3.start();
		
//		while(!(a1.getState() == Thread.State.WAITING && a2.getState() == Thread.State.WAITING && a3.getState() == Thread.State.WAITING)){
//			//esperando....
//		}
		
		prof.start();
		try {
			a1.join();
			a2.join();
			a3.join();
			prof.join();
			System.out.println("La clase comienza");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class Alumno extends Thread{
	private String nombre;
	private Bienvenida hi;
	public Alumno(Bienvenida hi ,String nombre) {
		this.hi = hi;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		System.out.println(nombre + " ha llegado a clase");
		hi.alumnoEsperanProfesor();
		System.out.println(nombre + " saluda al profesor");
	}
}

class Profesor extends Thread{
	private String nombre;
	private Bienvenida hi;
	public Profesor(Bienvenida hi, String nombre) {
		this.hi = hi;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		System.out.println("El Teacher " + nombre + " ha llegado a clase");
		
//		while(hi.getnAlumnos() > 0) {
//			//esperando
//		}
		
		hi.llegaProfesor();
		System.out.println("El Teacher "+nombre +" saluda a los alumnos");
	}
}

class Bienvenida{
	private int nAlumnos = 3;
	private boolean profesor = false;
	public Bienvenida(int nAlumnos) {
		this.nAlumnos = nAlumnos;
	}
	public synchronized void alumnoEsperanProfesor() {
		try {
			nAlumnos--;
			if(!claseLista()) {
				wait();				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void llegaProfesor() {	
		try {
			profesor = true;
			if(!claseLista()) {
				wait();				
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		notifyAll();
	}
	public int getnAlumnos() {
		return nAlumnos;
	}
	
	public boolean claseLista() {
		if(nAlumnos == 0 && profesor) {
			notifyAll();
			return true;
		}
		return false;
	}
}