package banco;

import java.time.LocalDate;
import java.util.Objects;

public class Bono extends Titulo{
	private static final double impuesto = 0.01;
	private LocalDate fechaVencimiento;
	
	public Bono(String simbolo, String descripcion, double precio, LocalDate fechaVencimiento) {
		super(simbolo, descripcion, precio);
		this.fechaVencimiento = fechaVencimiento;
	}

	//Getters y Setters
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public static double getImpuesto() {
		return impuesto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaVencimiento);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bono other = (Bono) obj;
		return Objects.equals(fechaVencimiento, other.fechaVencimiento);
	}

	@Override
	public String toString() {
		return "Bono [fechaVencimiento=" + fechaVencimiento + "]";
	}

	@Override
	public double calcularImpuesto(int cantidad) {
		return (cantidad * precio) * this.impuesto;
	}
	
}
