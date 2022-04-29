import java.util.ArrayList;
import java.util.List;

import Exceptions.NoPossiblePathException;

public class RobotInAGrid {
	/*
	 * Robot in a Grid: Imagine a robot sitting on the upper left corner 
	 * of grid with r rows and c columns. The robot can only move in two 
	 * directions, right and down, but certain cells are "off limits" such 
	 * that the robot cannot step on them. Design an algorithm to find a 
	 * safePath for the robot from the top left to the bottom right.
	 * 
	 * Robot may either go right or down
	 * if neither is possible restart from beginning,
	 * if all paths have been attempted, throw no feasible safePath exception
	 */
	public List<RobotForwardOption> walk(int[][] twoDimensionalGrid) throws NoPossiblePathException {
		List<RobotForwardOption> safePath = new ArrayList<>();
		List<int[]> actualPath = new ArrayList<>();
		RobotForwardOption[][] history = new RobotForwardOption[twoDimensionalGrid.length][twoDimensionalGrid[0].length];
		int i = 0;
		int j = 0;
		while ( i < twoDimensionalGrid.length) {
			while( j < twoDimensionalGrid[0].length) {
				actualPath.add(new int[] {i,j});
				// if this position was previously encountered and shown to be a deadend, throw exception
				if (history[i][j] == RobotForwardOption.DEADEND) {
					throw new NoPossiblePathException();
				}
				if(twoDimensionalGrid[i][j] == 1) { 
					// if started on 1, dead end
					history[i][j] = RobotForwardOption.DEADEND;	
					throw new NoPossiblePathException();
				} else if(j < twoDimensionalGrid[0].length - 1 ) {
					if (twoDimensionalGrid[i][j+1] == 0) {
						// default to right
						history[i][j] = RobotForwardOption.RIGHT;
						safePath.add(RobotForwardOption.RIGHT);
						j++;
					}
				} else if(i < twoDimensionalGrid.length - 1 ) {
					if (twoDimensionalGrid[i+1][j] == 0) {
						// if right is not permitted, go down
						history[i][j] = RobotForwardOption.DOWN;
						safePath.add(RobotForwardOption.DOWN); 
						i++;
					}
				} else if(j == twoDimensionalGrid[0].length - 1 && i == twoDimensionalGrid.length - 1 ) {
					i++;
					j++;
				} else {
					// if neither is permitted, dead end
					history[i][j] = RobotForwardOption.DEADEND;
					// remove permissions from current location
					twoDimensionalGrid[i][j] = 1;
					// go to previous safe square
					i = actualPath.get(actualPath.size()-2)[0];
					j = actualPath.get(actualPath.size()-2)[0];
				}
			}
		}
		return safePath;
	}
}
