package net;

public class Arraystack<E> implements Stack<E> {

	private E []array;
	private int size = 0; 
	
	//Constructor
	public Arraystack(E[] array, int size) {
		super();
		this.array = array;
		this.size = size;
	}
	
	//Metodo que devuelve el tamaño del arreglo
	public int size() {
		return size;
	}

	//Metodo que devuelve si el arreglo esta vacio
	@Override
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}else {
			return false;
		}
	}

	//Metodo que agrega el elemento al final del arreglo
	@Override
	public void push(E e) {
		if(size == array.length) {
			E[] nuevo = (E[]) new Object[array.length *2];
			for(int i = 0; i < size; i++) {
				nuevo[i] = array[i];
			}
			array = nuevo;
		}
		
		array[size] = e;
		size++;
	}

	//Metodo que retorna el ultimo elemento
	@Override
	public E top() {
		if(isEmpty()) {
			return null;
		}
		return array[size()-1];
	}

	//Metodo que retorna el ultimo elemento y lo elimina
	@Override
	public E pop() {
		if(isEmpty()) {
			return null;
		}
		
		E elemento = array[size()-1];
		array[size()-1] = null;
		size--;
		return elemento;
	}
}
