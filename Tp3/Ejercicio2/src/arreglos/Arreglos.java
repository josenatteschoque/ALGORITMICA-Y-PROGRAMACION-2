/*Cargar un arreglo con elementos y probar los siguientes métodos de la clase java.util.Arrays 

•	equals(A, B)	
•	fill(A,x)	
•	copyOf(A, n)
•	copyOfRange(A, s, t)
•	toString(A) 
•	sort(A)
•	binarySearch(A, x)
*/
package arreglos;
import java.util.Arrays;	//Con esto puedo usar todas los metodos de arrays

public class Arreglos {
	public static void main(String [] args) {
		int array1[] = {1,2,4,5,2,78,9};
		int array2[] = {3,2,5,6,8,3,1};
		
		//toString(A) Muestra el contenido de un array sin usar un for
		System.out.println("Arreglo 1 es: "+Arrays.toString(array1));
		System.out.println("Arreglo 2 es: "+Arrays.toString(array2));
		
		//equals(A, B) Retorna true o false si es que son iguales o distintos
		System.out.println("¿Arreglo1 es igual al arreglo2? "+Arrays.equals(array1, array2));
		System.out.println("¿Arreglo2 es igual al arreglo1? "+Arrays.equals(array2, array1));

		//sort(A) Ordena los elementos del arreglo de forma ascendente 
		Arrays.sort(array2);
		System.out.println("Arreglo2 ordenado:"+Arrays.toString(array2));
		
		//binarySearch(A, x) Realiza una busqueda binaria de un elemento en el arreglo
		int indice = Arrays.binarySearch(array2, 6);
        System.out.println("El número 8 está en el índice: " + indice);
		
        //copyOf(A, n) Crea una copia con una nueva longitud (n)
        int[] copiaCorta = Arrays.copyOf(array1, 3);
        System.out.println("Copia los primeros 3: "+Arrays.toString(copiaCorta));
        
        //copyOfRange(A, s, t)
        //Copia desde el índice 's' (inclusive) hasta 't' (exclusivo)
        int[] rango = Arrays.copyOfRange(array1, 1, 4);
        System.out.println("Rango del índice 1 al 3: " + Arrays.toString(rango));
        
        //fill(A, x) Llena todo el arreglo con un solo valor (x)
        Arrays.fill(array2, 1);
        System.out.println("Arreglo2 despues de fill(1):"+ Arrays.toString(array2));
	}
}
