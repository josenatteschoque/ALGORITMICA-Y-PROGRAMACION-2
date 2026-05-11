package tipo_de_progressiones;

import base_progression.Progression;

public class GeometricProgression extends Progression{

	protected long base;
	
	//Constructor
	public GeometricProgression() { this(2, 1);}
	
	//Constructor
	public GeometricProgression(long b, long start) {
		super(start);
		base = b;
	}
	
	protected void advance() {
		current *= base;
	}
	
	//Metodo toString
	public String toString() {
		String resultado=" ";
		System.out.print("La progresion geometrica es:");
		for (int i = 0; i<5;i++) {
			resultado += nextValue()+" ";
		}
		
		return resultado;
	}
	
}