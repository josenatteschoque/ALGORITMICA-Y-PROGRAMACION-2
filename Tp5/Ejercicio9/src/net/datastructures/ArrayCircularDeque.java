package net.datastructures;

public class ArrayCircularDeque<E> implements Deque {
	public static final int CAPASITY = 1000;
	private E[] array;
	
	public ArrayCircularDeque() {this(CAPASITY); }
	
	public ArrayCircularDeque(int capacity) {
		array = (E[]) new Object[capacity];
	}
	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
