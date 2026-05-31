package test;

import net.datastructures.LinkedPositionalList;
import net.datastructures.PositionalList;
import net.datastructures.Position;

public class TestProfe {
	public static void main(String[] args) {
		PositionalList<String> pl = new LinkedPositionalList<>();
		
		pl.addLast("Ana");
		pl.addLast("Leo");
		
		Position<String> p;
		
		pl.addLast("Ana");
		p = pl.addLast("Juan");
		pl.addLast("Pedro");
		pl.addLast("Maria");
		
		
		System.out.println(pl.first().getElement());
		
		String primero = pl.first().getElement();
		String ultimo = pl.last().getElement();
		
		if(isPalindrome(pl)) {
			System.out.println("Es palindromo");
		}
		
	}
	
	public static boolean isPalindrome(PositionalList<String> pl) {
		Position<String> primero = pl.first();
		Position<String> ultimo = pl.last();
		for(int i = 0; i < pl.size()/2; i++) {
			
			if(!primero.getElement().equals(ultimo.getElement())) {
				return false;
			}else {
				primero = pl.after(primero);
				ultimo = pl.before(ultimo);
			}
			//Sigue sin hacer nada :(
		}
		return true;
	}
}
