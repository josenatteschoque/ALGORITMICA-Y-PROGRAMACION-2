package servicio;

import java.util.Objects;

public class Plan {
	private double tarifa;
	
	private TipoServicio tiposervicio;
	private Servicio servicio;
	
	public Plan(TipoServicio tiposervicio, Servicio servicio, double tarifa) {
		super();
		this.tiposervicio = tiposervicio;
		this.servicio = servicio;
		this.tarifa = tarifa;
	}
	
	
	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tarifa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		return Double.doubleToLongBits(tarifa) == Double.doubleToLongBits(other.tarifa);
	}


	@Override
	public String toString() {
		return "Plan [tarifa=" + tarifa + ", tiposervicio=" + tiposervicio + ", servicio=" + servicio + "]";
	}
	
}
