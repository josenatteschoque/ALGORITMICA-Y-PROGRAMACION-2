package queue;

import net.datastructures.LinkedCircularQueue;
import net.datastructures.CircularQueue;

public class TestCircularyQueue {
	public static void main(String[] args) {
		CircularQueue<String> q = new LinkedCircularQueue<String>();
		
		q.enqueue("Juan");
		q.enqueue("Ana");
		q.enqueue("Pedro");
		q.rotate();
	
		System.out.println(q.first());
		System.out.println(q.isEmpty());

	}
}
