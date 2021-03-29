
package edu.miracosta.cs113.DSStackQueue;

public class Palindrome {


	private String inputString;
	private ArrayListStack<Character> charStack;

	/**
	 * Constructor. Inits a new Palindrome object, storing 
	 * a reference to the parameter inputString  in inputString and 
	 * pushing each character onto the stack. 
	 */
	public Palindrome(String inputString){

		if ( inputString == null  ){
			throw new IllegalArgumentException("Illegal inputString: "+inputString);
		}
		this.inputString = inputString.replace(" ", "");
		charStack =new ArrayListStack<>();
		fillStack();
	}


	/**
	 * Fills the stack with the characters in inputString.
	 */
	private void fillStack(){

		for ( int i = 0; i < inputString.length() ; i++  ){
			charStack.push(inputString.charAt(i));
		}

	}


	/**
	 * returns the string formed by popping each character from
	 * the stack and joining the characters. Empties the stack.
	 */

	private String buildReverse() {

		StringBuilder result = new StringBuilder();
		while (!charStack.empty()){
			//Remove top item from stack and append it to result.
			result.append(charStack.pop());
		}
		return result.toString();
	}

	/**
	 * Returns true if inputString and the string built by 
	 * buildReverse have the same contents, except for case.
	 * Otherwise, return false.
	 */
	public boolean isPalindrome() {
	
		return inputString.equalsIgnoreCase(buildReverse());
	}


}
