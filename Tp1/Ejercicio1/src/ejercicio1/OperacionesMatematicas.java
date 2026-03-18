//1. Escribir un programa que lee dos números e imprima la suma,
//producto, diferencia y cociente de los números.
package ejercicio1;

import java.util.Scanner;//Necesario para recibir por teclado

public class OperacionesMatematicas {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);//esto permite ingresar datos por teclado como referencia 
		
		//Declaro las variables
		float num1,num2;
		float suma, resta, producto;
		float cociente;
		
		//Solicito que ingresen los datos
		System.out.print("Ingrese el primer numero:");
		num1 = teclado.nextFloat();
		System.out.print("Ingrese el segundo numero:");
		num2 = teclado.nextFloat();
		
		//Realizo las operaciones correspondientes
		suma = num1 + num2;
		resta = num1-num2;
		producto=num1 * num2;
		cociente=num1 / num2;
		
		//Muestro por pantalla los resultados
		System.out.println("La suma es:"+ suma);
		System.out.println("La resta es:"+ resta);
		System.out.println("El producto es:"+ producto);
		System.out.print("El cociente es:"+ cociente);
		
		teclado.close();//Esto cierra el uso del Scanner
	}
}
