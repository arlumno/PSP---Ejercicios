package ejerciciosT2Hilos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ejercicio_10_Productor extends Thread {
	private File file;
	char letra;
	boolean ready = false;
	
	public ejercicio_10_Productor(String rutaArchivo) {
		this.file = new File(rutaArchivo);
	}
	
	@Override
	public void run() {
		try {
			FileReader fr = new FileReader(file);
			int letraInt;			
			
			while((letraInt = fr.read()) != -1) {
				letra = (char) letraInt;
				ready =  true;
				wait();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
