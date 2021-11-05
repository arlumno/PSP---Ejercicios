package tesTing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EjemploLectura {	
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		//InputStreamReader entrada = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(entrada);
		int numero1;
		int numero2;

		try {
			System.out.println("Introduce el numero 1");
			//numero1 =  Integer.parseInt(br.readLine());
			numero1 =  Integer.parseInt(lector.next());
			System.out.println(numero1);
			System.out.println("Introduce el numero 2");
			//numero2 = Integer.parseInt(br.readLine());
			numero2 =  Integer.parseInt(lector.next());
			System.out.println(numero2);
			System.out.println("Total: "+ (numero1+numero2));
			
			//entrada.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}
