package net.datastructures;

public class ArrayCircularDeque<E> implements Deque<E> {
	private int capasyte;
	private E[] array;
	private int size;
	private int inicio;
	private int fin;
	
	
	public ArrayCircularDeque(int capacity) {
		this.capasyte = capasyte;
		array = (E[]) new Object[capacity];
		inicio = 0;
		fin = -1;
		size = 0;
	}

	//Retorna el tamaño del arraglo
	@Override
	public int size() {
		return size;
	}

	//Retorna si el arreglo esta vacio
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	//Retorna el primer elemento
	@Override
	public E first() {
		if(isEmpty()) return null;
		return array[inicio];
	}

	//Retorna el ultimo elemento
	@Override
	public E last() {
		if(isEmpty()) return null;
		return array[fin];
	}

	//Agrega ala primera posicion 
	@Override
	public void addFirst(E e) {
		inicio = (inicio -1 + array.length)% array.length;
		array[inicio++] = e;
		size++;
	}

	//Agrega ala ultima posicion
	@Override
	public void addLast(E e) {
		fin = (fin + 1) % array.length;
		array[fin++] = e;
		size++;
	}

	//Elimina el elemento de la primer posicion
	@Override
	public E removeFirst() {
		return null;
	}

	//Elimina el elemento de la ultima posicion
	@Override
	public E removeLast() {
		return null;
	}
	
	
}
