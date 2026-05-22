package net;

import java.util.Arrays;

public class Arraystack<E> implements Stack<E> {

	public static final int CAPASITY = 1000;
	
	private E []array;
	private int t = - 1; 
	
	//Constructor
	public Arraystack() { this(CAPASITY);}
	
	public Arraystack(int capacity) {
		array = (E[]) new Object[capacity];
	}
	

	//Metodo que devuelve el tamaño del arreglo
	public int size() {
		return (t + 1);
	}

	//Metodo que devuelve si el arreglo esta vacio
	@Override
	public boolean isEmpty() {
		return (t == -1);
	}

	//Metodo que agrega el elemento al final del arreglo
	@Override
	public void push(E e) throws IllegalStateException {
		if(size() == array.length) throw new IllegalStateException("Stack full!");
		array[++t] = e;			
	}

	//Metodo que retorna el ultimo elemento
	@Override
	public E top() {
		if(isEmpty()) return null;
		return array[t];
	}

	//Metodo que retorna el ultimo elemento y lo elimina
	@Override
	public E pop() {
		if(isEmpty()) return null;
		
		E elemento = array[t];
		array[t] = null;
		t--;
		return elemento;
	}

	@Override
	public String toString() {
		return "Arraystack [array=" + Arrays.toString(array) + ", t=" + t + "]";
	}

	
}
