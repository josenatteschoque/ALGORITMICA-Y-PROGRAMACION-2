/*2. Crear un árbol de expresiones que represente la siguiente expresión aritmética: 
 * “(((5+2) ∗ (2−1))/((2+9)+((7−2)−1)) ∗8)”. 
 * Recorrer el árbol en postorder para obtener la notación postfija del mismo. 
 * Calcular el resultado de la expresión utilizando una pila (apilar los operando,
 *  cuando llega un operador desapilar los operando, realizar el cálculo y apilar el mismo)
*/
package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;
import stack.SinglyLinkedStack;
import stack.Stack;

public class TestArbol {
	public static void main(String[] args) {
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
		Stack<String> operandos = new SinglyLinkedStack<String>();
		Stack<String> resultado = new SinglyLinkedStack<String>();
		
		/*
		 * RAIZ 0 = X
		 * NODO1 = /
		 * NODO2 = 8
		 * NODO3 = X
		 * NODO4 = +
		 * NODO5 = +
		 * NODO6 = -
		 * NODO7 = 5
		 * NODO8 = 2
		 * NODO9 = 2
		 * NODO10 = 1
		 * NODO11 = +
		 * NODO12 = -
		 * NODO13 = 2
		 * NODO14 = 9
		 * NODO15 = -
		 * NODO16 = 1
		 * NODO17 = 7
		 * NODO18 = 2
		 */
		Position<String> raiz = tree.addRoot("*");
		Position<String> Nodo1 = tree.addLeft(raiz, "/");
		Position<String> Nodo2 = tree.addRight(raiz, "8");
		Position<String> Nodo3 = tree.addLeft(Nodo1, "*"); 
		Position<String> Nodo4 = tree.addRight(Nodo1, "+"); 
		Position<String> Nodo5 = tree.addLeft(Nodo3, "+");
		Position<String> Nodo6 = tree.addRight(Nodo3, "-");
		Position<String> Nodo7 = tree.addLeft(Nodo5, "5");
		Position<String> Nodo8 = tree.addRight(Nodo5, "2");
		Position<String> Nodo9 = tree.addLeft(Nodo6, "2");
		Position<String> Nodo10 = tree.addRight(Nodo6, "1");
		Position<String> Nodo11 = tree.addLeft(Nodo4, "+");
		Position<String> Nodo12 = tree.addRight(Nodo4, "-");
		Position<String> Nodo13 = tree.addLeft(Nodo11, "2");
		Position<String> Nodo14 = tree.addRight(Nodo11, "9");
		Position<String> Nodo15 = tree.addLeft(Nodo12, "-");
		Position<String> Nodo16 = tree.addRight(Nodo12, "1");
		Position<String> Nodo17 = tree.addLeft(Nodo15, "7");
		Position<String> Nodo18 = tree.addRight(Nodo15, "2");
		
		// PostOrden IDR = izquierda, derecha, raiz
		//{5, 2, +, 2, 1, -, *, 2, 9, +, 7, 2, -, 1, -, +, /, 8, *} 
		for (Position<String> r : tree.postorder()) {
			//Cargo los elementos en una pila
			operandos.push(r.getElement());
			System.out.println("Postorden: " + r.getElement());
		}
		
		System.out.println(operandos);
		for(Position<String> j : tree.postorder()) {
			
		}

	}
}
