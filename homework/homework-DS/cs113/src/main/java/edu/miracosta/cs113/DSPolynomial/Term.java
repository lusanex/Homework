package edu.miracosta.cs113.DSPolynomial;

import java.util.regex.*;

public class Term implements Comparable<Term> {

	
	private static final int DEFUALT_VALUE = 1;
	private int coefficient;
	private int exponent;

	/**
	 * Constructor
	 * @param int coefficient is the coefficient of a term ex: 2x 
	 * -> 2 is the coefficient of the term 2x
	 *  @param int exponent is the exponent of a term 
	 *  2x^4 -> 4 is the exponent of the term.
	 */

	public Term(int coefficient, int exponent ) {

		this.coefficient = coefficient;
		this.exponent = exponent;

	}

	public Term() {

		this(DEFUALT_VALUE,DEFUALT_VALUE);
		
	}
	/**
	 * The constructor accepts a monomial term. The term is of the form 
	 * mx^n. Example 2x^2. The term can have a sign before the term
	 * like the next example -2x^23 if the term does not contain the sign.
	 * It is assumed to be a positive monomial.
	 * Special case if a empty string is given the Term class sets the state of the 
	 * object to 
	 * coefficient = 0;
	 * exponent = 0;
	 * and the toString method returns "" empty String.
	 * The constructor tries to parse a non sense term an return a consistent
	 * state for example if the user inputs the next expression
	 * -23xe^345erich
	 *  the resulting Term will contain the next values 
	 *  coefficient = -23
	 *  exponent = 345
	 *  and the toString method returns -23x^345
	 *
	 * @param String o is the monomial term of the form [-+]mx^n to convert to a term
	 *
	 */
	public Term( String o) {

		int c = 0;
		int e = 0;
		int[] indexes = new int[2];

		o = o.replaceAll(" ","");
		if ( o == null) {
		 	throw new NullPointerException("");
		}

		if ( o.contains("++") || o.contains("--") ){
			throw new IllegalArgumentException(o.substring(0,2));
		}	
		
		if ( o.equals("") ) {
			coefficient = 0;
			exponent = 0;
			return;
		}
		//possible cases 
		// +2x^2
		//  2x^2
		// -2x^2
		//  2x
		// +2x
		// -2x
		// -x
		// +x
		//  2
		// -2
		// ""
		// even +2#$#@$@#$@#XC  parses to 2 
		//
		//
		int lenTerm = o.length();

		indexes = regex("[a-zA-Z]{1,}",o);

		//if Term only have literals and it have more than one character 
		//the first if throws 
		//an illegal argument example xx bad case 
		// x -> OK
		if ( indexes[0] == 0) {

			if ( o.substring(0,indexes[1]).length() > 1) {
				throw new IllegalArgumentException("Invalid Term(String) : "+ o);
			}
			c = 1;
		}
		// coefficient and literals found 
		// 23x -> OK
		// 23xsdfsdf -> Ok parses to 23x
		else if ( indexes[0] != -1  & indexes[0] != 1){
			
			c = Integer.parseInt(o.substring(0,indexes[0]));

		}
		// literal found at index 1
		// +x -> parses to coefficient 1
		// -x -> parses to coefficient -1
		// 2xsda -> parses to 2x
		else if ( indexes[0] == 1 ) {
			if ( o.substring(0,indexes[0]).equals("+")) {
				c = 1;
			}
			else if ( o.substring(0,indexes[0]).equals("-")){
			    c = -1;
			}

			else {
				c = Integer.parseInt(o.substring(0,indexes[0]));
			}
			
		}
		
		else {
			//We are telling regex parse until get the index of a non 
			//digit caracter.Matching everything except digits and the 
			//signs + and - meaning matches only the literal part  
			indexes = regex("[^0-9^+-]",o);
			//System.out.println("TERM: "+o);
			if ( indexes[0] != -1 ){
				c = Integer.parseInt(o.substring(0,indexes[0]-1));

			}
			else{
				try {
					//On the case  one invalid character is at index 0 - lenTerm
					c = Integer.parseInt(o.substring(0,lenTerm));
				}
				catch(Exception ex) {
					throw new IllegalArgumentException("Error invalid Term(String) : "+o);
				}
				

			}
		
		}

		int indexExponent = o.indexOf("^");

		if ( indexExponent != -1 ){
			//Telling regex find a non-digit character to avoid parseInt
			//have a non-digit character. The next string is ok
			//-2x^23234erich
			//It will only regex the substring ^23234erich until char e
			//and parseInt will only have the 
			//substring 23234
			indexes = regex("[^0-9^+-]",o.substring(indexExponent,lenTerm));
			if ( indexes[0] != -1 ){
				e = Integer.parseInt(o.substring(indexExponent+1,indexes[0]));
			}
			else {
				e = Integer.parseInt(o.substring(indexExponent+1,lenTerm));

			}
			
		}
		else {
			indexes = regex("[a-zA-Z]{1,}",o);
			if ( indexes[0] == -1) {
				e = 0;
			}
			else {
				e = 1;
			}
		}
		coefficient = c;
		exponent = e;

		
		
	}
	/**
	 * Copy constructor
	 * @param o is other Term object
	 *
	 */
	public Term(Object o){

		if ( o == null ){
			throw new NullPointerException("Error: Term(Object) null");
		}
		if ( !(o instanceof Term) )
		{
			throw new ClassCastException("Error: not an instanceof Term");
		}
		Term t = (Term) o;
		setAll(t.getCoefficient(),t.getExponent());


	}

