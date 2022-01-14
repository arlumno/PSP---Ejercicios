package tesTing;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class sumarRangoMaster {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java","tesTing.sumarRangoSlave","3","1");
		pb.directory(new File(".\\bin"));
		try {
			Process p = pb.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println(br.readLine());
			//System.out.println(p.waitFor());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
