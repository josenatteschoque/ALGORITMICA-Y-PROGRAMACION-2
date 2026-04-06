package textprogression;

import progressiones.base.*;
import progressiones.tipos.*;

public class TextProgression {
	public static void main(String[] args) {
		Progression[] progressiones = new Progression[3];
		progressiones[0] = new ArithmeticProgression(5,0);
		progressiones[1] = new GeometricProgression(2,1);
		progressiones[2] = new FibonacciProgression(0,1);
		
		for(Progression p : progressiones) {
			System.out.print(p.getClass().getSimpleName()+ " :");
			p.printProgression(10);
		}
	}
}
