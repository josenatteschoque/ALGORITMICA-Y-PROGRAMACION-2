//9. Escribir un programa que lee diez números e imprima el número más grande y el número más pequeño

import java.util.Scanner;

public class Mayor_Menor {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		int []arreglo = new int[10];
		int mayor = arreglo[0];
		int menor = arreglo[0];
		
		//Inicializo el for para el ingreso de datos
		for(int i = 0; i < arreglo.length; i++) {
			System.out.print("Ingrese un numero: ");
			arreglo[i] = teclado.nextInt();
		}
		
		//Verifico cual el numero mayor y menor 
		for(int i = 1;i < arreglo.length ;i++) {
			if(arreglo[i] > mayor) {
				mayor = arreglo[i];
			}
			if(arreglo[i]< menor) {
				menor = arreglo[i];
			}
		}
		
		//Muestro el numero mayor y menor
		System.out.println("El numero mayor es:"+ mayor);
		System.out.println("El numero menor es:"+ menor);
		
		//Finalizo el Scanner
		teclado.close();
	}
}
