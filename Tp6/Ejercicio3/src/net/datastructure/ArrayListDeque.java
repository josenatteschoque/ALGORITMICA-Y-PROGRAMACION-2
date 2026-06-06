package net.datastructure;

public class ArrayListDeque<E> implements Deque<E>{
	private ArrayList<E> lista = new ArrayList<>();
	
	//Retorna el tamaño
	@Override
	public int size() {
		return lista.size();
	}

	//Retorna si esta vacio
	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	//Retorna el primer elemento
	@Override
	public E first() {
		if(isEmpty()) 
			return null;
		return lista.get(0);
	}

	//Retorna el ultimo elemento
	@Override
	public E last() {
		if(isEmpty())
			return null;
		return lista.get(size() - 1);
	}

	//Agrega ala primera posicion
	@Override
	public void addFirst(E e) {
		lista.add(0, e);
	}

	//Agrega ala ultima posicion
	@Override
	public void addLast(E e) {
		lista.add(size(), e);
	}

	//Elimina el elemento de la primer posicion
	@Override
	public E removeFirst() {
		if(isEmpty())
			return null;
		return lista.remove(0);
	}

	//Elimina el elemento de la ultima posicion
	@Override
	public E removeLast() {
		if(isEmpty())
			return null;
		return lista.remove(size() - 1);
	}

	@Override
	public String toString() {
		return "ArrayListDeque [lista=" + lista + "]";
	}
	
	
}
