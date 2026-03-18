//2. Escribir un programa que reciba el radio de un círculo e imprima el diámetro (2r), 
//la circunferencia (2πr) y el área (πr2) de este círculo. Utilizar el valor constante 3.14159 para π.

package circulo;

import java.util.Scanner;

public class Circulo {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		final double PI = 3.14159;
		double radio;
		
		//Solicito los datos de entrada
		System.out.print("Ingrese el radio del circulo:");
		radio = teclado.nextInt();
	
		//Muestro los resultados y hago las operaciones correspondientes
		System.out.println("El diametro es:"+ 2*PI);
		System.out.println("La circunferencia es:"+ 2*PI*radio);
		System.out.println("El area es:"+ (PI*radio)*(PI*radio));
		
		teclado.close();//Finalizo el Scanner
	}
}
