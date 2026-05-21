package stack;

import net.datastructures.ArrayStack;
import net.datastructures.Stack;

public class TestStack {
	public static void main(String[] args) {
		Stack<String> st = new ArrayStack<String>();
		
		st.push("Juan");
		st.push("Pablo");
		st.push("Ana");
		
		System.out.println(st.pop());
		System.out.println(st.isEmpty());

	}
}
