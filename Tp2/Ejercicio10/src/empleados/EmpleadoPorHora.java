package empleados;

public class EmpleadoPorHora extends Empleado {
	double valorHora;
	int horasTrabajadas;
	
	//Constructor
	public EmpleadoPorHora(String nombre, int documento, double valorHora, int horasTrabajadas) {
		super(nombre, documento);	//Llama al Constructor de Empleado 
		this.valorHora = valorHora;
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public double getValorHora() {
		return valorHora;
	}
	
	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public String toString() {
		return super.toString() + " EmpleadoPorHora [valorHora=" + valorHora + ", horasTrabajadas=" + horasTrabajadas + "]";
	}
	
	
	
}
