package test;

import net.datastructures.List;

import java.util.Iterator;

import net.datastructures.ArrayList;

public class TestList {
	public static void main(String[] arg) {
		List<Integer> l = new ArrayList<Integer>();
		
		//l.add(0, 3);
		//l.add(1, 20);
		for(int i = 0;i < 30; i++)
			l.add(i, i*2);
		
		System.out.print(l);
		
		for(int j = 0; j < 30; j++)
			System.out.print(l.get(j));

		
		for(Integer i:l)
			System.out.println(i);
		
		
		//Este es equivallente al de arriba, es lo mismo pero usa interador
		Iterator<Integer> i  = l.iterator();
		while(i.hasNext()) {
			int n = i.next();
			System.out.println(n);
		}
	}
}
