package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class StringOperationsTest {

    StringOperation so = new StringOperation();

    @Test
    @Parameters(method = "getParamsForTest")
    public void testCompareStringArraysValidValues(int numToCompare, String[] firstArray, String[] secondArray, String[] expectedResult) {
        String[] result = so.compareStringArrays(numToCompare, firstArray, secondArray);
        assertArrayEquals(expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getIllegalParamsForTest")
    public void illegalTestCompareStringArrays(int numToCompare, String[] strArray1, String[] strArray2) {
        so.compareStringArrays(numToCompare, strArray1, strArray2);
    }

    private Object[] getParamsForTest() {
        String[] firstArray = {"cat", "elephant", "mouse", "donkey"};

        //2 matching elements in returned array
        String[] secondArray1 = {"cat", "cat", "mouse", "mouse"};
        String[] expectedResult1 = {"cat", "mouse"};

        //multiple element in second array, but still 2 matching element in returned array
        String[] secondArray2 = {"cat", "cat", "cat", "mouse", "mouse", "mouse"};
        String[] expectedResult2 = {"cat", "mouse"};

        //no element in returned array
        String[] secondArray3 = {"snake", "dog", "house", "bird"};
        String[] expectedResult3 = {};

        String[] secondArray4 = {"dog", "cat", "elephant", "donkey"};
        String[] expectedResult4 = {"cat", "elephant"};

        return new Object[] {
                new Object[] {4, firstArray, secondArray1, expectedResult1},
                new Object[] {4, firstArray, secondArray2, expectedResult2},
                new Object[] {4, firstArray, secondArray3, expectedResult3},
                new Object[] {2, firstArray, secondArray4, expectedResult4}

        };
    }

    private Object[] getIllegalParamsForTest() {
        String[] firstArray = {"cat", "elephant"};
        String[] secondArray = {"cat", "mouse", "dog", "snake"};

        return new Object[] {
                new  Object[] {3, firstArray, secondArray},
                new Object[] {3, secondArray, firstArray}
        };
    }
}
