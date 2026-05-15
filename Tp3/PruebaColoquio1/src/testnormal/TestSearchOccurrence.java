package testnormal;

import net.datastructures.*;

public class TestSearchOccurrence {
	public static void main(String[] args) {
		
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		
		list.addLast("Juan");
		list.addLast("Ana");
		list.addLast("Juan");
		list.addLast("Mariela");
		list.addLast("Juan");
		
		System.out.println("Lista: "+list);
		
		
		/* lo que esta haciendo es comparar si son iguales las posiciones donde ocurre la ocurrencia!
		Assert.assertEquals(0, list.searchOccurrence("Juan", 1));
		Assert.assertEquals(4, list.searchOccurrence("Juan", 3));
		Assert.assertEquals(-1, list.searchOccurrence("Juan", 4));
		Assert.assertEquals(-1, list.searchOccurrence("Juan", 8));*/
		
		System.out.println("Juan, 1: "+list.searchOccurrence("Juan", 1));
		System.out.println("Juan, 3: "+list.searchOccurrence("Juan", 3));
		System.out.println("Juan, 4: "+list.searchOccurrence("Juan", 4));
		System.out.println("Juan, 8: "+list.searchOccurrence("Juan", 8));

		//Aqui lanza una excepcion
		System.out.println("Juan, -4: "+list.searchOccurrence("Juan", -4));
		
		
	}
}
