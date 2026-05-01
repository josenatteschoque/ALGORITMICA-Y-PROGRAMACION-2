package servicio;

import java.util.Objects;

public class Servicio {
	private int id;
	private String descripcion;
	
	public Servicio(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", descripcion=" + descripcion + "]";
	}
		
}
