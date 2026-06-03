/*2. Crear un árbol de expresiones que represente la siguiente expresión aritmética: 
 * “(((5+2) ∗ (2−1))/((2+9)+((7−2)−1)) ∗8)”. 
 * Recorrer el árbol en postorder para obtener la notación postfija del mismo. 
 * Calcular el resultado de la expresión utilizando una pila (apilar los operando,
 *  cuando llega un operador desapilar los operando, realizar el cálculo y apilar el mismo)
*/
package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestArbol {
	public static void main(String[] args) {
		
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

		Position<String> p, q;
		p = tree.addRoot("/");

		q = tree.addLeft(p, "B");

		tree.addRight(p, "C");

		tree.addLeft(q, "D");

		tree.addRight(q, "E");
		
		
	}
}
