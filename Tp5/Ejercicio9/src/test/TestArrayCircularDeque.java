package test;

import net.datastructures.Deque;
import net.datastructures.ArrayCircularDeque;

public class TestArrayCircularDeque {

	public static void main(String[] args) {
		Deque<String> manolo = new ArrayCircularDeque<>();
		
		manolo.addFirst("Leo");
		manolo.addLast("Fiona");
		System.out.println("Tamaño: "+manolo.size());
		System.out.println(manolo.first());
		System.out.println(manolo);

		
	}

}
