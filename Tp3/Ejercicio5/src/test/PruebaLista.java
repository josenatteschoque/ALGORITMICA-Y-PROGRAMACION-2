package test;

import net.datastructures.SinglyLinkedList;

public class PruebaLista {
	public static void main(String[] args) {
		
		SinglyLinkedList<String> Lista1 = new SinglyLinkedList<String>();

		Lista1.addFirst("Juan");
		Lista1.addLast("Ana");
		Lista1.addFirst("Maria");
		
		System.out.println(Lista1);
		
		System.out.println(Lista1.search("Juan"));
		
		System.out.println(Lista1.search("Omar"));

		
		SinglyLinkedList<Integer> Lista2 = new SinglyLinkedList<Integer>();
		
		Lista2.addFirst(10);
		Lista2.addFirst(20);
		Lista2.addFirst(30);

		
		System.out.println(Lista2);
		Lista2.removeFirst();
		System.out.println(Lista2);

	}
}
