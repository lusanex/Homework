package edu.miracosta.cs113.lab4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class Lab4Test {


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
	public void replace_list_of_items() {
	
		ArrayList<String> aList = new ArrayList<>(Arrays.asList("apple","banana","orange",
									"kiwi","apple","banana",
									"lettuce"));

		Lab4.replace(aList,"banana","watermelon");
		String wm = aList.get(1).replaceAll(" ",""); // Remove white spaces.
		String wm2 = aList.get(5).replaceAll(" ","");
		assertEquals("water melon fails : " ,"watermelon",wm);
		assertEquals("waterm melon fails: ","watermelon",wm2);

		Lab4.replace(aList,"lettuce","pineapple");
		String lt = aList.get(aList.size()-1).replaceAll(" " ,"");
		assertEquals("pineapple test fails: ","pineapple",lt);


	}

	@Test
	public void test_delete_item_from_list(){
			
		ArrayList<String> aList = new ArrayList<>(Arrays.asList("apple","banana","orange",
									"kiwi","apple","banana",
									"lettuce"));

		int oldSize = aList.size();
		Lab4.delete(aList,"lettuce");
		int newSize = aList.size();
		assertEquals("delete method fails size: ",oldSize-1,newSize);
		Lab4.delete(aList,"potato");
		newSize = aList.size();
		assertEquals("delete method test failed aList has different size: ",oldSize-1,newSize);
		aList.clear();
		Lab4.delete(aList,"banana");
		assertEquals("delete method on empty list: ",0,aList.size());

	}

}
