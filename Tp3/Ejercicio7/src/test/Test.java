package test;
import net.datastructures.*;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<String> lista1 = new DoublyLinkedList<String>();
		
		lista1.addFirst("Wilder");
		lista1.addLast("pepe");
		lista1.addFirst("rita");
		
		System.out.println(lista1);
		
	}
}
