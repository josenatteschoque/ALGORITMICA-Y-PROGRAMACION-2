package figuras;

import java.util.Objects;

public class Circulo extends Figura{
	private int radio;

	//Constructor
	public Circulo(Punto origen, int radio) {
		super(origen);
		this.radio = radio;
	}

	//Getters y Settters
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	//Hashcode y Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(radio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		return radio == other.radio;
	}

	//Metodo que calcula el Area de un circulo
	@Override
	public double area() {
		//Área = π × radio²
		double Area = Math.PI * this.radio * this.radio;
		return Area;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}
}
