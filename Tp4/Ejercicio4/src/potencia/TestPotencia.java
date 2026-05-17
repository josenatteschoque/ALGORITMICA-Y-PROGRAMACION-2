/*4. Realizar dos implementaciones recursivas para calcular la potencia de un número. 
 * Optimizar la segunda implementación multiplicando los resultados parciales. 
 * Probar con distintos números y medir el tiempo en obtener el resultado de cada algoritmo. 
 * Realizar una traza de ambos algoritmos para un número dado. Indicar la complejidad de ambos 
 * algoritmos.*/
package potencia;

public class TestPotencia {
	public static void main(String[] args) {
		int base = 2;
		int exp = 4;

		//Mido el tiempo de ejecucion del primer algoritmo!
		long inicio1 = System.nanoTime();
		long resultado1 = PotenciaRecursiva.CalcularPotencia(base, exp);
		long fin1 = System.nanoTime();

		System.out.println("Potencia Recursiva: " + base + "^" + exp + " = " + resultado1);
		System.out.println("Tiempo: " + (fin1 - inicio1) + " ns");

		
		//Mido el tiempo de ejecucion del segundo algoritmo!
		long inicio2 = System.nanoTime();
		long resultado2 = PotenciaRecursiva.PotenciaOptimizada(base, exp);
		long fin2 = System.nanoTime();

		System.out.println("Potencia Optimizada: " + base + "^" + exp + " = " + resultado2);
		System.out.println("Tiempo: " + (fin2 - inicio2) + " ns");
	}
}
