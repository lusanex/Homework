package edu.miracosta.cs113.lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab2JUnitTest {

	
	public void testPowerOfTwoMethod(){
		System.out.println("Checking the methods for Lab2 Class");
		Lab2 power2 = new Lab2();
		assertEquals(" power2.isPowerOfTwo(4) : OK",true,power2.isPowerOfTwo(4));
		assertEquals(" power2.isPowerOfTwo(2) : OK",true,power2.isPowerOfTwo(2));
		assertEquals(" power2.isPowerOfTwo(0) : False",false,power2.isPowerOfTwo(0));


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

		testPowerOfTwoMethod();
		//fail("Not yet implemented");
	}

}
