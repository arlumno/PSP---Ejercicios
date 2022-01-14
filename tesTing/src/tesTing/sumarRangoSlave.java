package tesTing;

public class sumarRangoSlave {

	public static void main(String[] args) throws Exception{		
		if(args.length < 2) {
			throw new Exception("argumentos insuficientes");
		}
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int resultado = a + b;

		for(int i = a+1; i < b; i++) {
			resultado += i;			
		}
		for(int i = b+1; i < a; i++) {
			resultado += i;			
		}
		System.out.println(resultado);
		System.exit(resultado);
		
	}

}
