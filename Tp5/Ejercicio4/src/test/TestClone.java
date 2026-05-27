/*4. Implementar el método clone() para la clase LinkedStack*/
package test;
import net.datastructures.SinglyLinkedStack;

public class TestClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		SinglyLinkedStack<String> original = new SinglyLinkedStack<>();
		
		original.push("Jose");
		original.push("Luis");
		original.push("Renato");
		
		System.out.println("Original: "+original);
		
		//Clono la pila lista
		SinglyLinkedStack<String> copia = original.clone();
		
		//Modifico la pila lista
		original.push("Misa");
		
		System.out.println("Lista alterada: "+original);
		
		System.out.println("Copia: "+copia);

	}
}
