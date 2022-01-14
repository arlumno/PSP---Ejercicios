package tesTing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class palindromoSlave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String linea;
		Boolean palindromo;
		try {
			while((linea = br.readLine()) != null) {
				if(linea.length() == 0) {
					System.out.println("La cadena est� vac�a");				
				} else {
					palindromo = true;
					int size = linea.length();
					for(int i = 0; i <  size && palindromo; i++) {
						if(linea.charAt(i) != linea.charAt(size-1-i)) {							
							palindromo = false;
						}
					}
					if(palindromo) {
						System.out.println(linea + " ES pal�ndromo ");
					}else {
						System.out.println(linea + " NO es pal�ndromo ");
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
