import java.util.HashSet;
import java.util.Set;

public class CorruptListDetection {

	Integer loopDetection(CorruptableLinkedList<Integer> corruptList) {
		// create variable to store visited values, maybe in a set?
		Set<Integer> set = new HashSet<>();
		boolean hasNext = true;
		while ( hasNext ) {
			set.add(corruptList.head.data);
			if(corruptList.head.next == null) {
				hasNext = false;
				continue;
			}
			// check if the value of 'next' member in node exists in previously visited values array
			if(set.contains(corruptList.head.next.data)) {
				return corruptList.head.next.data;
			}
			corruptList.head = corruptList.head.next;
		}
		
		return null;
	}

}
