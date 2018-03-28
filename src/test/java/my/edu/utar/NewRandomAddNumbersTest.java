package my.edu.utar;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NewRandomAddNumbersTest {

    @Test
    public void testAddTwoNumbersOriginal() {
        RandomNumberFunctionality original = new NewRandomGeneratorClass();
        NewRandomAddNumbers nrl = new NewRandomAddNumbers(original);

        int result = nrl.addTwoNumbers(3);
        assertEquals(5, result);
    }

    @Test
    public void testAddTwoNumbersDummy() {
        RandomNumberFunctionality dummy = new DummyRandomNumber(5);
        NewRandomAddNumbers nrl = new NewRandomAddNumbers(dummy);

        int result = nrl.addTwoNumbers(3);
        assertEquals(8, result);
    }
}
