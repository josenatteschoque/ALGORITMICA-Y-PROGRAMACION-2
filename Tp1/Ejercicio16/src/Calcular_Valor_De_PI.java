/*16. Escribir un programa que calcula el valor de π a partir de la serie infinita:
π = 4 – 4/3 + 4/5 – 4/7 + 4/9 – 4/11 + …*/

import java.util.Scanner;

public class Calcular_Valor_De_PI {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		//Declaro las variables
		int numero;
		int signo = 1;
		double PI = 0;
		
		//Solicito los datos por pantalla
		System.out.print("Ingrese la cantidad: ");
		numero = teclado.nextInt();
		
		//Se encaraga de calcular PI
		for(int i = 1; i <= (numero*2); i += 2) {//Como los números impares van saltando de dos en dos, para obtener N términos, el último denominador será aproximadamente el doble de N.
			PI = PI + (signo * (4.0/i));
			signo = signo * -1;//Modifica el signo para la siguiente operacion
		}
		
		//Muestro el resultado por pantalla
		System.out.print("El resultado es: "+ PI);
		
		//Finalizo el Scanner
		teclado.close();
	}
}
