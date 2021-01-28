/**
 * 
 */
package com.miracosta.cs113.lab1;

/**
 * @author erich
 *
 */
public class Lab1 {

	public static String MULTIPLE_OF_THREE = "Fizz";
	public static String MULTIPLE_OF_FIVE = "Buzz";
	public static String MULTIPLE_OF_3_AND_5 = MULTIPLE_OF_THREE +  MULTIPLE_OF_FIVE;

	//Allow initialization of the object
	public Lab1() {

	}
	
	/**
	 *
	   @param int number is a positive number. Number is used to check if the number 
	   		is a multiple of the multiple variable.
	   @param int multiple variable is a positive number used to check if is multiple of another 
	   	   	positive number.

	   @return boolean True If the number % multiple == 0 which means number is a multiple of var multiple 
	**/

	public boolean isNumberMultipleOfN(int number, int multiple){

		boolean isMultipleOfN = false;

		if ( multiple <= 0  || number <=0  ) {
			return isMultipleOfN;
		} 

		if ( ( number % multiple  ) == 0 ) {
			isMultipleOfN = true;
		}

		return isMultipleOfN;
	}

	/** 
	 * @param int number is a positive integer greather than 0
	 * @param int ... multiples va_arg list contains the array of 
	 * 	      integer numbers which are the multiples to check 
	 * 	      against number parameter.
	 * @return boolean false if number is not multiple of m.
	 *
	 */

	public boolean isNumberMultipleOfNs(int number, int ... multiples){

		boolean allAreMultiplesOfNumber = true;
		if ( number <=0  ){
			throw new IllegalArgumentException("Error: number <= 0");
		}
		
		if ( !checkValidNumbers(multiples) ){
			throw new IllegalArgumentException("Error multiples[] has a negative number or is empty");
			
		}

		for ( int m : multiples ){

			if ( ( number % m  ) != 0 ) {
				allAreMultiplesOfNumber = false;
				break;
			}
		}

		return allAreMultiplesOfNumber;

		

	}


	/**
	 * @param int[] array of n numbers.
	 * @return true if the array only contains positive numbers. 
	 * 	   false if the array is less or equal to 0
	 */

	private boolean checkValidNumbers (int[] array) {
		
		if ( array.length <=0 ){
			return false;
		}
		
		for ( int i : array ) {

			if ( i <= 0  ){
				return false;
			}
		}
		
		return true;
	}
	

}
