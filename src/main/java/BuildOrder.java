import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Exceptions.NoValidBuildOrderException;

public class BuildOrder {
	/*
	 * Build Order: You are given a list of projects and a list of dependencies
	 * (which is a list of pairs of projects, where the second project is dependent
	 * on the first project). All of a project's dependencies must be built before
	 * the project is. Find a build order that will allow the projects to be built.
	 * If there is no valid build order, return an error.
	 */
	
	public List<String> buildOrder(String[] projects, Map<String,String[]> dependencies) throws NoValidBuildOrderException {
		// create variable to store final order of projects
		List<String> order = new ArrayList<>(Arrays.asList(projects));
		// position the project so that it is after all of its dependencies
		// iterate through each project
		for (int i = 0; i < order.size(); i++) {
			// check each project's dependencies
			String[] projectDependencies = dependencies.get(order.get(i));
			// for project in position i, check if any dependencies exist in the subsequent indices	
			for (int j = i + 1; j < order.size(); j++) {
				for (int k = 0; k < projectDependencies.length; k++) {
					if (order.get(j).equals(projectDependencies[k])) {
						/*
						 *  Check if dependency is also dependent on project.
						 *  If so, this means there is no valid solution: throw exception.
						 */
						for (String d: dependencies.get(projectDependencies[k])) {
							if (order.get(i).equals(d)) {
								throw new NoValidBuildOrderException();
							}
						}
						// move valid dependency to position directly in front of project with the dependency
						order.remove(j);
						order.add(i,projectDependencies[k]);
						i++;
					}
				}
			}	
		}
		return order;
	}
}
