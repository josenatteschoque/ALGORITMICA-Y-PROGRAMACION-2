/*2. Utilizar una pila para cargar una nómina de empleados (ejercicio 2.10). 
 * Calcular el sueldo para cada uno de ellos.*/
package test;

import pila.Stack;
import empleado.Empleado;
import empleado.EmpleadoAsalariado;
import empleado.EmpleadoBaseMasComision;
import empleado.EmpleadoPorComision;
import empleado.EmpleadoPorHora;
import pila.SinglyLinkedStack;

public class Test {
	public static void main(String[] args) {
		Stack<Empleado> nomina = new SinglyLinkedStack<>(); 
		
		nomina.push(new EmpleadoAsalariado("luis", 50123421, 12000));
		nomina.push(new EmpleadoPorHora("jose", 94587167, 3000.0, 10));
		nomina.push(new EmpleadoPorComision("leo", 50123421, 1.50, 10));
		nomina.push(new EmpleadoBaseMasComision("maria", 20201010, 0.13, 23, 120000));
		
		Empleado[] empleados = new Empleado[4];
		
		//Estoy sacando los elementos de la pila 
		for(int i = 0; i < 4; i++) {
			empleados[i] = nomina.pop();
		}
		
		//Aqui calculo el sueldo de cada empleado
		//Uso el instanceof para ver que tipo de empleado es y haci calcular su sueldo apartir de eso
		for(int j = 0; j < empleados.length; j++) {
			Empleado emp = empleados[j];
			double sueldo = 0;
			
			if(emp instanceof EmpleadoAsalariado) {
				EmpleadoAsalariado e = (EmpleadoAsalariado) emp;
				sueldo = e.getSalarioMensual();
			}
			else if(emp instanceof EmpleadoPorHora) {
				EmpleadoPorHora e = (EmpleadoPorHora) emp;
				sueldo = e.getValorHora()*e.getHorasTrabajadas();
			}
			else if(emp instanceof EmpleadoBaseMasComision) {
				EmpleadoBaseMasComision e = (EmpleadoBaseMasComision) emp;
				sueldo = e.getSalarioBase() + (e.getPorcentajeDeComisiones() * e.getVentasBrutas());
			}
			else if(emp instanceof EmpleadoPorComision) {
				EmpleadoPorComision e = (EmpleadoPorComision) emp;
				sueldo = e.getVentasBrutas() * e.getPorcentajeDeComisiones();
			}
			
			//Muestro el nombre del empleado y su sueldo
			System.out.println(emp.getNombre() + ": " + sueldo);
		}
		
	}
}
