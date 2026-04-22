package test;
import net.datastructures.CircularlyLinkedList;

public class PruebaListas {
	public static void main(String[] args) {
		CircularlyLinkedList<String> clist = new CircularlyLinkedList<String>();
		
			clist.addFirst("juan");
			clist.addFirst("jose");
			clist.addLast("tito");

			System.out.println(clist);
	}
}
