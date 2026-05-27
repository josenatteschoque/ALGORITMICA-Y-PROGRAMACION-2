/*3. Implementar el método clone() para la clase ArrayStack*/
package testclone;
import net.datastructures.Arraystack;
import net.datastructures.Stack;

public class TestClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		Arraystack<String> original = new Arraystack<>();
		
		original.push("Jose");
		original.push("Leo");
		original.push("Ana");
		
		System.out.println("La pila original es: "+original);
		//Clono la pila arreglo
		Arraystack<String> copia = original.clone();

		System.out.println("La copia de la pila original es: "+copia);
		//Modifico la pila  arreglo
		original.push("Mariano");
		System.out.println("La pila anterada es: "+original);

	}
}
