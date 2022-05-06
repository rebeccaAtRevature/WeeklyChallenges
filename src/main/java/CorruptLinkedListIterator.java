import java.util.Iterator;

public class CorruptLinkedListIterator<T> implements Iterator<T> {

	CorruptableLinkedList<T>.Node<T> current;
	
	@Override
	public boolean hasNext() {
		
		return true;
	}

	@Override
	public T next() {
		
		return null;
	}

}
