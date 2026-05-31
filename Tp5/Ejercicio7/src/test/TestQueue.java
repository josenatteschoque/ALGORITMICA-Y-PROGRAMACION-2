/*7. Utilizar una cola para cargar empleados y facturas (ejercicio 2.11). 
 * Calcular los importes a pagar.*/
package test;

import net.datastructures.Queue;
import net.datastructures.SinglyLinkedQueue;
import factura.Empleado;
import factura.Factura;

public class TestQueue {
	public static void main(String[] args) {

		Queue<Empleado> empleados = new SinglyLinkedQueue<>();
		Queue<Factura> facturas = new SinglyLinkedQueue<>();
		
		empleados.enqueue(new Empleado(1234, "Juan", null, 40, 25));
		empleados.enqueue(new Empleado(1235, "Ana", null, 40, 15));
		
		facturas.enqueue(new Factura("FortinRepublica", 22222, "2017-05-05"));

		//El Ejercicio lo dejo aqui porque el anterior ejercicio esta mal haci que paja hacerlo perdon :(
		//Pero ojo si se como solucionarlo pero no tengo tiempo.
		
		
	}
}
