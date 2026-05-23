package empleados;

public class EmpleadoPorComision extends Empleado{
	double PorcentajeDeComisiones;
	int VentasBrutas;
	
	//Constructor
	public EmpleadoPorComision(String nombre, int documento, double PorcentajeDeComisiones, int VentasBrutas) {
		super(nombre, documento);	//Llama al constructor de Empleado
		this.PorcentajeDeComisiones = PorcentajeDeComisiones;
		this.VentasBrutas = VentasBrutas;
	}

	public double getPorcentajeDeComisiones() {
		return PorcentajeDeComisiones;
	}

	public void setPorcentajeDeComisiones(double porcentajeDeComisiones) {
		PorcentajeDeComisiones = porcentajeDeComisiones;
	}

	public int getVentasBrutas() {
		return VentasBrutas;
	}

	public void setVentasBrutas(int ventasBrutas) {
		VentasBrutas = ventasBrutas;
	}

	@Override
	public String toString() {
		return super.toString()+" EmpleadoPorComision [PorcentajeDeComisiones=" + PorcentajeDeComisiones + ", VentasBrutas="
				+ VentasBrutas + "]";
	}	
	
}
