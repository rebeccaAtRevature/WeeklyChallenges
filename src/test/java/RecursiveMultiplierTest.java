import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RecursiveMultiplierTest {

	RecursiveMultiplier rmult = new RecursiveMultiplier();
	@ParameterizedTest
	@CsvSource({
		"2,6,12",
		"200,600,120000"
	})
	void recursiveMultiplyTest(int multiplier, int multiplicand, int product) {
		int expected = product;
		int actual = rmult.recursiveMultiply(multiplier,multiplicand);
		assertEquals(expected, actual);
	}
}
