package tesTing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BloqMayus {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String linea;		
		try {						
			while((linea = br.readLine()) != null) {													
				System.out.println(linea.toUpperCase());											
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}

}
