//8. Escribir un programa que lee diez números e imprima la cantidad de números negativos, positivos y ceros.

import java.util.Scanner;

public class NumerosNPC {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		int contador_positivos=0;
		int contador_negativos=0;
		int contador_ceros=0;
		int []numeros = new int[10];//Declaro un arreglo de tamaño 10
		
		//Inicializo un for para permitir el ingreso de datos
		for(int i = 0;i < numeros.length; i++) {
			System.out.print("Ingrese un numero:");
			numeros[i] = teclado.nextInt();
			
			//Verifico si los numeros son positivos, negativos o son cero 
			if(numeros[i]>0) {
				contador_positivos ++;
			}else if(numeros[i] < 0) {
				contador_negativos ++;
			}
			else {
				contador_ceros ++;
			}
		}
		
		//Muestro por pantalla la cantidad de numeros positivos, negativos o ceros 
		System.out.println("La cantidad de numeros positivos es: "+contador_positivos);
		System.out.println("La cantidad de numeros negativos es: "+contador_negativos);
		System.out.println("La cantidad de ceros es: "+ contador_ceros);
		
		//Finalizo el Scanner
		teclado.close();
	}

}
