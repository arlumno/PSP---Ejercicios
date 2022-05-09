package ejerciciosT2Hilos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ejercicio_10_Productor extends Thread {
	private File file;
	char letra;	
	ejercicio_10_Cola cola;
	public ejercicio_10_Productor(ejercicio_10_Cola cola, String rutaArchivo) {
		this.cola = cola;
		this.file = new File(rutaArchivo);
	}
	
	@Override
	public void run() {
		try {
			System.out.println(file.getPath());
			FileReader fr = new FileReader(file);
			int letraInt;			
			
			while(((letraInt = fr.read()) != -1) && !cola.getEnd()) {
				letra = (char) letraInt;
				System.out.println("Productor: " + letra);
				cola.put(letra);
				//wait(); // ya lo hace e put de la cola
			}
			cola.setEnd();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
