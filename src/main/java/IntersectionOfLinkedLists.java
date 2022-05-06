import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfLinkedLists {

	public boolean intersection(List<Integer> linkedList1, List<Integer> linkedList2) {
		// convert one of the linked lists to a set
		Set<Integer> set = new HashSet<Integer>();
		for (Integer node : linkedList2) {
			set.add(node);
		}
		boolean match = linkedList1.stream().anyMatch(node ->  set.contains(node));
		return match;
	}

}
