package edu.miracosta.cs113.lab4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import edu.miracosta.cs113.lab4.model.*;

public class DirectoryJUnitTest {

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
	public void test_add_change_and_delete_method() {
		ArrayList<DirectoryEntry> theDirectory = new ArrayList<>(
							            Arrays.asList(
									    new DirectoryEntry("Erich","12345"),
									    new DirectoryEntry("John 777","4325"),
									    new DirectoryEntry("Zelda","34567"),
									    new DirectoryEntry("Link","23456"),
									    new DirectoryEntry("Mario","23232"),
									    new DirectoryEntry("Luigui","345455")
									          )
								    );

		Directory d = new Directory(theDirectory);
		d.addOrChangeEntry("Zelda","1111");
		String newEntry = d.getContact(2).toString().replaceAll(" ","");
		assertEquals("addOrChangeEntry failed : ","(Zelda,1111)",newEntry);

		String oldEntry = d.addOrChangeEntry("Joda","4444");
		newEntry = d.getContact(theDirectory.size()-1).toString().replaceAll(" ", "");
		System.out.println(theDirectory);
		assertEquals("new entry add failed ",null,oldEntry);
		assertEquals("new enttry add failed ","(Joda,4444)",newEntry);
		DirectoryEntry old = d.removeEntry("Joda");
		assertFalse("remove entry failed: ",theDirectory.get(theDirectory.size()-1) == old);
		assertEquals("New size theContact failed : ", 6,theDirectory.size());
	}

}
