package net.datastructures;

import java.util.Arrays;

public class Arraystack<E> implements Stack<E>, Cloneable {

	public static final int CAPASITY = 1000;
	
	private E []array;
	private int t = - 1; 
	
	//Constructor
	public Arraystack() { this(CAPASITY);}
	
	public Arraystack(int capacity) {
		array = (E[]) new Object[capacity];
	}
	
	//Metodo que clona un arreglo
	@Override
	@SuppressWarnings("unchecked")
	public Arraystack<E> clone() throws CloneNotSupportedException{
		//Copia las referencias y hace un casteo 
		Arraystack<E> copia = (Arraystack<E>) super.clone();
		
		//Creo un arreglo del mismo tamaño del otro
		copia.array = (E[]) new Object [this.array.length];

		//Copio los elementos del arreglo y los guardo en el nuevo arreglo
		for(int i = 0; i <= t; i++) {
			copia.array[i] = this.array[i];
		}
		//Retorna la copia
		return copia;
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
