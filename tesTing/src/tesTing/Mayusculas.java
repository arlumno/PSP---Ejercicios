package tesTing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Mayusculas {

	public static void main(String[] args) {
		String lineaEntrada;
		String lineaSalida;
		Scanner lector = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);		
		ProcessBuilder pb = new ProcessBuilder("java", "tesTing.BloqMayus"); 
		pb.directory(new File(".\\bin"));	
		
		try {
			Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader( p.getInputStream()));
			PrintStream ps = new PrintStream(p.getOutputStream());
			
			while((lineaSalida = lector.nextLine()) != null) {
									
				ps.println(lineaSalida);
				ps.flush();
				
				lineaEntrada = br.readLine();		
				System.out.println(lineaEntrada);			
			}
			
		}catch (Exception e) {
			System.out.println("Error: "  + e.toString() );
		}
		lector.close();
		
		System.out.println("Fin del programa");
	}

}
