package hospital;

import java.util.Objects;

public abstract class Personal {
	private int legajo;
	private String nombre;
	private static double basico = 10000;
	private int antiguedad;
	
	
	//Constructor
	public Personal(int legajo, String nombre, int antiguedad) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
	}

	//Getters y Setters
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static double getBasico() {
		return basico;
	}

	public static void setBasico(double basico) {
		Personal.basico = basico;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	//Equeals y hashcode
	@Override
	public int hashCode() {
		return Objects.hash(antiguedad, legajo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return antiguedad == other.antiguedad && legajo == other.legajo && Objects.equals(nombre, other.nombre);
	}

	//Metodo abstracto
	public abstract double CalcularSueldo();

	//ToString
	@Override
	public String toString() {
		return "Personal [legajo=" + legajo + ", nombre=" + nombre + ", antiguedad=" + antiguedad + "]";
	}
	
}
