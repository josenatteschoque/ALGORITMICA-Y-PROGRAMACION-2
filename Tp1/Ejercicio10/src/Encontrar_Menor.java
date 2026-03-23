//10. Escribir una aplicación que encuentre el menor de varios enteros.
//El primer valor leído especifica el número de valores que el usuario va a introducir.

import java.util.Scanner;

public class Encontrar_Menor {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		int num = 0;
		
		//Solicito el ingreso de datos solicitados
		System.out.print("Ingrese la cantidad de numeros que necesita:");
		num = teclado.nextInt();

		//Declaro un arreglo para los numeros ingresados 
		int []arreglo = new int[num];
		
		//Inicio un bucle for para cargar el arreglo 
		for(int i = 0;i < arreglo.length; i++) {
			System.out.print("Ingrese un numero:");
			arreglo[i] = teclado.nextInt();
		}
		
		//Inicio la variable menor
		int menor = arreglo[0];
		
		//Inicio otro bucle for para encontrar el numero menor dentro del arreglo
		for(int i = 0; i < arreglo.length; i++) {
			if(arreglo[i] < menor) {
				menor = arreglo[i];
			}
		}
		
		//Muestros los datos por pantalla
		System.out.print("El menor es:"+ menor);
		
		//Finaliza el Scanner
		teclado.close();
	}	
}