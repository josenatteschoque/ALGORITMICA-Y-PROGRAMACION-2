package singlylinkedlist;

public class Test {
	public static void main(String[] args) {
		SinglyLinkedList<String> lista = new SinglyLinkedList<>();

		lista.addFirst("x");
		lista.addFirst("b");
		lista.addFirst("x");
		lista.addFirst("y");
		lista.addFirst("x");

		System.out.println("¿Hay duplicados? "+lista.containsDuplicate());
		
		System.out.println("El indice es: "+lista.lastIndexOf("x"));
	}
}
