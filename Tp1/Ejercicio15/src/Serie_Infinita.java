/*15. Escribir un programa que calcula el valor de e a partir de la serie infinita:
e = 1 + 1/1! + 1/2! + 1/3! + …*/

import java.util.Scanner;

public class Serie_Infinita {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		double numero;
		double e = 0;
		
		//Solicito los datos 
		System.out.println("Ingrese un numero: ");
		numero = teclado.nextDouble();
		
		//Calculo e apartir de la serie infinita
		for(int i = 0; i <= numero; i++) {
			e = e + (1.0 /calcular_factorial(i));
		}
		//Muestro el resultado por pantalla
		System.out.println("El resultado es: " + e);
	}
	
	//Metodo que calcula el factorial de un numero
	public static long calcular_factorial(int numero) {
		long f = 1;
		for(int i = 1; i <= numero; i++) {
			f = f*i;
		}
		return f;
	}
}
