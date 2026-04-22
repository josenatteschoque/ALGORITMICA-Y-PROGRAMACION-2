package pruebalistadobleenlazada;

public class TestListaDobleEnlazada {
	public static void main(String[] args) {
		DoublyLinkedList<String> a1 = new DoublyLinkedList<String>();
		
		a1.addFirst("jose");
		a1.addFirst("omar");
		a1.addFirst("lucia");
		a1.addLast("juan");
		
		System.out.println("La lista es:");
		System.out.println(a1);
		
	}
}
