package banco;

import java.util.Objects;

public class Accion extends Titulo{
	private double impuesto = 0.2;
	private boolean pagaDividiendo;
	
	public Accion(String simbolo, String descripcion, double precio, boolean pagaDividiendo) {
		super(simbolo, descripcion, precio);
		this.pagaDividiendo = pagaDividiendo;
		
	}

	//Getters y Setters 
	public double getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}


	public boolean isPagaDividiendo() {
		return pagaDividiendo;
	}


	public void setPagaDividiendo(boolean pagaDividiendo) {
		this.pagaDividiendo = pagaDividiendo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(impuesto, pagaDividiendo);
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
		Accion other = (Accion) obj;
		return Double.doubleToLongBits(impuesto) == Double.doubleToLongBits(other.impuesto)
				&& pagaDividiendo == other.pagaDividiendo;
	}

	@Override
	public String toString() {
		return "Accion [impuesto=" + impuesto + ", pagaDividiendo=" + pagaDividiendo + "]";
	}

	@Override
	public double calcularImpuesto(int cantidad) {
		return cantidad * precio * this.impuesto;
	}


}
