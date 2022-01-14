package tesTing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class palindromoMaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("java","tesTing.palindromoSlave");
		File file = new File(".\\bin");	
		String linea ="ejemplo";
		String lineaP;
		pb.directory(file);
		pb.redirectOutput(new File(".\\src\\tesTing\\palindromoOut.txt"));
		pb.redirectInput(new File(".\\src\\tesTing\\palindromoIn.txt"));
		pb.redirectError(new File(".\\src\\tesTing\\palindromoErrors.txt"));
		
		try {
			Process p = pb.start();					
			InputStreamReader lector = new InputStreamReader(System.in);	
			BufferedReader br = new BufferedReader(lector);
			
	//		OutputStream os = p.getOutputStream();
			//BufferedWriter bw = new BufferedWriter(osw); 
			PrintStream ps = new PrintStream(p.getOutputStream());
			// InputStreamReader isr = new InputStreamReader(p.getInputStream());	
			// BufferedReader brp = new BufferedReader(isr);
			BufferedReader brp = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
			System.out.println("Escribe algo:");
			
			while((linea = br.readLine()) != null) {
				//bw.write(linea);
				//bw.newLine();
				//bw.flush();
			//	System.out.println(linea);
		//		os.write((linea + "\n").getBytes());
			//	os.flush();
				ps.println(linea);
				ps.flush();
				lineaP = brp.readLine();
				//while((lineaP = brp.readLine()) != null) {
				//	lineaP = brp.readLine();
				//}
			
			}			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
			
		System.out.println("fin");
	}

}
