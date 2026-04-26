package test;
import net.datastructures.*;

public class Test {

	public static void main(String[] args) {
		CircularlyLinkedList<String> lista1 = new CircularlyLinkedList<String>();
		CircularlyLinkedList<String> lista2 = new CircularlyLinkedList<String>();

		
		lista1.addFirst("Juan");
		lista1.addLast("Ana");
		lista1.addFirst("Maria");
		
		lista2.addFirst("Leo");
		lista2.addLast("Ale");
		lista2.addFirst("Tito");
		
		System.out.println("Lista original: "+lista1);
		System.out.println("Lista 2: "+lista2);
		
		//Pruebo el Metodo addPos(E e, int n)
		System.out.println("Pruebo el Metodo addPos(E e, int n)");
		lista1.addPos("pepe", 0);
		System.out.println(lista1);
		
		//Pruebo el Metodo removeElement(E e)
		System.out.println("Pruebo el Metodo removeElement(E e)");
		lista1.removeElement("Ana");
		System.out.println(lista1);
		
		//public E removePos(int n) throws IndexOutOfBoundsException
		System.out.println("Pruebo el Metodo removePos(int n)");
		lista1.removePos(2);
		System.out.println(lista1);

		
		//public void concatenate(CircularlyLinkedList<E> lista2)
		System.out.println("Pruebo el Metodo concatenate(CircularlyLinkedList<E> lista2)");
		lista1.concatenate(lista2);
		System.out.println(lista1);
		
		System.out.println("Ejercicio Finalizado!");
	}

}
