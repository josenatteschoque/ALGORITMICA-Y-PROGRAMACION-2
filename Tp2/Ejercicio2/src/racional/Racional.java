package racional;

public class Racional {
	private int numerador;
	private int denominador;
	
	//Constructor
	public Racional(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public int getNumerador() {
		return numerador;
	}
	
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	
	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}


	public String toString() {
		return numerador +"/"+ denominador;
	}

	
	public Racional sumar(Racional otro) {
		int n;
		int d;
		n = numerador * otro.denominador + denominador * otro.numerador;
		d= denominador * otro.denominador;
		return new Racional(n,d);
	}
	
	
	public Racional restar(Racional otro) {
		int n, d;
		n = numerador * otro.denominador - denominador * otro.numerador;
		d = denominador * otro.denominador;
		return new Racional(n,d);
	}

	public Racional producto(Racional otro) {
		int n, d;
		n = numerador * otro.numerador;
		d = denominador * otro.denominador;
		return new Racional(n,d);
	}
	
	public Racional division(Racional otro) {
		int n, d;
		n = numerador * otro.denominador;
		d = denominador * otro.numerador;
		return new Racional(n,d);
	}
}

