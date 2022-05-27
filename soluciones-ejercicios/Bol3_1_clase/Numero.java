package Ejs_boletines.Bol3_1_clase;

import java.io.Serializable;

public class Numero implements Serializable{
	int numero, cubo, cuadrado;
	
	public Numero() {}
	
	public Numero(int numero, int cubo, int cuadrado) {
		this.numero = numero;
		this.cubo = cubo;
		this.cuadrado = cuadrado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCubo() {
		return cubo;
	}

	public void setCubo(int cubo) {
		this.cubo = cubo;
	}

	public int getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(int cuadrado) {
		this.cuadrado = cuadrado;
	}
}
