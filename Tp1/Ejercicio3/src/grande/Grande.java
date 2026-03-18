//3. Escribir un programa que lee dos números e imprima el número más grande seguido de las palabras es más grande.
//Si son iguales, imprimir el mensaje los números son iguales.

package grande;
import java.util.Scanner;

public class Grande {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables 
		int num1, num2;
		
		//Solicito los datos
		System.out.print("Ingrese el primer numero:");
		num1 = teclado.nextInt();
		System.out.print("Ingrese el segundo numero:");
		num2 = teclado.nextInt();
		
		//Estructura condicional 
		if(num1==num2) {
			System.out.printf("Son iguales");
		}
		
		else if(num1>num2) {
			System.out.printf(num1 +" Es el mas grande");
		}
		else {
			System.out.printf(num2 +" Es el mas grande");
		}
		
		teclado.close();//Finaliza el Scanner
	}
}
