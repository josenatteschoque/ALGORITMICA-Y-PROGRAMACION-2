package net.datastructures;

public class SinglyLinkedQueue<E> implements Queue<E> {
	private SinglyLinkedList<E> lista = new SinglyLinkedList<>();
	
	//Constructor
	public SinglyLinkedQueue() {}
	
	//Metodo que devuelve el tamaño
	@Override
	public int size() {
		return lista.size();
	}

	//Metodo que devuelve si la cola esta vacia 
	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	//Metodo que agrega elementos a la cola
	@Override
	public void enqueue(E e) {
		lista.addLast(e);
	}

	//Metodo que muestra el primer elemento de la cola
	@Override
	public E first() {
		return lista.first();
	}

	//Metodo que saca el primer elemento de la cola
	@Override
	public E dequeue() {
		return lista.removeFirst();
	}

	//Metodo toString
	@Override
	public String toString() {
		return "SinglyLinkedQueue [lista=" + lista + "]";
	}

	
	
}
