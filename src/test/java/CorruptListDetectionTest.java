import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CorruptListDetectionTest {
	
	CorruptListDetection corruptListDetection = new CorruptListDetection();
	
	@Test
	void corruptListDectionTest() {
		// Create a simple circular/corrupt linked list
		CorruptableLinkedList<Integer> corruptList = new CorruptableLinkedList<Integer>();
		corruptList.head = corruptList.new Node<Integer>(1);
		CorruptableLinkedList<Integer>.Node<Integer> second = corruptList.new Node<Integer>(2);
		CorruptableLinkedList<Integer>.Node<Integer> third = corruptList.new Node<Integer>(3);
		
		corruptList.head.next = second;
		second.next = third;
		third.next = corruptList.head;
		
		Integer expected = corruptList.head.data;
		Integer actual = corruptListDetection.loopDetection(corruptList);
		
		assertEquals(expected, actual);
	}
}
