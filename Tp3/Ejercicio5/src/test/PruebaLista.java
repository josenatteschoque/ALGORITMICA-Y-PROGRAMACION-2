package test;

import net.datastructures.SinglyLinkedList;

public class PruebaLista {
	public static void main(String[] args) {
		
		SinglyLinkedList<String> Lista1 = new SinglyLinkedList<String>();
		SinglyLinkedList<String> Lista2 = new SinglyLinkedList<String>();

		
		
		Lista1.addFirst("Juan");
		Lista1.addLast("Ana");
		Lista1.addFirst("Maria");
		
		Lista2.addFirst("Leo");
		Lista2.addLast("Jhon");
		Lista2.addFirst("Jose");
		
		System.out.println("Lista original:");
		System.out.println(Lista1);
	
		System.out.println("Lista 2:");
		System.out.println(Lista2);
	
		//Pruebo el Metodo Search()
		System.out.println("Pruebo el metodo search:");
		System.out.println(Lista1.search("Ana"));

		//Pruebo el Metodo addPos()
		System.out.println("Pruebo el metodo addPos:");
		Lista1.addPos("Luis", 3);
		System.out.println(Lista1);
		
		//Pruebo el Metodo removeElement()
		System.out.println("Pruebo el metodo removeElement:");
		Lista1.removeElement("Ana");
		System.out.println(Lista1);
	
		//Pruebo el Metodo removePos()
		System.out.println("Pruebo el metodo removePos:");
		Lista1.removePos(1);
		System.out.println(Lista1);
		
		//Pruebo el Metodo concatenate(SinglyLinkedList<E> lista2)
		System.out.println("Pruebo el metodo concatenate(SinglyLinkedList<E> lista2)");
		Lista1.concatenate(Lista2);
		System.out.println(Lista1);
		
		
		System.out.println("Ejercicio Finalizado!");
	}
}
