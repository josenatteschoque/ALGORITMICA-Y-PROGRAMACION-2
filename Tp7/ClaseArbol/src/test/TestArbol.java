package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class TestArbol {

	public static void main(String[] args) {
		LinkedBinaryTree<String> t = new LinkedBinaryTree<>();

		Position<String> p, q;
		p = t.addRoot("A");

		q = t.addLeft(p, "B");

		t.addRight(p, "C");

		t.addLeft(q, "D");

		t.addRight(q, "E");

		System.out.println(t);
		
		//Formas de recorrer un arbol

		// PreOrden RID = raiz, izquierda, derecha
		//A,B,D,E,C
		
		for (Position<String> r : t.preorder()) { 
			 System.out.println("Preorden: " +r.getElement()); 
		}
		System.out.println();
		 
		// InOrden IRD = izquierda, raiz, derecha
		//D,B,E,A,C
		for (Position<String> r : t.inorder()) {
			System.out.println("Inorden: " + r.getElement());
		}
		System.out.println();


		// PostOrden IDR = izquierda, derecha, raiz
		//D,E,B,C,A
		for (Position<String> r : t.postorder()) {
			System.out.println("Postorden: " + r.getElement());
		}
		System.out.println();

		
		//Seguimos probando metodos
		System.out.println("Profundidad: "+t.depth(p));
		
		System.out.println("Altura: "+t.height(p));
		
		System.out.println("Tamaño: "+t.size());
		

	}

}
