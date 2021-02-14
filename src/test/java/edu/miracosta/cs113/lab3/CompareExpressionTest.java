package edu.miracosta.cs113.lab3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompareExpressionTest {

	private static CompareExpression.ExpressionY expression1 = a -> 100 * a + 10; 
	private static CompareExpression.ExpressionY expression2 = a -> 5 * a * a + 2; 
	
	
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
	public void getterAndSetterMethodsTest() {
		CompareExpression cm = new CompareExpression();
		cm.setN(200);
        assertEquals("Expected and actual n DON'T match", 200,cm.getN());
        cm.setIncrement(5);
        assertEquals("Expected and actual increment DONT match ",5,cm.getIncrement());
        cm.compareValues(20, expression1,expression2);

	}
	
	@Test
	public void test() {
		CompareExpression cm = new CompareExpression();
		

		cm.compareValues(-1,expression1,expression2);

	}

}
