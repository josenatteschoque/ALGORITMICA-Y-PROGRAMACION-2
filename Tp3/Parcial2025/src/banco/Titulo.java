package banco;

import java.util.Objects;

public abstract class Titulo {
	protected String simbolo;
	protected String descripcion;
	protected double precio;
	protected static double comision = 0.005;
	
	//Constructor
	public Titulo(String simbolo, String descripcion, double precio) {
		this.simbolo = simbolo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public static double getComision() {
		return comision;
	}

	public static void setComision(double comision) {
		Titulo.comision = comision;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion, precio, simbolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		return Objects.equals(descripcion, other.descripcion)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(simbolo, other.simbolo);
	}

	
	@Override
	public String toString() {
		return "Titulo [simbolo=" + simbolo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	//Calcula la comisión del banco por la compra realizada (cantidad * precio * comision)
	public double calcularComision(int cantidad) {
		return (this.precio * cantidad) * comision;
	}
		
	
	//Calcula el impuesto por la compra realizada (cantidad * precio * impuesto)
	public abstract double calcularImpuesto(int cantidad);
	
	
	//Calcula el precio total de la compra incluida la comisión del banco y los impuestos (precio * cantidad + comisión + impuestos)
	public double calcularPrecio(int cantidad) {
		return (this.precio * cantidad) + calcularComision(cantidad) + calcularImpuesto(cantidad); 
	}
}
