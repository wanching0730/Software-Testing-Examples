package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DiscountClassTest {

    DiscountClass dc = new DiscountClass();

    @Test
    @Parameters({"0,3.5", "1000,3.5", "1001,4.2", "4000,4.2", "4001,5.6", "9000,5.6"})
    public void testSetDiscountValidValues(int amountPurchase, double expectedDiscount) {
        dc.setDiscount(amountPurchase);
        assertEquals(expectedDiscount, dc.getDiscountOffer());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-100", "10000"})
    public void testSetDiscountInvalidValues(int amountPurchase) {
        dc.setDiscount(amountPurchase);
    }
}
