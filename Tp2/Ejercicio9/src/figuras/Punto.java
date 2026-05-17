package figuras;

public class Punto {
	private double x, y ,z;
	
	//Constructor para figuras bidimensionales
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	//Constructor para figuras tridimensionales
	public Punto(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	//Metodo toString
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	
}
