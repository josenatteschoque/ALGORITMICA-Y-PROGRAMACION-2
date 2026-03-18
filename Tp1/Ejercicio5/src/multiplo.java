//5. Escribir un programa que lee dos números e imprima si el primero es múltiplo del segundo.

import java.util.Scanner;

public class multiplo {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		int num1, num2;
		
		//Solicito el ingreso de datos 
		System.out.print("Ingrese el primer numero:");
		num1 = teclado.nextInt();
		System.out.print("Ingrese el segundo numero:");
		num2 = teclado.nextInt();
		
		//Verifico si es multiplo
		if(num1 % num2 == 0) {
			System.out.print(num1 +" Es multiplo de "+ num2);
			
		}
		else {
			System.out.print(num1 +" No es multiplo de "+ num2);
		}
		
		teclado.close();//Finalizo el Scanner
	}
}
