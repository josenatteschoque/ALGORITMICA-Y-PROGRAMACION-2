package tipo_de_progressiones;

import base_progression.Progression;

public class FibonacciProgression extends Progression{

	protected long prev;
	
	//Constructor
	public FibonacciProgression() { this(0,1); }
	
	//Constructor
	public FibonacciProgression(long first,long second) {
		super(first);
		prev = second - first;
	}
	
	protected void advance() {
		long temp = prev;
		prev = current;
		current += temp;
	}
	
	//Metodo toString
	public String toString() {
		String resultado=" ";
		System.out.print("La progresion fibonacci es:");
		for (int i = 0; i<5;i++) {
			resultado += nextValue()+" ";
		}
		
		return resultado;
	}
	
}