package base_progression;
import tipo_de_progressiones.ArithmeticProgression;
import tipo_de_progressiones.FibonacciProgression;
import tipo_de_progressiones.GeometricProgression;
public class polimorfico {
	public static void main(String[] args) {

		//Declaro un arreglo polimorfico
		Progression[] progresiones = new Progression[3];
		progresiones[0] = new ArithmeticProgression(2,1);
		progresiones[1] = new FibonacciProgression(0,1);
		progresiones[2] = new GeometricProgression(2,1);

		for(int i = 0; i< progresiones.length;i++) {
				System.out.println(progresiones[i]);
			}
		
	}

}