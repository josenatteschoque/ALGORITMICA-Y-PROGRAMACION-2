package map;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private int dni;
	
	public Alumno(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return dni == other.dni && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	
}