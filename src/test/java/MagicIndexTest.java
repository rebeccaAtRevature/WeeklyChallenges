import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MagicIndexTest {
	
	MagicIndex magicIndex = new MagicIndex();
	@Test
	void magicIndexPresentTest() {
		int[] input = new int[] {10,11,12,13,14,5,16,17,18,19};
		boolean result =  magicIndex.magicIndex(input);
		assertTrue(result);
	}
	@Test
	void magicIndexNotPresentTest() {
		int[] input = new int[] {10,11,12,13,14,15,16,17,18,19};
		boolean result =  magicIndex.magicIndex(input);
		assertTrue(!result);
	}
}
