package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.datastructures.DoublyLinkedList;

class TestSearchOccurrence {

	private DoublyLinkedList<String> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new DoublyLinkedList<String>();
		list.addLast("Juan");
		list.addLast("Ana");
		list.addLast("Juan");
		list.addLast("Mariela");
		list.addLast("Juan");
	}

	@Test
	public void testSearchOccurrence1() {
		Assert.assertEquals(0, list.searchOccurrence("Juan", 1));
		Assert.assertEquals(4, list.searchOccurrence("Juan", 3));
		Assert.assertEquals(-1, list.searchOccurrence("Juan", 4));
		Assert.assertEquals(-1, list.searchOccurrence("Juan", 8));
	}

	@Test
	public void testSearchOccurrence2() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.searchOccurrence("Juan", -4);
		});
	}

	@Test
	public void testSearchOccurrence3() {
		DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
		Assert.assertEquals(-1, list1.searchOccurrence("Juan", 3));

	}
}
