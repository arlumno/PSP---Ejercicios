package tesTing;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class GeneradorAleatorios {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String linea;		
		try {
						
			while(true) {		
				linea = br.readLine();
				if(linea.equals("fin")) {
					System.out.println("proceso: Cerrando el programa");		
					System.exit(0);
				}else{
					System.out.println("proceso: " + linea + " --> N� Aleatorio: " + (int) Math.floor(Math.random()*11));							
				}
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	
}
