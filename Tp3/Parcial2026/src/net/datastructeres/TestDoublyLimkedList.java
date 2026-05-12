package net.datastructeres;

public class TestDoublyLimkedList {
	public static void main(String[] args) {
		DoublyLinkedList<String> lista = new DoublyLinkedList<>();
		
		lista.addLast("lucia");
		lista.addLast("jose");
		lista.addLast("romi");
		lista.addLast("renato");
		lista.addLast("romi");

		System.out.println("Lista:"+lista);
		
		int resultado1 = lista.searchOccurrence("romi", 1);
        System.out.println("searchOccurrence = romi, 1: " + resultado1 );
        
        int resultado2 = lista.searchOccurrence("jose", 3);
        System.out.println("searchOccurrence = jose, 3: " + resultado2 );
	}
}
