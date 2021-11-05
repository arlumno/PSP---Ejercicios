package tesTing;

import java.io.IOException;
import java.io.InputStream;

public class prueba02 {
	public static void main(String[] args) throws IOException {
		/*
		try {
			Process p = new ProcessBuilder("CMD", "/C", "DIR").start();
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();

			int exitVal;

			exitVal = p.waitFor();
			System.out.println("Valor de salida: " + exitVal);
		} catch (Exception e) {
			// TODO: handle exception

		}
		*/
		System.out.println("estoy funcionando");
	}
}
