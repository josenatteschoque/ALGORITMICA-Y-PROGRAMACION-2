package figuras;

import java.util.Objects;

public abstract class Figura {
	protected Punto origen;
	
	//Constructor
	public Figura(Punto origen) {
		super();
		this.origen = origen;
	}
	
	//Getters y Setters
	public Punto getPunto() {
		return origen;
	}

	public void setPunto(Punto origen) {
		this.origen = origen;
	}

	//Hashcode y Equals
	@Override
	public int hashCode() {
		return Objects.hash(origen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		return Objects.equals(origen, other.origen);
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Figura [punto=" + origen + "]";
	}


	//Metodo abstracto
	public abstract double area();	
}
