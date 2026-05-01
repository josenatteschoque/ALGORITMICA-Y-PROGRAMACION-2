package servicio;

import java.util.Objects;

public abstract class Cliente {
	private int id;
	protected final double IVA = 21;
	private String direccion;
	
	protected Plan plan;
	
	public Cliente(int id, String direccion, Plan plan) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.plan = plan;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getIVA() {
		return IVA;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IVA, direccion, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Double.doubleToLongBits(IVA) == Double.doubleToLongBits(other.IVA)
				&& Objects.equals(direccion, other.direccion) && id == other.id;
	}

	public abstract double calcularFactura();
	
}
