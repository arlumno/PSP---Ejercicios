package tesTing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class devolverCadenaMaster {

	public static void main(String[] args) {
		ProcessBuilder pb = null;
		String entrada;
		try {
			pb= new ProcessBuilder("java","tesTing.devolverCadena");
			//pb= new ProcessBuilder("java","tesTing.devolverCadena","con un argumento");
			pb.directory(new File(".\\bin"));	
			Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader( p.getInputStream()));
			
			while(((entrada = br.readLine()) != null) && p.isAlive()) {
				System.out.println(entrada);
			}
			System.out.println("Exit = " + p.waitFor());
			System.out.println(" -- Fin del Programa --");

		}catch (Exception e) {
			// TODO: handle exception
		}


	}

}
