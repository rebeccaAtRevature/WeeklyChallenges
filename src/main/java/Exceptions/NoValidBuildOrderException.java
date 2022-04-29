package Exceptions;

public class NoValidBuildOrderException extends Exception {

	@Override
	public String getMessage() {
		
		return "There is no valid build order for this input.";
	}
	
}
