import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RepeatedCharactersTest {
	RepeatedCharacters repeatedCharacters = new RepeatedCharacters();
	@ParameterizedTest
	@CsvSource({"hello,hello","aabcccccaaa,a2b1c5a3"})
	void repeatedCharactersTest(String input, String solution) {
		String expectedResult = solution;
		String actualResult = repeatedCharacters.count(input);
		assertEquals(expectedResult, actualResult);
		
	}
}
