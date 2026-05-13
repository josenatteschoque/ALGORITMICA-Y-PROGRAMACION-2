package singlylinkedlist;

public class Test {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> lista = new SinglyLinkedList<>();
		
		lista.addLast(2);
		lista.addLast(3);
		lista.addLast(6);
		lista.removePos(2, 2);
		System.out.println(lista);
		
	}
}
