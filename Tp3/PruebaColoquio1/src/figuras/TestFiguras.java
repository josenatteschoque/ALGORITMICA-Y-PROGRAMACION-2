/*2. Realizar un programa que carga un arreglo con círculos y rectángulos en distinto orden. 
 * Recorrer el arreglo y mostrar el nombre de la figura y el valor de su área.
Al finalizar mostrar la suma de todas las áreas de las figuras del arreglo.*/
package figuras;

public class TestFiguras {
	public static void main(String[] args) {
		
		//Creo los Rectangulos
		Rectangulo r1 = new Rectangulo(new Punto(1, 2), 10, 12);
		Rectangulo r2 = new Rectangulo(new Punto(1,1), 14, 2);

		//Creo los Circulos
		Circulo c1 = new Circulo(new Punto(0, 0) , 5);
		Circulo c2 = new Circulo(new Punto(2,1), 2);
		
		//Creo un Arreglo polimorfico
		Figura[] figuras = {r1, r2, c1, c2};

		//
		double sumaTotal = 0;

		//Recorro el Arreglo
		for(int i = 0; i < figuras.length; i++) {
			double AreaActual = figuras[i].area();
			System.out.println("Nombre de la figura: "+figuras[i].getClass().getSimpleName()+" Area:"+	AreaActual);
			sumaTotal += AreaActual; 	//Acumula la suma de todas las Areas
		}
		
		System.out.println("Suma total de las Areas: "+sumaTotal);
	}
}
