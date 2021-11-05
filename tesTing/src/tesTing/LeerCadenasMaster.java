package tesTing;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
			OutputStreamWriter isr = new OutputStreamWriter(p.getOutputStream());
			while ((resultado = lector.next()) != null) {
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
