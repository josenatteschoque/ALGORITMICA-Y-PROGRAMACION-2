//6. Escribir un programa que lee un nombre y un apellido por separado y lo muestre concatenado y separado por un espacio.

import java.util.Scanner;

public class nombre {
	public static void main(String[] arg) {
		Scanner teclado = new Scanner(System.in);
		
		//Solicito los datos correspondientes
		System.out.print("Ingrese su nombre:");
		String nombre = teclado.nextLine();
		
		System.out.print("Ingrese su apellido:");
		String apellido = teclado.nextLine();
		
		//Muestro los datos por pantalla
		System.out.print(""+ nombre);
		System.out.print(" "+ apellido);

		//Finalizo el Scanner
		teclado.close();

	}
}
