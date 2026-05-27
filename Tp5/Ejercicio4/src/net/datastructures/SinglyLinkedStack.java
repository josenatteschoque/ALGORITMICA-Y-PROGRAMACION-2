package net.datastructures;


public class SinglyLinkedStack<E> implements Stack<E>, Cloneable {

	// Creo una instancia de una lista simplemente enlazada
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	// Constructor
	public SinglyLinkedStack() {
	}

	// Metodo que devuelve el tamaño
	public int size() {
		return list.size();
	}

	// Metodo que devuelve si esta vacia
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// Metodo que agrega el primer Elemento
	public void push(E element) {
		list.addFirst(element);
	}

	// Metodo que removueve el primer Elemento
	public E pop() {
		return list.removeFirst();
	}

	// Devuelve el primer Elemento
	public E top() {
		return list.first();
	}

	// Metodo toString
	public String toString() {
		return list.toString();
	}

	// Metodo que reutilaza el metodo clone de la clase SinglyLinkedList
	@Override
	@SuppressWarnings("unchecked")
	public SinglyLinkedStack<E> clone() throws CloneNotSupportedException {
		// Clono superficialmente
		SinglyLinkedStack<E> otro = (SinglyLinkedStack<E>) super.clone();

		// Clono profundamente usando el metodo clone() de la clase SinglyLinkedList
		otro.list = this.list.clone();

		return otro;

	}
}
