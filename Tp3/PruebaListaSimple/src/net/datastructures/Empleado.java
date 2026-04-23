package net.datastructures;

public class Empleado implements Cloneable{
	
	private String nombre;
	private int dni;
	
	public Empleado(String nombre, int dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
