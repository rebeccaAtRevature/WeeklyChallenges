package Exceptions;

public class NoPossiblePathException extends Exception{
	@Override
	public String getMessage() {
		
		return "There is no valid path.";
	}
	
}
