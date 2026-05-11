package singlylinkedlist;

public class Test {
	public static void main(String[] args) {
		SinglyLinkedList<String> lista = new SinglyLinkedList<String>();

		lista.addFirst("jose");
		lista.addFirst("lucia");
		lista.addFirst("pepe");

		System.out.println(lista.containsDuplicate());
	}
}
