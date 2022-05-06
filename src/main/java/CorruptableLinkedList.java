
public class CorruptableLinkedList<T> {
	
	// Code taken from : https://www.geeksforgeeks.org/linked-list-set-1-introduction/
	Node<T> head;
	
	/* Linked List Node */
	public class Node<T> {
		int data;
		Node<T> next;
		
		// Constructor to create a new node
		// Next is by default initialized as null
		Node (int d) { 
			data = d;
			next = null;
		}
	}

}
