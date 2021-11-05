package tesTing;

import java.io.File;
import java.util.Scanner;

public class argumentosMainMaster {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String entrada = "";
		ProcessBuilder pb = null;
		//ProcessBuilder pb= new ProcessBuilder("java","tesTing.argumentosMain");
		
		while(!entrada.equals("salir")) {
			System.out.println("Lanzando proceso, indica el parametro a introducir. ('salir' para finalizar)");
			entrada = lector.nextLine();
			
			if(entrada == null || entrada == "") {
				pb= new ProcessBuilder("java","tesTing.argumentosMain");
				
			}else {
				pb= new ProcessBuilder("java","tesTing.argumentosMain",entrada);
			}		
			
			pb.directory(new File(".\\bin"));	
		
			try {
				
				Process p = pb.start();
				p.waitFor();
				System.out.println(p.waitFor());
				
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
		System.out.println(" -- Fin del programa -- ");

	}

}
