package pruebalistadobleenlazada;

public class TestListaDobleEnlazada {
	public static void main(String[] args) {
		DoublyLinkedList<String> a1 = new DoublyLinkedList<String>();
		DoublyLinkedList<String> a2 = new DoublyLinkedList<String>();

		a1.addLast("leo");
		a1.addLast("jose");
		a1.addLast("lucia");
		
		
		a2.addLast("leo");
		a2.addLast("jose");
		a2.addLast("benja");
		
		
		System.out.println("Lista 1:");
		System.out.println(a1);

		System.out.println("Lista 2:");
		System.out.println(a2);
		
		System.out.println("Las listas son iguales? "+a1.equals(a2));
		
		System.out.println("Richt(2): "+a1.right(2));
		
		System.out.println("Lista de posiciones impares: "+a1.removeOdd());
	}
}
