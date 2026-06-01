package test;

import net.datastructures.Deque;
import net.datastructures.ArrayCircularDeque;

public class TestArrayCircularDeque {

	public static void main(String[] args) {
		Deque<String> deque = new ArrayCircularDeque<>(5);
		
		deque.addFirst("Leo");
		deque.addLast("Fiona");
		deque.addFirst("Jose");
		deque.addLast("Kira");
		
		System.out.println("Tamaño: "+deque.size());
		System.out.println("Array: "+deque);
		System.out.println("Primero: "+deque.first());
		
		System.out.println("Primero eliminado: "+deque.removeFirst());
		System.out.println("Ultimo eliminado: "+deque.removeLast());
		
		System.out.println("Array: "+deque);

		
	}

}
