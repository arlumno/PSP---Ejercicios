package tesTing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Multiplicador {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String numero1;
		String numero2;
		int resultado;
		try {						
			while((numero1 = br.readLine()) != null && (numero2 = br.readLine()) != null) {							
					resultado = Integer.parseInt(numero1) * Integer.parseInt(numero2); 					
					System.out.println(resultado);
					numero2 = null;				
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}

	}

}
