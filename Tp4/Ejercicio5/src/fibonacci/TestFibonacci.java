/*5. Realizar dos implementaciones recursivas para calcular Fibonacci de un número. 
 * Optimizar la segunda implementación realizando una única llamada recursiva dentro de la función. 
 * Probar con distintos números y medir el tiempo en obtener el resultado de cada algoritmo. Realizar una traza de 
 * ambos algoritmos para un número dado. Indicar la complejidad de ambos algoritmos.*/
package fibonacci;

public class TestFibonacci {
	public static void main(String[] args) {

		// Tomo el tiempo de inicio
		long inicio = System.nanoTime();
		// Llamo al Metodo Recursivo
		long resul = FibonacciRecursiva.FibonacciRecursiva(6);
		// Tomo el tiempo final
		long fin = System.nanoTime();

		System.out.println("Fibonacci de 6 = " + resul);
		System.out.println("Tiempo: " + (fin - inicio) + "ns");

		// Tomo el tiempo de inicio
		long inicio1 = System.nanoTime();
		// Llamo al Metodo Recursivo Optimizado
		long resul1 = FibonacciRecursiva.FibonacciUnaLlamada(6);
		// Tomo el tiempo final
		long fin1 = System.nanoTime();

		System.out.println("Fibonacci  Optimizada de 6 = " + resul1);
		System.out.println("Tiempo: " + (fin1 - inicio1) + "ns");
		
		
		//EL primer algoritmo esta bien pero tarda,el segundo es mas rapido pero cuando llega a numeros mayores a 70 se vuelve ineficiente
		
	}
}
