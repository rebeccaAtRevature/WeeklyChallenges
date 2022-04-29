import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import Exceptions.NoPossiblePathException;

public class RobotInAGridTest {
	/*
	 * Robot in a Grid: Imagine a robot sitting on the upper left corner 
	 * of grid with r rows and c columns. The robot can only move in two 
	 * directions, right and down, but certain cells are "off limits" such 
	 * that the robot cannot step on them. Design an algorithm to find a 
	 * path for the robot from the top left to the bottom right.
	 * 
	 * Robot may either go right or down, true -> 'right', false -> 'down' 
	 * if neither is possible restart from beginning,
	 * index [0][0] must have value of 0 otherwise throw, no feasible path exception
	 * if all paths have been attempted, throw no feasible path exception
	 */
	RobotInAGrid robot = new RobotInAGrid();
	@Test
	void robotInAGridSimpleTest() {
		
		// Simple possible input
		int[][] grid = new int[4][4];
		grid[0][0] = 0;
		grid[0][1] = 0;
		grid[0][2] = 0;
		grid[0][3] = 0;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 1;
		grid[1][3] = 0;
		grid[2][0] = 1;
		grid[2][1] = 1;
		grid[2][2] = 1;
		grid[2][3] = 0;
		grid[3][0] = 1;
		grid[3][1] = 1;
		grid[3][2] = 1;
		grid[3][3] = 0;
	
		// only possible path should be along first row and down the last column
		List<RobotForwardOption> expectedPath = new ArrayList<>(Arrays.asList(
			RobotForwardOption.RIGHT, RobotForwardOption.RIGHT, RobotForwardOption.RIGHT, RobotForwardOption.DOWN, RobotForwardOption.DOWN, RobotForwardOption.DOWN));
		List<RobotForwardOption> actualPath = null;
		try {
			actualPath = robot.walk(grid);
		} catch (NoPossiblePathException e) {
			e.printStackTrace();
		}
		assertEquals(expectedPath, actualPath);
	}
	
	@Test
	void robotInAGridWrongInitialPathTest() {
		
		// Algorithm should run into dead end and restart
		int[][] grid = new int[4][4];
		grid[0][0] = 0;
		grid[0][1] = 0;
		grid[0][2] = 0;
		grid[0][3] = 0;
		grid[1][0] = 1;
		grid[1][1] = 0;
		grid[1][2] = 1;
		grid[1][3] = 0;
		grid[2][0] = 1;
		grid[2][1] = 0;
		grid[2][2] = 1;
		grid[2][3] = 0;
		grid[3][0] = 1;
		grid[3][1] = 1;
		grid[3][2] = 1;
		grid[3][3] = 0;
	
		// only possible path should be along first row and down the last column
		List<RobotForwardOption> expectedPath = new ArrayList<>(Arrays.asList(
				RobotForwardOption.RIGHT, RobotForwardOption.RIGHT, RobotForwardOption.RIGHT, RobotForwardOption.DOWN, RobotForwardOption.DOWN, RobotForwardOption.DOWN));
		List<RobotForwardOption> actualPath = null;
		try {
			actualPath = robot.walk(grid);
		} catch (NoPossiblePathException e) {
			e.printStackTrace();
		}
		assertEquals(expectedPath, actualPath);
	}
	@Test
	void robotInAGridNoPossiblePathTest1() {
		// Simplest impossible input
		int[][] grid = new int[2][2];
		grid[0][0] = 0;
		grid[0][1] = 0;
		grid[0][2] = 0;
		grid[1][0] = 1;
		grid[1][1] = 1;
		grid[1][2] = 0;
		grid[2][0] = 0;
		grid[2][1] = 0;
		grid[2][2] = 0;
		
		
		NoPossiblePathException nppe = assertThrows(NoPossiblePathException.class, () -> {
			robot.walk(grid);
		});
		assertEquals("There is no valid path.", nppe.getMessage());
	}
	@Test
	void robotInAGridNoPossiblePathTest2() {
		// Robot will not be able to enter map
		int[][] grid = new int[2][2];
		grid[0][0] = 1;
		grid[0][1] = 0;
		grid[1][0] = 1;
		grid[1][1] = 0;
				
		NoPossiblePathException nppe1 = assertThrows(NoPossiblePathException.class, () -> {
			robot.walk(grid);
		});
		assertEquals("There is no valid path.", nppe1.getMessage());
	}
}
