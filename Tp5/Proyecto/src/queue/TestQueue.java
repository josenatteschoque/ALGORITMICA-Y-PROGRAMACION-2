package queue;

import net.datastructures.ArrayQueue;
import net.datastructures.Queue;

public class TestQueue {
	public static void main(String[] args) {
		Queue<String> q = new ArrayQueue<String>();
		
		q.enqueue("Juan");
		q.enqueue("Ana");
		q.enqueue("Pedro");

	
		System.out.println(q.first());
		System.out.println(q.isEmpty());

	}
}
