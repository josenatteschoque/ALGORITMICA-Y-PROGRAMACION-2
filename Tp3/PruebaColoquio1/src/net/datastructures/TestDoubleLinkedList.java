package net.datastructures;

public class TestDoubleLinkedList {
	public static void main(String[] args) {
		//Creo una lista doblemente enlazada
		DoublyLinkedList<String> lista = new DoublyLinkedList<String>();
		
		//Agrego los elementos ala lista
		lista.addLast("Juan");
		lista.addLast("Ana");
		lista.addLast("Juan");
		lista.addLast("Mariela");
		lista.addLast("Juan");
		
		//Muestro la lista
		System.out.println("Lista: "+lista);
		
		//Muestro los elementos retornados
		System.out.println(" "+lista.tailString(2));
	}
	
	
}
