package singlylinkedlist;

public class TestSinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		
		lista1.addLast("juan");
		lista1.addLast("luis");
		lista1.addLast("carla");
		lista1.addLast("maria");
		
		System.out.println("Lista 1: "+lista1);
		
		//lista1.removeOdd();
		//System.out.println("Lista de posiciones impares: "+lista1);
		
		//Pruebo el metodo public SinglyLinkedList<E> right(int n) throws IndexOutOfBoundsException
		System.out.println("richt(2): "+ lista1.right(3));
		
	}
}
