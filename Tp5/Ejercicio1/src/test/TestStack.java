/*1. Crear la clase DoublyLinkedStack que implementa la interfaz Stack. 
 * Utilizar la clase DoublyLinkedList para su implementación. 
 * Crear tres pilas, una implementada con un array, otro con una lista enlazada y la última con una
 *  lista doblemente enlazada. Medir los tiempos para las mismas operaciones en las distintas 
 *  implementaciones.*/
package test;

import net.Arraystack;
import net.DoublyLinkedStack;
import net.SinglyLinkedStack;
import net.Stack;

public class TestStack {
	public static void main(String[] args) {
		Stack<String> array = new Arraystack<String>();
		Stack<String> simple = new SinglyLinkedStack<String>();
		Stack<String> doble = new DoublyLinkedStack<String>();

		//Cargo la pila array = {Juan, Ana, Jose }
		array.push("Juan");
		array.push("Ana");
		array.push("Jose");

		//Cargo la pila simple = {Juan, Ana, Jose }
		simple.push("Juan");
		simple.push("Ana");
		simple.push("Jose");
		
		//Cargo la pila doble = {Juan, Ana, Jose }
		doble.push("Juan");
		doble.push("Ana");
		doble.push("Jose");
		
		//Pruebo los metodos de ArrayStack
		long inicio1 = System.nanoTime();
		System.out.println("El ultimo Elemento de la pila: "+array.pop());
		System.out.println("El ultimo Elemento es: "+array.top());
		System.out.println("¿La pila esta vacia? "+array.isEmpty());
		System.out.println("EL tamaño de la pila es: "+array.size());
		long fin1 = System.nanoTime();
		
		System.out.println("Tiempo: "+(fin1 - inicio1)+"ns");

		
		System.out.println("===========================================");
		//Pruebo los metodos de SinglyLinkedStack
		long inicio2 = System.nanoTime();
		System.out.println("El ultimo Elemento de la pila: "+simple.pop());
		System.out.println("El ultimo Elemento es: "+simple.top());
		System.out.println("¿La pila esta vacia? "+simple.isEmpty());
		System.out.println("EL tamaño de la pila es: "+simple.size());
		long fin2 = System.nanoTime();
		
		System.out.println("Tiempo: "+(fin2 - inicio2)+"ns");


		System.out.println("===========================================");
		//Pruebo los metodos de DoublyLinkedStack
		long inicio3 = System.nanoTime();
		System.out.println("El ultimo Elemento de la pila: "+doble.pop());
		System.out.println("El ultimo Elemento es: "+doble.top());
		System.out.println("¿La pila esta vacia? "+doble.isEmpty());
		System.out.println("EL tamaño de la pila es: "+doble.size());
		long fin3 = System.nanoTime();
		
		System.out.println("Tiempo: "+(fin3 - inicio3)+"ns");
	
	}
}
