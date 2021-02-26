package edu.miracosta.cs113.DSPolynomial;
//import java.util.ArrayList;     // <- First assigment use ArrayList              
import java.util.LinkedList;
import java.util.List;

public class Polynomial {

	private List<Term> polynomial;
	private int numberOfTerms;
	private static final int DEFAULT_TERMS = 0;

	public Polynomial(Polynomial original) {

		if ( original == null ){
			throw new NullPointerException();
		}
		polynomial = new LinkedList<Term>();
		for ( int i = 0 ; i < original.getNumTerms();i++) {
			addTerm(original.getTerm(i));
			
		}
		numberOfTerms = original.numberOfTerms;
	}
	
	/**
	 * Default constructor 
	 * Creates an Polynomial object with an empty list
	 *
	 */
	public Polynomial() {
		polynomial = new LinkedList<Term>();
		numberOfTerms = DEFAULT_TERMS;
	}

	/**
	 * The method adds a Term to the ArraList<Term>;
	 * The method loops through the ArrayList and looks
	 * up in which index to insert the new term. 
	 * If other similar term (same exponent) is found on the way this is 
	 * added to it. The state of the object changes but the numberTerms 
	 * remains the same.
	 * example 
	 * 2x^3 + x^6 
	 * if we add 3x^6
	 * no term is added but the polynomial object changes its state to 
	 * 2x^3 + 4x^6
	 * @param term an Term object to add.
	 */
	public void addTerm(Term term) {
		if ( term == null ){
			throw new NullPointerException("Error: addTerm(Term) null");
		}

		int indexNewInsertion = -1;
		boolean sentinelIsEqual = false;
		
		if ( numberOfTerms == 0 ){
			polynomial.add(term);
			numberOfTerms++;
		}
		else{
			for ( int i = 0 ; i < numberOfTerms;i++ ){
			 	int compare = polynomial.get(i).compareTo(term);
				if( compare == -1 ) {
					indexNewInsertion = i;
					break;
				}
				else if ( compare == 0 ){
					indexNewInsertion = i;
					sentinelIsEqual = true;
					break;
				}
				
			}

			if ( indexNewInsertion == -1 ) {
				polynomial.add(term);
				numberOfTerms++;

			}
			else if ( sentinelIsEqual ){
				Term t1 = polynomial.get(indexNewInsertion);
				Term newTerm = add2Terms(t1,term);
				//System.out.println("newTErm : c: " + newTerm.getCoefficient() + " e : "+newTerm.getExponent());

				if ( newTerm.getCoefficient() == 0) {
					polynomial.remove(indexNewInsertion);
					numberOfTerms = numberOfTerms -1;
				}
				else {
					polynomial.set(indexNewInsertion,newTerm);
				}
				

			}
			else {
				polynomial.add(new Term());
				for ( int i =numberOfTerms; i > indexNewInsertion;i-- ){
					Term t = polynomial.get(i-1);
					polynomial.set(i,t);
				}
				polynomial.set(indexNewInsertion,term);
				numberOfTerms++;
			}
		}
		
	}

	/**
	 * Helping method to add a similar term to other. It only adds to similar terms
	 * (same exponent)
	 * @param Term Term1 first term to add
	 * @param Term Term2 second term to add;
	 * @return null if the addition is from differents terms (differen exponents).
	 */
	private Term add2Terms(Term term1, Term term2){
		Term newTerm = null;
		if ( term1.getExponent() == term2.getExponent() ){
			int newCoefficient = term1.getCoefficient() + term2.getCoefficient();
			newTerm = new Term(newCoefficient,term1.getExponent());	

		}
		return newTerm;

	}

	/**
	 * @return total number of the terms of the polynomial
	 * object
	 */
	public int getNumTerms() {
		return numberOfTerms;
	}


	/**
	 * Returns the term at index i
	 * if i is out of bounds of the array returns an exception.
	 * @return Term returns a term at index i
	 */
	public Term getTerm(int i) {
		if ( i < 0 || i > numberOfTerms ){
			throw new IndexOutOfBoundsException(i);
		}
		return new Term(polynomial.get(i));
	}


	/**
	 * add method adds a other Polynomial
	 * to the current Polynomial
	 * @param Polynomial poly other Polynomial 
	 *
	 */

	public void add(Polynomial poly) {

		if ( poly == null ){
			throw new NullPointerException();
		}

		for ( int i = 0 ; i < poly.getNumTerms();i++  ){
			this.addTerm(poly.getTerm(i));
		}

		
	}

	public void clear() {
		numberOfTerms = 0;
		polynomial.clear();
		
	}

	@Override
	public String toString(){
		if ( numberOfTerms == 0 ){
			return String.valueOf(numberOfTerms);
		}
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < numberOfTerms ;i++ ){
			sb.append(polynomial.get(i));
		}
		if ( sb.toString().substring(0,1).equals("-")) {
			return sb.toString();
		}
		else {

			return sb.toString().substring(1,sb.length());
			
		}
		
	}

}
