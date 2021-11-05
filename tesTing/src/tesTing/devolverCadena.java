package tesTing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class devolverCadena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		if( args.length <1) {
			System.out.println(" ¡¡ No hay argumentos !!");
			System.exit(1);
		}else {
			for(int i = 0; i<5; i++) {
				System.out.println(args[0]);
			}
		}
		
		
		

	}

}
