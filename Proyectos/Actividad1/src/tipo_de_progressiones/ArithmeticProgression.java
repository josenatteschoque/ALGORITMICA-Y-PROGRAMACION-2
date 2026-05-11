package tipo_de_progressiones;

import base_progression.Progression;

public class ArithmeticProgression extends Progression{
	
	protected long increment;
	
	//Constructor
	public ArithmeticProgression() { this(0);}
	
	//Constructor
	public ArithmeticProgression(long stepsize) { this(stepsize, 0);}
	
	//Constructor
	public ArithmeticProgression(long stepsize, long start) {
		super(start);
		increment = stepsize;
	}
	
	protected void advance() {
		current += increment;
	}
	
	//Metodo toString
	public String toString() {
		String resultado=" ";
		System.out.print("La progresion aritmetica es:");
		for (int i = 0; i<5;i++) {
			resultado += nextValue()+" ";
		}
		
		return resultado;
	}
}