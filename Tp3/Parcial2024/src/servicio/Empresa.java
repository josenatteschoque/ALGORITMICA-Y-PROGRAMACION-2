package servicio;

import java.util.Objects;

public class Empresa extends Cliente{
	private String razonSocial;
	private boolean ivaExento;
	
	public Empresa(int id, String direccion, Plan plan, String razonSocial, boolean ivaExento) {
		super(id, direccion, plan);
		this.ivaExento = ivaExento;
		this.razonSocial = razonSocial;
		
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public boolean isIvaExento() {
		return ivaExento;
	}

	public void setIvaExento(boolean ivaExento) {
		this.ivaExento = ivaExento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ivaExento, razonSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return ivaExento == other.ivaExento && Objects.equals(razonSocial, other.razonSocial);
	}
	
	
	@Override
	public String toString() {
		return "Empresa [razonSocial=" + razonSocial + ", ivaExento=" + ivaExento + "]";
	}

	@Override
	public double calcularFactura() {
		double monto = plan.getTarifa();
		if(ivaExento != true) {
			monto += IVA;
		}
		return monto;
	}
	
	
}
