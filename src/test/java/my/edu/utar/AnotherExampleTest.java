package my.edu.utar;

import junitparams.Parameters;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AnotherExampleTest {

    AnotherExample ae = new AnotherExample();
    @Test
    @Parameters(method="CombineStringParam")
    public void testCombineStringsValidValues(String words, int x, String expectedResult) {
        String result = ae.combineStrings(words, x);
        assertEquals(expectedResult, result); }
    private Object[] CombineStringParam(){
        return new Object[]{
                new Object[]{"cat mouse horse",10,""}, //invalid partition test new Object[]{"",2,""}, //invalid partition test
                new Object[]{"cat dog horse",3,"horse"},
                new Object[]{"mouse house boat",4,"mouse house"},
                new Object[]{"cat dog",-5,"cat dog"}
        };
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCombineStringsInvalidValuesV1() {
        ae.combineStrings(null, 5);
    }
}
