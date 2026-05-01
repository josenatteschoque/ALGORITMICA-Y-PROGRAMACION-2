package banco;

import java.util.Objects;

public class Activo {
	private int cantidad;
	private Titulo titulo;
	
	public Activo(int cantidad, Titulo titulo) {
		super();
		this.cantidad = cantidad;
		this.titulo = titulo;
	}

	//Getters y Setters
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activo other = (Activo) obj;
		return cantidad == other.cantidad && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Activo [cantidad=" + cantidad + ", titulo=" + titulo + "]";
	}
	
	
	
}
