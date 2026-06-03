package stack;

public class DoublyLinkedStack<E> implements Stack<E> {

	//Creo una instancia de una lista doblemente enlazada 
	private DoublyLinkedList<E> list = new DoublyLinkedList<>();
	
	//Constructor
	public DoublyLinkedStack() {}
	
	//Metodo que devuelve el tamaño
	public int size() {
		return list.size();
	}
	
	//Metodo que devuelve si la lista esta vacia
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	//Metodo que agrega un Elemento en primera posicion
	public void push(E element) {
		list.addFirst(element);
	}
	
	//Metodo que remueve el primer Elemento
	public E pop() {
		return list.removeFirst();
	}
	
	//Metodo que devuelve el Primer Elemento
	public E top() {
		return list.first();
	}
	
	//Metodo toString
	public String toString() {
		return list.toString();
	}
	
}
