package listasimple;
/**
 * Retorna la lista con todos los elementos de la lista pasada combinados después del
 * primer elemento de la lista.
 *
 * Por ejemplo:
 * 
 * {A, B, C, D} {W, X, Y, Z} => {A, W, B, X, C, Y, D, Z}
 * 
 * {A, B, C, D} {W, X} => {A, W, B, X, C, D}
 * 
 * {A, B} {W, X, Y, Z} => {A, W, B, X, Y, Z}
 * 
 * {A, B, C, D} {} => {A, B, C, D}
 * 
 * {} {W, X, Y, Z} => {W, X, Y, Z}
 * 
 * {} {} => {}
 * 
 * @param SinglyLinkedList<E> l : lista con los elementos a combinar
 * 
 * @return lista original con todos los elementos de la lista l combinados
 *         después del primer elemento de la lista original
 * 
 */
	//public void addCombineAfter(SinglyLinkedList<E> l)

public class TestLista {
	public static void main(String[] args) {
		SinglyLinkedList<String> lista1 = new SinglyLinkedList<String>();
		SinglyLinkedList<String> lista2 = new SinglyLinkedList<String>();

		lista1.addFirst("a");
		lista1.addLast("b");
		lista1.addLast("c");

		lista2.addFirst("x");
		lista2.addLast("y");
		lista2.addLast("z");
		
		System.out.println("Lista 1:");
		System.out.println(lista1);

		System.out.println("Lista 2:");
		System.out.println(lista2);

		//System.out.println("Pruebo el metodo addCombineAfter(SinglyLinkedList<E> l)");
		//lista1.addCombineAfter(lista2);
		//System.out.println(lista1);
	
		System.out.println("Pruebo el metodo addCombineBefore(SinglyLinkedList<E> l)");
		lista1.addCombineBefore(lista2);
		System.out.println(lista1);
	}
}
