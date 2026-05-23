/*2. Utilizar una pila para cargar una nómina de empleados (ejercicio 2.10). 
 * Calcular el sueldo para cada uno de ellos.*/
package test;

import pila.Stack;
import empleados.Empleado;
import empleados.EmpleadoAsalariado;
import empleados.EmpleadoBaseMasComision;
import empleados.EmpleadoPorComision;
import empleados.EmpleadoPorHora;
import pila.SinglyLinkedStack;

public class Test {
	public static void main(String[] args) {
		Stack<Empleado> nomina = new SinglyLinkedStack<>(); 
		
		nomina.push(new EmpleadoAsalariado("luis", 50123421, 12000));
		nomina.push(new EmpleadoPorHora("jose", 94587167, 3000.0, 10));
		nomina.push(new EmpleadoPorComision("leo", 50123421, 1.50, 10));
		nomina.push(new EmpleadoBaseMasComision("maria", 20201010, 0.13, 23, 120000));
		
		//Falta calcular el sueldo!
	}
}
