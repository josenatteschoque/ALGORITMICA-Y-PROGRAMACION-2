/*2. Realizar dos implementaciones distintas para realizar una búsqueda binaria sobre un arreglo, 
 * una en forma recursiva y otra en forma iterativa, utilizar una función de envoltura para llamar
 *  a la función de recursión con una firma limpia. Realizar trazas del algoritmo recursivo mostrando 
 *  distintos casos. Indicar la complejidad de ambos algoritmos.*/
package busquedabinaria;

public class TestBusquedaBinaria {
	public static void main(String[] args) {
		int array[] = {1, 4, 6, 8, 20, 142};
		
		System.out.println("¿El elemento 6 esta en el arreglo? "+BusquedaBinaria.binarySearch(array, 4, 0, 5));
		
		System.out.println("¿El elemento 6 esta en el arreglo? "+BusquedaBinaria.Interativo(array, 6));

	}
}
