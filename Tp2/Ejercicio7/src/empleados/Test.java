/*Crear la clase Empleado que tiene como atributos nombre y número de documento, 
 * además crear las subclases: EmpleadoAsalariado que tiene el valor del salario mensual,
 *  EmpleadoPorHora el valor de la hora y el número de horas trabajadas, EmpleadoPorComision 
 *  el porcentaje de comisiones y las ventas brutas, EmpleadoBaseMasComision (subclase de la anterior) que contiene el salario base. 
 *  Cada clase debe contener los constructores y los métodos gets y sets apropiados. Escribir un programa que cree instancias de  cada clase 
 *  y muestre toda la información asociada para cada objeto incluso la información heredada.*/
package empleados;

public class Test {
	public static void main(String[] args) {
		
		//Instancias de las subclases
		EmpleadoAsalariado a1 = new EmpleadoAsalariado("luis", 50123421, 12000);
		
		EmpleadoPorHora a2 = new EmpleadoPorHora("jose", 94587167, 3000.0, 10);
		
		EmpleadoPorComision a3 = new EmpleadoPorComision("leo", 50123421, 1.50, 10);

		EmpleadoBaseMasComision a4 = new EmpleadoBaseMasComision("maria", 20201010, 0.13, 23, 120000);
		
		//Muestro
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);

	}
}
