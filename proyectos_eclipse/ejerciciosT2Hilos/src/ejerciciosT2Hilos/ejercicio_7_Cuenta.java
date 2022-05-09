package ejerciciosT2Hilos;

public class ejercicio_7_Cuenta {
	private double saldo;
	private double saldoMaximo;
	
	public ejercicio_7_Cuenta(double saldo, double saldoMaximo) {
		this.saldo = saldo;
		this.saldoMaximo = saldoMaximo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public synchronized String ingresar(double ingreso) {
	//public  String ingresar(double ingreso) {
		String resultado;
		if(ingreso < 0) {
			resultado = "Error el ingreso no puede ser negativo";
		}else if((ingreso + saldo) > saldoMaximo) {
			resultado = "Error el ingreso supera el límite de saldo";
		}else {
			saldo += ingreso;
			resultado = "Se ha ingresado " + ingreso + "€ -- Saldo final " + getSaldo() + "€";
		}
		return resultado;
	}
	
	public synchronized String retirar(double retirar) {
	//public  String retirar(double retirar) {
		String resultado;
		if(retirar < 0) {
			resultado = "Error no puede retirar cifras negativas";
		}else if(saldo < retirar) {
			resultado = "Error, No puede retirar mas cantidad que el saldo actual";
		}else{
			saldo -= retirar;
			resultado = "Se ha retirado " + retirar + "€ -- Saldo final " + getSaldo() + "€";			
		}
		return resultado;
	}
}
