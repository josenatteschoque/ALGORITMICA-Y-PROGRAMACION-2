package racional;

// Clase Racional
public class Racional {

	// Atributos
	private int numerador;
	private int denominador;

	// Constructor
	public Racional(int numerador, int denominador) {
		this.numerador = numerador;

		if (denominador == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.denominador = denominador;
	}

	// Getters: acceder a los valores de los atributos
	// Setters: modificar los valores de los atributos
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
		if (denominador == 0)
			throw new IllegalArgumentException("El denominador debe ser distinto de cero");
		this.denominador = denominador;
	}

	// Métodos
	public Racional sumar(Racional b) {
		int n = (numerador * b.denominador) + (b.numerador * denominador);
		int d = denominador * b.denominador;
		return new Racional(n, d);
	}

	// Implementar...
	public Racional restar(Racional b) {
		return new Racional(1, 1);
	}

	// Implementar...
	public Racional multiplicar(Racional b) {
		return new Racional(1, 1);
	}

	// Implementar...
	public Racional dividir(Racional b) {
		return new Racional(1, 1);
	}

	// Implementar...
	// (a/b)^n = a^n/b^n
	// (a/b)^-n = (b/a)^n
	public static Racional potencia(Racional base, int exponente) {
		return new Racional(1, 1);
	}

	// Método estático
	public static Racional simplificar(Racional a) {
		int x = mcd(Math.abs(a.numerador), Math.abs(a.denominador));
		int n = a.numerador / x;
		int d = a.denominador / x;
		return new Racional(n, d);
	}

	// toString: mostrar un objeto
	public String toString() {
		return (numerador + "/" + denominador);
	}

	// equals: verificar cuando dos objetos son iguales
	public boolean equals(Object o) {
		Racional r1 = simplificar(this);
		Racional r2 = simplificar((Racional) o);
		return ((r1.numerador == r2.numerador) && (r1.denominador == r2.denominador));
	}

	// Método privado
	private static int mcd(int m, int n) {
		int t;
		while (m > 0) {
			t = m;
			m = n % m;
			n = t;
		}
		return n;
	}

}