import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BuildOrderTest {
	/*
	 * Build Order: You are given a list of projects and a list of dependencies
	 * (which is a list of pairs of projects, where the second project is dependent
	 * on the first project). All of a project's dependencies must be built before
	 * the project is. Find a build order that will allow the projects to be built.
	 * If there is no valid build order, return an error.
	 * 
	 * Input:
	 * projects: a, b, c, d, e, f
	 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
	 * Output: f, e, a, b, d, c
	 * 
	 */
	
	BuildOrder buildOrderObject = new BuildOrder();
	
	@Test
	void buildOrderTest() {
		Map<String, String[]> dependencies = new HashMap<String,String[]>();
		// to store multiple values for a single key, create a value set
		String[] dependenciesOfA = {"f"};
		String[] dependenciesOfB = {"f"};
		String[] dependenciesOfC = {"d"};
		String[] dependenciesOfD = {"a","b"};
		String[] dependenciesOfE = {""};
		String[] dependenciesOfF = {""};
		dependencies.put("a", dependenciesOfA);
		dependencies.put("b", dependenciesOfB);
		dependencies.put("c", dependenciesOfC);
		dependencies.put("d", dependenciesOfD);
		dependencies.put("e", dependenciesOfE);
		dependencies.put("f", dependenciesOfF);
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		// Assert that the build order returned is the expected one
		List<String> expectedResult = new ArrayList<String>(Arrays.asList("f", "a", "b", "d", "c", "e"));
		List<String> actualResult = null;
		try {
			actualResult = buildOrderObject.buildOrder(projects,dependencies);
		} catch (NoValidBuildOrderException e) {
			e.printStackTrace();
		}
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void noValidBuildOrderExceptionTest() {
		Map<String, String[]> dependencies = new HashMap<String,String[]>();
		// to store multiple values for a single key, create a value set
		String[] dependenciesOfA = {"f"};
		String[] dependenciesOfB = {"f"};
		String[] dependenciesOfC = {"d"};
		String[] dependenciesOfD = {"a","b"};
		String[] dependenciesOfE = {""};
		String[] dependenciesOfF = {"a"};
		dependencies.put("a", dependenciesOfA);
		dependencies.put("b", dependenciesOfB);
		dependencies.put("c", dependenciesOfC);
		dependencies.put("d", dependenciesOfD);
		dependencies.put("e", dependenciesOfE);
		dependencies.put("f", dependenciesOfF);
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		// Assert that the program throws an exception when there is no valid build order
		NoValidBuildOrderException nvboe = assertThrows(NoValidBuildOrderException.class, () -> {
			buildOrderObject.buildOrder(projects,dependencies); 
		});
		assertEquals("There is no valid build order for this input.", nvboe.getMessage());
	}
}
