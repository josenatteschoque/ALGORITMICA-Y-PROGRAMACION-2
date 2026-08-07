package figuras;

import java.util.Objects;

public class Rectangulo extends Figura{
	private int ancho;
	private int alto;
	
	//Constructor
	public Rectangulo(Punto origen, int ancho, int alto) {
		super(origen);
		this.ancho = ancho;
		this.alto = alto;
	}

	//Getters y Setters
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	
	//Hashcode y Equals
	@Override
	public int hashCode() {
		return Objects.hash(alto, ancho);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return alto == other.alto && ancho == other.ancho;
	}

	//Metodo que calcula el Area de un rectangulo
	@Override
	public double area() {
		//Área = ancho × alto
		double Area = this.ancho * this.alto;
		return Area;
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Rectangulo [ancho=" + ancho + ", alto=" + alto + "]";
	}
	
	
	
}
