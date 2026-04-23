package test;
import net.datastructures.*;

public class Test {

	public static void main(String[] args) {
		CircularlyLinkedList<String> lista1 = new CircularlyLinkedList<String>();

		lista1.addFirst("Juan");
		lista1.addLast("Ana");
		lista1.addFirst("Maria");
		
		System.out.println(lista1);
		
		System.out.println(lista1.search("Ana"));

		
		
	}

}
