import java.util.Iterator;

public class CorruptableLinkedList<T> implements Iterable<T> {
	
	// Code taken from : https://www.geeksforgeeks.org/linked-list-set-1-introduction/
	Node<T> head;
	
	/* Linked List Node */
	public class Node<T> {
		int data;
		Node next;
		
		// Constructor to create a new node
		// Next is by default initialized as null
		Node (int d) { 
			data = d;
			next = null;
		}
	}

	@Override
	public Iterator<T> iterator() {
		
		return new CorruptLinkedListIterator();
	}

}
