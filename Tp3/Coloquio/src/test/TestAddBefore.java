package test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.datastructures.SinglyLinkedList;

class TestAddBefore {

	private SinglyLinkedList<String> list;
	
	@BeforeEach
	void setUp() throws Exception {		
		list = new SinglyLinkedList<String>();
		list.addLast("Juan");
		list.addLast("Ana");
		list.addLast("Juan");
		list.addLast("Mariela");
		list.addLast("Juan");		
	}

	@Test
	public void testTestAddBefore1() {
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();
		listRes.addLast("Omar");
		listRes.addLast("Juan");
		listRes.addLast("Ana");
		listRes.addLast("Omar");
		listRes.addLast("Juan");
		listRes.addLast("Mariela");
		listRes.addLast("Omar");
		listRes.addLast("Juan");
		
		Assert.assertEquals(3, list.addBefore("Omar", "Juan"));
		Assert.assertEquals(8, list.size());
		Assert.assertEquals(listRes, list);		
	}

	
	@Test
	public void testTestAddBefore2() {	
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();		
		listRes.addLast("Juan");
		listRes.addLast("Ana");		
		listRes.addLast("Juan");
		listRes.addLast("Mariela");		
		listRes.addLast("Juan");
		
		Assert.assertEquals(0, list.addBefore("Omar", "Pablo"));
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(listRes, list);
	}

	@Test
	public void testTestAddBefore3() {	
		SinglyLinkedList<String> listRes = new SinglyLinkedList<String>();		
		Assert.assertEquals(0, listRes.addBefore("Omar", "Pablo"));
		Assert.assertEquals(0, listRes.size());
	}

}
