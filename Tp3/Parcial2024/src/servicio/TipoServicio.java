package servicio;

import java.util.Objects;

public class TipoServicio {
	private int id;
	private String descripcion;
	
	//Constructor
	public TipoServicio(int id, String descripcion) {
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
		TipoServicio other = (TipoServicio) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id;
	}

	@Override
	public String toString() {
		return "TipoServicio [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
}
