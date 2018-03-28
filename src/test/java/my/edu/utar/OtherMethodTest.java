package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OtherMethodTest {

    OtherMethods om = new OtherMethods();

    @Test
    @Parameters(method = "CountWordsParams")
    public void testCountWordsInStringValidValues(String words, String strfind, int expectedResult) {
        int count = om.countWordInString(words, strfind);
        assertEquals(expectedResult, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWordsStringInvalidValuesV1() {
        om.countWordInString(null, "elephant");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountWordsStringInvalidValuesV2() {
        om.countWordInString("donkey", null);
    }


    @Test
    @Parameters(method = "LargestNumberParams")
    public void testLargestNumberValidValues(int[] numbers, int expectedResult) {
        int result = om.findLargestNumberInArray(numbers);
        assertEquals(expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLargestNumberInvalidValuesV1() {
        om.findLargestNumberInArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLargestNumberInvalidValuesV2() {
        om.findLargestNumberInArray(new int[0]);
    }


    @Test
    @Parameters(method = "getParamsForTestGetSubStringsValid")
    public void testGetSubStringsValid(String[] strArray, int[] strPos, String expectedResult) {
        String result = om.getSubStrings(strArray, strPos);
        assertEquals(expectedResult, result);
    }

    // There are two possible tests for null for either one of the arguments
    // We do not use parameterized tests as it is not possible to use NULL values
    // to parameters. Instead we write separate tests.
    @Test(expected=IllegalArgumentException.class)
    public void testGetSubStringsInvalidV1() {
        om.getSubStrings(null, new int[] {2,3});
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetSubStringsInvalidV2() {
        om.getSubStrings(new String[] {"dog", "cat"}, null);
    }


    public Object[] CountWordsParams() {
        return new Object[] {
                new Object[] {"cat dog cat", "cat", 2},
                new Object[] {"horse elephant mouse", "donkey", 0},
                new Object[] {"mouse mouse mouse", "mouse", 3},
                new Object[] {"", "rabbit", 0}
        };
    }

    public Object[] LargestNumberParams() {
        return new Object[] {
                new Object[] {new int[] {4,5,6,7}, 7},
                new Object[] {new int[]{3}, 3}
        };
    }

    public Object[] getParamsForTestGetSubStringsValid() {

        return new Object[] {
                new Object[] {new String[] {"cat dog mouse", "house fish",
                        "rendang satay curry mee laksa"},
                        new int[] {2, 0, 3}, "mouse house mee"},
                new Object[] {new String[] {"cat dog mouse", "house fish", "",
                        "rendang satay curry mee laksa"},
                        new int[] {2, 0, 2, 3}, "mouse house mee"},
                new Object[] {new String[] {"cat dog mouse", "house fish", "rendang satay" },
                        new int[] {2, 5, 1}, "mouse satay"},
                new Object[] {new String[] {"", "", "" }, new int[] {3, 5, 2}, "" },
                new Object[] {new String[] {}, new int[] {}, ""}
        };
    }
}
