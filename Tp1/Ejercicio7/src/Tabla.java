//7. Escribir un programa que imprima una tabla de los cuadrados y los cubos de los números del 0 al 10. 

import java.util.Scanner;

public class Tabla {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);

		//Inicializo un for para la consigna
		for(int i = 0; i <= 10; i++ ) {
			System.out.println(i +" Su cuadrado es:"+ i*i);
			System.out.println(i +" Su cubo es: "+ i*i*i);
		}
		
		//Finalizo el Scanner
		teclado.close();
	}
}
