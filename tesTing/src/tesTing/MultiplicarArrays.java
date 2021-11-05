package tesTing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MultiplicarArrays {
	public static void main(String[] args) {
		String lineaEntrada;
		String lineaSalida;
		Scanner lector = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);		
		 
		
		int[] listaNumeros1 = {3,2,5,6,7,9,2,3,7,1};
		int[] listaNumeros2 = {1,2,3,5,4,6,5,4,8,8};
		int[] listaResultados = new int[10];
		
		try {
			ProcessBuilder pb = new ProcessBuilder("java", "tesTing.Multiplicador").directory(new File(".\\bin"));
					
			Process p1 =  pb.start();					
			BufferedReader br1 = new BufferedReader(new InputStreamReader( p1.getInputStream()));
			PrintStream ps1 = new PrintStream(p1.getOutputStream());						
		
			Process p2 = pb.start();
			BufferedReader br2 = new BufferedReader(new InputStreamReader( p2.getInputStream()));
			PrintStream ps2 = new PrintStream(p2.getOutputStream());
			
			// proceso 1
			for(int i = 0; i < 5; i++) {				
				ps1.println(listaNumeros1[i]);
				ps1.flush();
				ps1.println(listaNumeros2[i]);
				ps1.flush();				
				lineaEntrada = br1.readLine();
				listaResultados[i] = Integer.parseInt(lineaEntrada);
;				System.out.println(listaNumeros1[i] + " x " + listaNumeros2[i] + " = " + lineaEntrada);
			}
			
			System.out.println("-- Cambio de proceso --");			
			
			for(int i = 5; i < 10; i++) {				
				ps2.println(listaNumeros1[i]);
				ps2.flush();
				ps2.println(listaNumeros2[i]);
				ps2.flush();				
				lineaEntrada = br2.readLine();
				listaResultados[i] = Integer.parseInt(lineaEntrada);
				System.out.println(listaNumeros1[i] + " x " + listaNumeros2[i] + " = " + lineaEntrada);
			}
			
			System.out.println(listaResultados.toString());
			p1.destroy();
			p2.destroy();
			
		}catch (Exception e) {
			System.out.println("Error: "  + e.toString() );
		}
		
		lector.close();		
		System.out.println("Fin del programa");
	}
}
