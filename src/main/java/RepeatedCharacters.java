
public class RepeatedCharacters {
	public String count(String input) {
		String output = "";
		boolean match = false;
		int charCount = 1;
		for (int i = 0; i < input.length(); i++) {
			// reset count if match not found
			if (!match) {
				charCount = 1;
				// add character from original string to output string
				output += ""+input.charAt(i)+"";
			}
			
			// for last character skip the remainder of the loop
			if (i == input.length()-1) {
				output += ""+charCount+"";
				continue;
			}
			
			if(input.charAt(i) == input.charAt(i+1)) {
				charCount++;
				match = true;
			} else {
				output += ""+charCount+"";
				match = false;
			}
		}
		if (input.length() > output.length()) {
			return output;
		} else {
			return input;
		}
		
	}
}
