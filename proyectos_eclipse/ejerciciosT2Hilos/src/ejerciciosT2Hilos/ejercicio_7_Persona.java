package ejerciciosT2Hilos;

import java.util.Random;

public class ejercicio_7_Persona extends Thread {
	ejercicio_7_Cuenta cuenta;
	String nombre;
	
	public ejercicio_7_Persona(ejercicio_7_Cuenta cuenta, String nombre) {
		this.cuenta = cuenta;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		int rdm;
		try {
		
			sleep(100);
			
			rdm = (int) (Math.random()*500+1);
			System.out.println("["+ nombre +"] "+cuenta.ingresar(rdm));
			sleep(300);
			
			rdm = (int) (Math.random()*500+1);
			System.out.println("["+ nombre +"] "+cuenta.retirar(rdm));
			sleep(500);
			
			rdm = (int) (Math.random()*500+1);
			System.out.println("["+ nombre +"] "+cuenta.ingresar(rdm));
			sleep(100);
			
			rdm = (int) (Math.random()*500+1);
			System.out.println("["+ nombre +"] "+cuenta.retirar(rdm));
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
