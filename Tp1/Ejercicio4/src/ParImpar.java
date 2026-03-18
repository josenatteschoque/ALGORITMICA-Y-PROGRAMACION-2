//4. Escribir un programa que lee un número e imprima si es par o impar utilizando el operador módulo.
import java.util.Scanner;

public class ParImpar {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);
		//Declaro las variables
		int num;
		//Solicito el ingreso de datos
		System.out.print("Ingrese el numero:");
		num = teclado.nextInt();
		//Verifica si el numero es par o impar 
		if(num % 2 == 0) {
			System.out.print("Es par!");
		}
		else {
			System.out.print("Es impar!");
		}
		
		teclado.close();//Finaliza el Scanner
		
	}
}
