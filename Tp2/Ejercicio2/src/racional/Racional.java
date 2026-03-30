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
	
	//Sirve para consultar el valor desde otra clase 
	public int getNumerador() {
		return numerador;
	}
	
	//Sirve para modificar el valor, pero con control(es un filtor de seguridad!)
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	//Sirve para consultar el valor desde otra clase 
	public int getDenominador() {
		return denominador;
	}

	//Sirve para modificar el valor, pero con control(es un filtor de seguridad!)
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	//Sirve para imprimir el resultado de esta forma a / b
	public String toString() {
		return numerador +"/"+ denominador;
	}

	//Metodo que calcula la suma
	public Racional sumar(Racional otro) {
		int n;
		int d;
		n = numerador * otro.denominador + denominador * otro.numerador;
		d= denominador * otro.denominador;
		return new Racional(n,d);
	}
	
	//Metodo que calcula la resta
	public Racional restar(Racional otro) {
		int n, d;
		n = numerador * otro.denominador - denominador * otro.numerador;
		d = denominador * otro.denominador;
		return new Racional(n,d);
	}

	//Metodo que calcula el producto
	public Racional producto(Racional otro) {
		int n, d;
		n = numerador * otro.numerador;
		d = denominador * otro.denominador;
		return new Racional(n,d);
	}
	
	//Metodo que calcula la division
	public Racional division(Racional otro) {
		int n, d;
		n = numerador * otro.denominador;
		d = denominador * otro.numerador;
		return new Racional(n,d);
	}
	
	//Metodo que calcula la pontencia
	public Racional potencia(int exponente) {
		int n=1, d=1;
		
		//Calcula la potencia
		for(int i = 0; i < exponente ; i++) {
			n = n * this.numerador;
			d = d *this.denominador;
		}
		
		return new Racional(n, d);
	}
}

