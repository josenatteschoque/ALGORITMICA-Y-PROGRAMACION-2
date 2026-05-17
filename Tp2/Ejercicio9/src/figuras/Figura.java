/*9. Crear la clase Figura y las subclases FiguraBidimensional, FiguraTridimensional, Circulo,
 *  Rectangulo, Esfera y PrimaRectangular en la jerarquía que corresponda. 
 *  Utilizar objetos de la clase Punto para indicar sus coordenadas. 
 *  Para todas las figuras agregar métodos para calcular su perímetro, área y volumen.
 *   Escribir un programa que cree instancias de objetos para cada clase y llame a los métodos 
 *   implementados.*/
package figuras;

public class Figura {
	protected double x;
	protected double y;
	protected double z;
	
	//Constructor
	public Figura(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Figura [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	
}
