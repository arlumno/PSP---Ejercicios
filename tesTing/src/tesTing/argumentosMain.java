package tesTing;

public class argumentosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if( args.length <1) {
			System.exit(1);
		}
		try {
			int numero = Integer.parseInt(args[0]); //proboco una excepción si no es un número.
			if(numero < 0) {
				System.exit(3);
			}
		}catch (NumberFormatException e) {
			System.exit(2);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		System.exit(0);
	}

}
