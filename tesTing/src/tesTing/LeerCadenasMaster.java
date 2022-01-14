package tesTing;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class LeerCadenasMaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lector = new Scanner(System.in);
		ProcessBuilder pb = new ProcessBuilder("java","tesTing.LeerCadenas");
		pb.directory(new File(".\\bin"));
		String resultado = "";
		try {
			Process p = pb.start();
			PrintStream ps= new PrintStream(p.getOutputStream());
			System.out.println(" -- Inicio del Programa -- ");
			
			while (p.isAlive()) {
				System.out.println("Escribe algo:");
				if((resultado = lector.next()) != null ) {
					ps.println(resultado);
					ps.flush();
					Thread.sleep(100); 
				}
			}
			System.out.println(" -- Fin del Programa -- ");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
