package edu.miracosta.cs113.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab1JUnitTest {

	
	public void testMethodsLab1(){

		Lab1 multiple = new Lab1(); 
		System.out.println("Testing methods from Lab1 class...\n");
		System.out.println("Checking isNumberMultipleOfN(1,5)");
		assertEquals(multiple.isNumberMultipleOfN(1,5),false);
		System.out.println("Checking isNumberMultipleOfN(5,5)");
		assertEquals(multiple.isNumberMultipleOfN(5,5),true);
		System.out.println("isNumberMultipleOfNs(15,5,13)");
		assertEquals(multiple.isNumberMultipleOfNs(15,3,5), true);
		System.out.println("isNumberMultipleOfNs(15,3,5,2)");
		assertEquals(multiple.isNumberMultipleOfNs(15, 3,5,2), false);
		
		System.out.println("isNumberMultipleofNs(15,1)");
		assertEquals(multiple.isNumberMultipleOfNs(15,1),true);
	}

	public void runTest(int num){
		Lab1 multiple = new Lab1(); 
		int MAX_NUMBER_TO_CHECK = num;
		System.out.println("\nThis program prints the numbers from 1 to 100, but for multiples of 3 prints “Fizz” instead of the number and for multiples of 5 print “Buzz”. For numbers that are multiples of both three and five print “FizzBuzz”.\n");

		for ( int i = 1 ; i < MAX_NUMBER_TO_CHECK + 1; i++ ){

			if ( multiple.isNumberMultipleOfNs(i,3,5) ){
				System.out.print(Lab1.MULTIPLE_OF_3_AND_5);
				System.out.print(", ");
				continue;
			}
		    else if ( multiple.isNumberMultipleOfN(i,5) ){
				System.out.print(Lab1.MULTIPLE_OF_FIVE);
			}
			else if ( multiple.isNumberMultipleOfN(i,3) ){
				System.out.print(Lab1.MULTIPLE_OF_THREE);
			}
			
			else {
				System.out.print(i);
			}
			System.out.print(", ");
			
		}
		
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		testMethodsLab1();
		runTest(100);
		//fail("Not yet implemented");
	}

}
