/*13. Escribir un programa para simular el lanzamiento de dos dados. 
 * El programa debe pedir el número de veces que se tiran los dados y mostrar una tabla indicando cuantas veces aparece cada suma.*/

import java.util.Scanner;
import java.util.Random;

public class Lanzamiento_Dados {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random numeros_aleatorios = new Random(); //Genera numeros aleatorios
		
		//Declaro las variables
		int cantidad;
		int frecuencia[] = new int[13];
		
		//Solicito el ingreso de datos 
		System.out.print("¿Cuantas veses quieres tirar los dados?: ");
		cantidad = teclado.nextInt();

		//Tiro los dados
		for(int tiro = 0; tiro <= cantidad; tiro++) {
			//Genera 2 numeros entre 1 y 6
			//.nextInt da un numero de 0 a 5 por eso sumamos 1
			int dado1 = numeros_aleatorios.nextInt(6) + 1;
			int dado2 = numeros_aleatorios.nextInt(6) + 1;
			
			int suma = dado1 + dado2;
			frecuencia[suma]++;
		}
		//Muestro el resultado por pantalla
		System.out.print("\nSUMA\tFRECUENCIA\n");
		System.out.println("---------------------");
		for(int i = 2; i <= 12; i++) {
			System.out.println(i+"\t"+ frecuencia[i]);
		}
		//Finaliza el Scanner
		teclado.close();	
	}
}
