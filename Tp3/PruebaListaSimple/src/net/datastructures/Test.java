package net.datastructures;

public class Test {
	public static void main(String[] args) {
		SinglyLinkedList<Empleado> lista1 = new SinglyLinkedList<Empleado>();
		
		SinglyLinkedList<Empleado> lista2 = null;

		lista1.addFirst(new Empleado("jose",1234));
		lista1.addLast(new Empleado("wilder",94587122));
		
		
		try {
			lista2 = lista1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lista1.addFirst(new Empleado("luis", 9863323));
		
		System.out.println("Lista original:"+lista1);

		System.out.println("lista clonada:"+lista2);
		
		if(lista1.equals(lista2)) {
			System.out.println("son iguales");
		}else {
			System.out.println("no son iguales");
		}

		//Estudiar lo de clonacion profunda y superficial!!!
	}
}
