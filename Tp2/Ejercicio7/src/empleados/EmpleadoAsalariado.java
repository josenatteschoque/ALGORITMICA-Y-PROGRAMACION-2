package empleados;

public class EmpleadoAsalariado extends Empleado{
	double salarioMensual;

	//Constructor
	public EmpleadoAsalariado(String nombre, int documento, double salario) {
		super(nombre, documento);	//Llama al constructor de Empleado
		this.salarioMensual = salario;
	}

	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	@Override
	public String toString() {
		return super.toString()+ " EmpleadoAsalariado [salarioMensual=" + salarioMensual + "]";
	}
	
}