	/**
	 * Helping method to regex a pattern inside a string  
	 * @param string pattern to look up on matcher
	 * @param string matcher the text to use to look up some pattern
	 * @return int[] returns the indexes of the first group matching expression
	 * if not pattern is found the tuple contains -1.
	 *
	 */

	private int[] regex(String regex, String matcher){
		int[] tuple = new int[2];
		tuple[0] = -1;
		tuple[1] =-1;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(matcher);
		if ( m.find() ) {
			tuple[0] = m.start();
			tuple[1] = m.end();
		}

		return tuple;

	}


	/**
	 * sets the coefficient of the term
	 * @param int c is the coefficient of the term.
	 * 
	 */
	public void setCoefficient(int c) {
		this.coefficient = c;
		
	}

	/**
	 * sets the exponent of the Term object
	 * @param int e is the exponent of a term
	 */

	public void setExponent(int e) {
		this.exponent = e;
		
	}

	/**
	 * sets the coefficient and exponent of the term
	 * @param int c is the coefficient of the term.
	 * @param int e is the exponent of the term.
	 *
	 */
	public void setAll(int c, int e) {
		this.coefficient = c;
		this.exponent = e;
	}

	/**
	 * @return the coefficient of the term
	 */
	public int getCoefficient() {
		return coefficient;
	}

	/**
	 * @return the exponent of the term.
	 */
	public int getExponent() {
		return exponent;
	}
	
	@Override
	public boolean equals(Object o) {
		if ( o == null || !(o instanceof Term)) {
			return false;
		}
		Term t = (Term) o;
		return (coefficient == t.coefficient && exponent == t.exponent);
		
	}

	@Override
	public Object clone() {
		return new Term(coefficient,exponent);

	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if ( coefficient == 0) {
			sb.append("");
		}
		else if ( coefficient == 1 & exponent == 0) {
			sb.append("+");
			sb.append(coefficient);
		}
		else if ( coefficient != 1 & exponent == 0) {
			if ( coefficient > 0) {
				sb.append("+");
				
			}
			sb.append(coefficient);
			
		}
		else if ((coefficient == 1 | coefficient == -1 ) & exponent == 1) {
			if ( coefficient > 0 ) {
				sb.append("+");
			}
			else
			{
				sb.append("-");
			}
			sb.append("x");
			
		}
		else {
			if ( coefficient > 0 ) {
				sb.append("+");
			}
			if ( coefficient != 1 & coefficient != -1 ) {
				sb.append(coefficient);
			}
			if ( coefficient == -1) {
				sb.append("-");
			}
			sb.append("x");
			if ( exponent != 1) {
				sb.append("^");
				sb.append(exponent);
			}
		}


		return sb.toString();
	}

	@Override
	public int compareTo(Term otherTerm) {
		if ( otherTerm == null ){
			throw new NullPointerException("CompareTo(null) expected: Term");
		
		}
		
		return Integer.valueOf(exponent).compareTo(otherTerm.exponent);

	}

	
}
