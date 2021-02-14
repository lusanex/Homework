
package edu.miracosta.cs113.lab3;

import com.jakewharton.fliptables.FlipTable;

public class CompareExpression {


	private int n;
	private int increment;
	private static int TOTAL_TIMES_TO_COMPARE = 100;
	private static int DEFAULT_INCREMENT = 10;
	public static final String[] headers =  { "Y1","COMPARISON", "Y2", "N"};
	public String[][] data;

	interface ExpressionY {
		public int y(int n);
	}



	/**
	 * @param int n number of times to compare the 
	 *  expressions 
	 *  y1 = 100 * n + 10
	 *  y2 = 5 * n * n + 2
	 */
	
	public CompareExpression(int n, int increment){
		this.n = n;
		this.increment = increment;
		int size = n / increment; 
		data = new String[size][4];

	}

	public CompareExpression(){
		this(TOTAL_TIMES_TO_COMPARE,DEFAULT_INCREMENT);
	}
	
	public int getN(){
		return n;
	}

	public void setN(int n){
		if ( n < 10 ){
			n = 10;
		}
		this.n = n;
	}

	public int getIncrement(){
		return increment;
	}

	public void setIncrement(int i){
		
		this.increment = i;
		if ( i < 1  ){
			this.increment = DEFAULT_INCREMENT;
		}
		
	}



	/**
	 * expression is any algebraic expression example:
	 * y1 = 100 * n + 10
	 * @param int n is the number to use on the expression
	 * @param ExpressionY interface with the algebraic expression
	 * @return int the value of the expression expanded 
	 */
	public int y1(int n, ExpressionY expression){
		return expression.y(n);
	}




	/**
	 * compares the expressions y1 and y2 for values up to
	 * n on increments of 10
	 * @param int increment is the value that index will increase until reaches
	 * n. n is set when the object is initialized. if a negative number is given
	 * the default increment is used.
	 */
	public void compareValues(int increment,ExpressionY y1 , ExpressionY y2) {
		if ( increment < 1 ){
			increment = this.increment;
			data = new String[n/increment][4];
		}
		else {
			data = new String[n/increment][4];
		}

		int indexRows = 0;
		int exp1 = -1;
		int exp2 = -1; 
		for ( int i = 0 ; i < n ; i = i + increment ){
			exp1 = y1(i,y1);
			exp2 = y1(i,y2);
			if ( exp1 == exp2){
				data[indexRows][0] = String.valueOf(exp1); 
				data[indexRows][1] = "=";
				data[indexRows][2] = String.valueOf(exp2);
				data[indexRows][3] = String.valueOf(i);
				indexRows++;

			}
			else if ( exp1 > exp2 ) {
				
				data[indexRows][0] = String.valueOf(exp1); 
				data[indexRows][1] = ">";
				data[indexRows][2] = String.valueOf(exp2);
				data[indexRows][3] = String.valueOf(i);
				indexRows++;
				
			}
			else{
				data[indexRows][0] = String.valueOf(exp1); 
				data[indexRows][1] = "<";
				data[indexRows][2] = String.valueOf(exp2);
				data[indexRows][3] = String.valueOf(i);
				indexRows++;
			}

		}

	       	System.out.println(FlipTable.of(headers, data));


	}
	
	
}
