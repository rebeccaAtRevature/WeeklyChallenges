

public class MagicIndex {

	public boolean magicIndex(int[] input) {
		for (int i = 0; i < input.length; i++) {
			if (i==input[i]) {
				return true;
			}
		}
		return false;
	}

}
