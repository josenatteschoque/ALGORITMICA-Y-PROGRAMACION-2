package test;
import net.datastructures.*;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<String> lista1 = new DoublyLinkedList<String>();
		DoublyLinkedList<String> lista2 = new DoublyLinkedList<String>();

		lista1.addFirst("Wilder");
		lista1.addFirst("pepe");
		lista1.addFirst("rita");
		
		lista2.addFirst("Leo");
		lista2.addFirst("Renato");
		lista2.addFirst("Rodri");
		
		System.out.println("Lista original:");
		System.out.println(lista1);

		System.out.println("Lista 2:");
		System.out.println(lista2);
		
		//Pruebo el Metodo addPos(E e, int n)
		System.out.println("Pruebo el Metodo addPos(E e, int n):");
		lista1.addPos("juanita", 2);
		System.out.println(lista1);
	
		//Pruebo el Metodo removeElement(E e)
		System.out.println("Pruebo el Metodo removeElement(E e):");
		lista1.removeElement("pepe");
		System.out.println(lista1);
		
		//Pruebo el Metodo removePos(int n)
		System.out.println("Pruebo el Metodo removePos(int n):");
		lista1.removePos(2);
		System.out.println(lista1);
		
		//Pruebo el Metodo concatenate(DoublyLinkedList<E> lista2)
		System.out.println("Pruebo el Metodo concatenate(DoublyLinkedList<E> lista2)");
		lista1.concatenate(lista2);
		System.out.println(lista1);
		
		//Pruebo el Metodo Search()
		System.out.println("Pruebo el Metodo Search():");
		System.out.println(lista1.search("rita"));
	
	}
}
