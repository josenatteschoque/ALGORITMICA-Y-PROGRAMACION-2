package net.datastructures;

import java.util.Arrays;

public class ArrayCircularDeque<E> implements Deque<E> {
	private int capacity;
	private E[] array;
	private int size;
	private int frente;
	private int fin;
	
	
	public ArrayCircularDeque(int capacity) {
		this.capacity = capacity;
		array = (E[]) new Object[capacity];
		frente = 0;
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
		return array[frente];
	}

	//Retorna el ultimo elemento
	@Override
	public E last() {
		if(isEmpty()) return null;
		return array[fin];
	}

	//Agrega ala ultima posicion 
	@Override
	public void addFirst(E e) {
		//Esto hace que vuelva ala ultima posicion del arreglo
		frente = (frente - 1 + array.length ) % array.length;
		array[frente] = e;
		size++;
	}

	//Agrega ala primera posicion
	@Override
	public void addLast(E e) {
		//Esto hace que agregue el elemento en la primer posicion del arreglo
		fin = (fin + 1) % array.length;
		array[fin] = e;
		size++;
	}

	//Elimina el elemento del frente
	@Override
	public E removeFirst() {
		//Si el arreglo esta vacio retorna null
		if(isEmpty()) return null;
		
		//Guardo el elemento a eliminar
		E element = array[frente];
		
		//Limpio la posicion del elemento eliminado
		array[frente] = null;
		
		//Muevo el frente hacia adelante
		frente = (frente + 1 ) % array.length;
		
		//Declemento el tamaño
		size--;
		
		//Retorno el elemento eliminado
		return element;
	}

	//Elimina el elemento del fin
	@Override
	public E removeLast() {
		//Si el arreglo esta vacio retorna null
		if(isEmpty()) return null;
		
		//Guardo el elemento a eliminar
		E element = array[fin];
		
		//Limpio la posicion del elemento eliminado
		array[fin] = null;
		
		//Muevo el fin
		fin = (fin - 1 + array.length) % array.length;
		
		//Declemento el tamaño 
		size--;
		
		//Retorno el elemento eliminado
		return element;
	}

	@Override
	public String toString() {
		return "ArrayCircularDeque [capacity=" + capacity + ", array=" + Arrays.toString(array) + ", size=" + size
				+ ", frente=" + frente + ", fin=" + fin + "]";
	}

	
	
	
	
	
}
