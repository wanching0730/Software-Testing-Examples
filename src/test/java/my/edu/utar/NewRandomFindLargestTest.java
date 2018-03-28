package my.edu.utar;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NewRandomFindLargestTest {

    @Test
    public void testFindLargestNumberIntRandomArrayOriginal() {
        NewRandomFindLargest nr = new NewRandomFindLargest();

        int result = nr.findLargestNumberInRandomArray(5,8);
        assertEquals(7, result);
    }

    @Test
    public void testFindLargestNumberIntRandomArrayDummy() {
        ArrayGeneratorClass dgc = new ArrayGeneratorClass(new int[] {1,2,3,4,5,6,7,8});
        NewRandomFindLargest nr2 = new NewRandomFindLargest(dgc);

        int result = nr2.findLargestNumberInRandomArray(5,8);
        assertEquals(5, result);
    }
}
