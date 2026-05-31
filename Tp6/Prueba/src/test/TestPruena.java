package test;

import net.datastructures.LinkedPositionalList;
import net.datastructures.Position;

public class TestPruena {

	public static void main(String[] args) {
		LinkedPositionalList<String> lista = new LinkedPositionalList<>();
		
		lista.addFirst("Wlder");
		lista.addFirst("Leo");
		lista.addFirst("Tito");
		lista.addFirst("Juan");
		
		System.out.println(lista);
		Iterable<Position<String>> posiciones = lista.positions();
		for(Position<String> p : posiciones) {
			System.out.println(p.getElement());
			
		}
		System.out.println(lista.size());
	}

}
