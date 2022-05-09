package ejerciciosT2Hilos;

public class ejercicio_7_Main {

	public static void main(String[] args) {
		ejercicio_7_Cuenta cuenta = new ejercicio_7_Cuenta(300,1000);
		ejercicio_7_Persona per1 = new ejercicio_7_Persona(cuenta,"María");
		ejercicio_7_Persona per2 = new ejercicio_7_Persona(cuenta,"Roberto");
		ejercicio_7_Persona per3 = new ejercicio_7_Persona(cuenta,"Juan");
		ejercicio_7_Persona per4 = new ejercicio_7_Persona(cuenta,"Ana");
		
		per1.start();
		per2.start();
		per3.start();
		per4.start();

	}

}
