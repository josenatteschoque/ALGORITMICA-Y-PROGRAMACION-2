/*14. Escribir el método factorial y un programa que lee un entero n no negativo y calcula su factorial del mismo.*/

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		int numero = 0;
		
		//Solicito los datos
		System.out.print("Ingrese un numero no negativo: ");
		numero = teclado.nextInt();
		
		//Verifico que el numero ingresado no se negativo
		if (numero < 0) {
			System.out.print("El numero ingresado es negativo!");
		}else {
			//Llamo al metodo calcular_factorial y le paso los paremetros
			long resultado = calcular_factorial(numero);
			//Muestro el resultado por pantalla
			System.out.print("El factorial de " +numero+ " es: "+ resultado);	
		}
		//Finalizo el Scanner
		teclado.close();
	}
	
	
	//Metodo para calcular el factorial de un numero
	public static long calcular_factorial(int numero) {
		//Declaro una variale tipo long por el alcanze que tiene el factorial
		long f = 1;
		for(int i = 1; i <= numero; i++) {
			f = f*i;
		}
		return f;
	}
}
