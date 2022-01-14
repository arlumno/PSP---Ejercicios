package tesTing;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeerCadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String resultado = "";
			try {				
				while((resultado = br.readLine()) != null && !resultado.equals("*")) {
					//esto no hace nada. lo importante es la condición
				}
				System.exit(0);
			}catch (Exception e) {
				// TODO: handle exception
			}
		
	}

}
