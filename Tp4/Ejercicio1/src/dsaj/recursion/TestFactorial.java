/*1. Realizar dos implementaciones distintas para calcular el factorial de un número, 
 *una en forma recursiva y otra en forma iterativa. 
 *El programa de prueba debe pedir el valor del factorial a calcular desde la línea de comando, 
 *si el usuario no ingresa un valor, lo pide desde la consola. 
 *Utilizar excepciones para el tratamiento de errores si el valor ingresado es menor a cero. 
 *Realizar una traza del algoritmo recursivo para un número dado. 
 *Indicar la complejidad de ambos algoritmos.*/

package dsaj.recursion;

import java.util.Scanner;

public class TestFactorial {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num = 0;
		System.out.println("Ingrese un numero: ");
		num = teclado.nextInt();
		
		System.out.println("El factorial de "+num+" es: "+Factorial.factorial(num));
		
	}
}
