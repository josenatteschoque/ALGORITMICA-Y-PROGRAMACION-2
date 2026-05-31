package net;


public class SinglyLinkedStack<E> implements Stack<E> {
	
	//Creo una instancia de una lista simplemente enlazada 
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	//Constructor
	public SinglyLinkedStack() {}
	
	//Metodo que devuelve el tamaño
	public int size() {
		return list.size();
	}
	
	//Metodo que devuelve si esta vacia
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	//Metodo que agrega el primer Elemento
	public void push(E element) {
		list.addFirst(element);
	}
	
	//Metodo que removueve el primer Elemento
	public E pop() {
		return list.removeFirst();
	}
	
	//Devuelve el primer Elemento
	public E top() {
		return list.first();
	}
	
	//Metodo toString
	public String toString() {
		return list.toString();
	}
}

