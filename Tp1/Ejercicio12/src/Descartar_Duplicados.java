//12. Escribir un programa que lee 20 números y al final imprime los mismos descartando los duplicados.

import java.util.Scanner;

public class Descartar_Duplicados {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		//Declaro un arreglo para los 20 numeros ingresados
		int []arreglo = new int[20];
		
		//Cargo datos al arreglo
		for(int i = 0; i < arreglo.length; i++) {
			System.out.print("Ingrese un numero:");
			arreglo[i] = teclado.nextInt();
		}
		
		System.out.print("Los numeros sin duplicar son:");
		
		// 2. Lógica para mostrar solo los NO duplicados
        for (int i = 0; i < arreglo.length; i++) {
            boolean yaAparecio = false;

            // Revisamos desde el inicio hasta la posición actual (i)
            for (int j = 0; j < i; j++) {
                if (arreglo[i] == arreglo[j]) {
                    yaAparecio = true; // Si lo encuentra antes, activamos la bandera
                    break;             // No hace falta seguir buscando atrás
                }
            }

            // 3. Solo imprimimos si la bandera se quedó en 'false'
            if (!yaAparecio) { //Si el numero no aprecio lo imprime 
                System.out.print(arreglo[i] + " ");
            }
        }
        
        System.out.println(); //Salto de linea
		teclado.close(); //Finalizo el Scanner

	}
	
}
