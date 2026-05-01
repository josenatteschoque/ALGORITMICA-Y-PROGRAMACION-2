package servicio;

import java.util.Objects;

public class Persona extends Cliente{
	private String nombre;
	
	public Persona(int id, String direccion, String nombre, Plan plan) {
		super(id, direccion, plan);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nombre, other.nombre);
	}

	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

	@Override
	public double calcularFactura() {
		double saldo = plan.getTarifa()+IVA;
		return saldo;
	}
	
	
}
