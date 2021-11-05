package tesTing;

public class LeerNombre {	
	public static void main(String[] args) {
		if(args.length > 0) {
			System.out.println("El nombre es " +  args[0]);
			System.exit(1);
		}else{
			System.exit(-1);
		}
		
	}
}
