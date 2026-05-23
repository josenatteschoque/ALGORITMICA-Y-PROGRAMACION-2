package empleados;

public class EmpleadoBaseMasComision extends EmpleadoPorComision{
	double SalarioBase;

	//Constructor
	public EmpleadoBaseMasComision(String nombre, int documento, double PorcentajeDeComisiones, int VentasBrutas,
			double salarioBase) {
		super(nombre, documento, PorcentajeDeComisiones, VentasBrutas);	//Llama al constructor de Empleado
		SalarioBase = salarioBase;
	}

	public double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		SalarioBase = salarioBase;
	}

	@Override
	public String toString() {
		return super.toString()+" EmpleadoBaseMasComision [SalarioBase=" + SalarioBase + "]";
	}
	
}
