package my.edu.utar;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class BasicClassTest {

    BasicClass bc = new BasicClass();
    static ArrayList<String[]> linesRead;
    static Scanner inputStream;

    @BeforeClass
    public static void setupClass() {
        linesRead = new ArrayList<String[]>();
        String fileName = "values.txt";
        inputStream = null;
        System.out.println("Reading test values from file " + fileName + "\n");

        try{
            inputStream = new Scanner(new File(fileName));
        }catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        while(inputStream.hasNextLine()) {
            String singleLine = inputStream.nextLine();
            String[] tokens = singleLine.split(" ");
            linesRead.add(tokens);
        }
    }

    @AfterClass
    public static void endClass() {
        System.out.println("Closing input file");
        inputStream.close();
    }

    // executed before every test method starts
    @Before
    public void setupMethod(){
        System.out.println("initializing the list");
        bc.initializeList();
    }

    @Test
    public void testAddStringToListV1() {
        System.out.println("First version of testAddStringsToList");
        String[] inputStr = linesRead.get(0);
        String[] expectedResult = linesRead.get(1);
        bc.setStrLimit(3);
        bc.addStringsToList(inputStr);
        String[] result = bc.getArrayList();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testGetTotalStringLengthV1() {
        System.out.println("First version of testGetTotalStringLength");
        String[] inputStr = linesRead.get(0);
        String[] tempStr = linesRead.get(2);
        int expectedResult = tempStr[0].length();
        bc.setStrLimit(3);
        bc.addStringsToList(inputStr);
        int result = bc.getTotalStringLength();
        assertEquals(expectedResult, result);
    }
}
