package hospital;

import java.util.Objects;

public class Paciente {
	private String nombre;
	private String dni;
	
	//Constructor
	public Paciente(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	//Equals y Hashcode
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
		Paciente other = (Paciente) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}
	
	//ToString
	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
}
