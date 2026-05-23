/*10. Cargar una lista de empleados utilizando las clases creadas en el ejercicio 7
 *y emitir un listado de todos los empleados y sus salarios. 
 *Adicionar un 10% de incremento en el listado para los EmpleadoBaseMasComision.*/
package empleados;

public class Test {
	public static void main(String[] args) {
		
		//Creo un arreglo polimorfico
		Empleado []empleado = new Empleado[4];
		
		empleado[0] = new EmpleadoAsalariado("luis", 50123421, 12000);
		empleado[1] = new EmpleadoPorHora("jose", 94587167, 3000.0, 10);
		empleado[2] = new EmpleadoPorComision("leo", 50123421, 1.50, 10);
		empleado[3] = new EmpleadoBaseMasComision("maria", 20201010, 0.13, 23, 120000);
		
		for(int i = 0; i < empleado.length; i++) {
			
			//Usamos instanceof para identificar al tipo específico
		    if (empleado[i] instanceof EmpleadoBaseMasComision) {
		    	
		    	//"Casteamos": Creamos una referencia temporal del tipo específico
		        EmpleadoBaseMasComision aux = (EmpleadoBaseMasComision) empleado[i];
		        double salarioBase = aux.getSalarioBase();

		        //Aplicamos el incremento del 10%
		        double incremento = salarioBase * 0.10;
		        aux.setSalarioBase(salarioBase + incremento);
		        System.out.println("Se aplico el incremento!");
		    }
			System.out.println(empleado[i]);
		}
	}
}
