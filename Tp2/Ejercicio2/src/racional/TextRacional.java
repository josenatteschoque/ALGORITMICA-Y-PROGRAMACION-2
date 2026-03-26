/*2. Crear la clase Racional para realizar aritmética de números racionales. 
a) Utilizar variables enteras para representar los datos privados de la clase. 
b) Proporcionar un método constructor que permita inicializar un objeto de esta clase cuando se declara.
c) Incluir métodos públicos para cada una de las si¬guientes operaciones con racionales: suma, resta, producto, división y potencia.
d) Implementar el método toString para imprimir un número racional.
e) Agregar métodos para simplificar un racional.
f) Modificar los métodos de c) para que den racionales simplificados.
g) Incluir el atributo static cuenta que se incrementa cada vez que se crea un objeto de esta clase.*/
package racional;

public class TextRacional {

	public static void main(String[] args) {
		Racional r1 = new Racional(3,4);
		Racional r2 = new Racional(1,4);
		
		System.out.println("La suma es: "+ r1.sumar(r2));
		System.out.println("La resta es: "+r1.restar(r2));
		System.out.println("El producto es: "+r1.producto(r2));
		System.out.println("La division es: "+r1.division(r2));
		
	}

}
