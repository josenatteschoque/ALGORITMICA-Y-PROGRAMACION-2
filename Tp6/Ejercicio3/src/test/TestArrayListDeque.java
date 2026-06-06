/*3. Implementar el TAD Deque usando un ArrayList para almacenar sus elementos.*/
package test;

import net.datastructure.Deque;

import net.datastructure.ArrayListDeque;

public class TestArrayListDeque {

	public static void main(String[] args) {
		Deque<String> cola = new ArrayListDeque<>();
		
		cola.addFirst("Jose");
		cola.addFirst("Leo");
		cola.addFirst("Wilder");
		cola.addLast("Renato");
		
		//Pruebo los metodos implementados
		System.out.println(cola);
		System.out.println("El primer elemento: "+cola.first());
		System.out.println("Elimino el primer elemento: "+cola.removeFirst());
		System.out.println(cola);
		System.out.println("Elimino el ultimo elemento: "+cola.removeLast());
		System.out.println(cola);
		System.out.println(cola.isEmpty());
		System.out.println("Tamaño: "+cola.size());
		
	}

}
