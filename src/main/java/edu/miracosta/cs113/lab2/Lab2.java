/**
 * CS113
 * 
 */
package edu.miracosta.cs113.lab2;
import java.math.*;


/**
 * @author erich
 *
 */
public class Lab2 {

	private int number ;
	/**
	 * Constructor 
	 * Allows initialization
	 *
	 */
	public Lab2(){
	}

	/**
	 * This method checks if a Number is a power of two
	 *
	 * The easiest way to check if a number is a power of 
	 * two is given by the next formula.
	 * Where: 
	 * x = exponent
	 * b = base
	 * n = number
	 *
	 * log(n) / log(b) = x 
	 * 
	 * To determine if n is a power of the base b we use 
	 * the ceil and floor functions. This functions rounds to 
	 * highest and lowest decimal point. We know if the
	 * number is a power of base b 
	 * because the rounding operation for x with the two methods
	 * remains the same.
	 * Example :
	 *
	 * 	a = log(12) / log(2) ==  3.584862
	 * 	ceil(a) = 4  --> rounded to highest decimal 
	 * 	floor(a) = 3 --> rounded to lowest decimal 
	 *
	 * 	ceil(a) != floor(a) --> number is not a power of 
	 * 	base.
	 *
	 * 	but: 
	 *
	 * 	a = log(4) / log(2) == 2.0 
	 * 	ceil(a) = 2 
	 * 	floor(a) = 2
	 * 	number 4 is a a power of base b
	 *
	 *
	 * @param int number is a positive integer 
	 *
	 */
	public boolean isPowerOfTwo(int number){

		if ( number <=0  ){
			return false;
		}
		return ( (int) Math.ceil(Math.log(number) / 
					 Math.log(2)) ==
		          (int) Math.floor(Math.log(number) / 
				        Math.log(2)) );

	}


	
}

