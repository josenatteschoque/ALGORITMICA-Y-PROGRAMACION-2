//11. Escribir un programa que lee cinco números entre 1 y 30 y dibuje un histograma horizontal usando *

import java.util.Scanner;

public class Dibujar_Histograma_Horizontal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		
		for(int i = 0; i < 5;i++) {
			System.out.print("Ingrese un numero entre 1 y 30:");
			int num = teclado.nextInt();
			
			//Verifico si el numero ingresado esta dentro del rango permitido
			if(num>=1 && num <=30){
				//Comienzo a dibujar los asteriscos solicitados
				for(int j = 0; j < num; j++) {
					System.out.print("*");
				}
				
			System.out.println();//Salto de linea 
			
			}else{
				System.out.println("Ingrese un numero dentro del rango permitido!");
				i--;
			}
		}
		//Finalizo el Scanner
		teclado.close();
	}
}

/*Tuve que preguntarle a una IA para poder razornar el problema ya que por mi mismo no pude comprenderlo!*/