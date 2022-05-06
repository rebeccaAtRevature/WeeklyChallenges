import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntersectionOfLinkedListsTest {
	/*
	 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. 
	 * Return the intersecting node. Note that the intersection is defined based on reference, 
	 * not value. That is, if the kth node of the first linked list is the exact same node 
	 * (by reference) as the jth node of the second linked list, then they are intersecting.
	 */
	IntersectionOfLinkedLists inter = new IntersectionOfLinkedLists();
	@Test
	void intersectionPresentTest() {
		List<Integer> linkedList1 = new LinkedList<Integer>();
		linkedList1.add(1);
		linkedList1.add(2);
		linkedList1.add(3);
		linkedList1.add(4);
		linkedList1.add(5);
		linkedList1.add(6);
		linkedList1.add(7);
		linkedList1.add(8);
		linkedList1.add(9);
		linkedList1.add(10);
		
		List<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.add(1);
		linkedList2.add(2);
		linkedList2.add(3);
		linkedList2.add(4);
		linkedList2.add(5);
		linkedList2.add(6);
		linkedList2.add(7);
		linkedList2.add(8);
		linkedList2.add(9);
		linkedList2.add(10);
		
		boolean result = inter.intersection(linkedList1, linkedList2);
		assertTrue(result);
	}
	
	@Test
	void noValueIntersectionTest() {
		List<Integer> linkedList1 = new LinkedList<Integer>();
		linkedList1.add(1);
		linkedList1.add(2);
		linkedList1.add(3);
		linkedList1.add(4);
		linkedList1.add(5);
		linkedList1.add(6);
		linkedList1.add(7);
		linkedList1.add(8);
		linkedList1.add(9);
		linkedList1.add(10);
		
		List<Integer> linkedList2 = new LinkedList<Integer>();
		linkedList2.add(11);
		linkedList2.add(12);
		linkedList2.add(13);
		linkedList2.add(14);
		linkedList2.add(15);
		linkedList2.add(16);
		linkedList2.add(17);
		linkedList2.add(18);
		linkedList2.add(19);
		linkedList2.add(20);
		
		boolean result = inter.intersection(linkedList1,linkedList2);
		assertFalse(result);
	}
}
