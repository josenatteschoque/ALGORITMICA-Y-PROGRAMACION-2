package proyectoiqual;

import java.util.Objects;

public class Alumno {
	private int legajo;
	private String nombre;
	private String email;
	
	//Constructor de la clase
	public Alumno(int legajo, String nombre, String email) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//Metodo toString
	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", nombre=" + nombre + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, legajo, nombre);
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
		return Objects.equals(email, other.email) && legajo == other.legajo && Objects.equals(nombre, other.nombre);
	}
	
	//El metodo equals sirve para comparar objetos! Es importante!!
}
