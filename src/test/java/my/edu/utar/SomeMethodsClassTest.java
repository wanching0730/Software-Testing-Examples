package my.edu.utar;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeMethodsClassTest {
	
	@Test
	public void testAddSomeStrings() {
		SomeMethodsClass smc = new SomeMethodsClass();
		String [] arrayToTest = {"super", "ultra", "bat"};
		String newStr = "man";
		String [] expectedArray = {"superman", "ultraman", "batman"};
		
		smc.addSomeStrings(arrayToTest, newStr);
		assertArrayEquals(expectedArray, arrayToTest);
	}	

	@Test
	public void testCheckHumanAge() {
		SomeMethodsClass smc = new SomeMethodsClass();
		boolean result = smc.checkHumanAge(33);
		assertTrue("Age is in range, error in checking !",result);
		result = smc.checkHumanAge(-1);
		assertFalse("Age is not in range, error in checking !", result);
		result = smc.checkHumanAge(150);
	}

	@Test
	public void testGetAString() {
		SomeMethodsClass smc = new SomeMethodsClass();
		String [] arrayToTest = {"cat", "mouse", "dog", "house"};
		String result = smc.getAString(arrayToTest, 4);
		assertNotNull("Result should be mouse !", result);
		result = smc.getAString(arrayToTest, 15);
		assertNull("Result should be null !", result);
	}

	@Test
	public void testgetStringAtPos() {
		SomeMethodsClass smc = new SomeMethodsClass();
		String [] arrayToTest = new String[4];
		String myStr = "cat";
		arrayToTest[0] = "dog";
		arrayToTest[1] = myStr;
		arrayToTest[2] = "mouse";
		arrayToTest[3] = new String("cat");
		
		String result = smc.getStringAtPos(arrayToTest, 1);
		assertSame("myStr and element 1 should point to same object", myStr, result);
		
		// Although the String element at position 3 has the same 
		// literal value "cat" as the variable myStr, both the 
		// String element and myStr are pointing at different String 
		// objects and hence the assertNotSame returns true.
		result = smc.getStringAtPos(arrayToTest, 3);
		assertNotSame("myStr and element 3 do not point to same object", myStr, result);
	}
}
