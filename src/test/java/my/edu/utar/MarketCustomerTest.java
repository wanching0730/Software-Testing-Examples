package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MarketCustomerTest {

    MarketCustomer customer = new MarketCustomer(0,0,0);

    @Test
    @Parameters({"false,false,true,15", "false,true,false,10",
                "true,true,false,30", "true,false,true,20",
                "true,false,false,20", "false,false,false,0"})
    public void testProcessDiscountValidValues(boolean haveCoupun, boolean existAcc, boolean newAcc,
                                               int expectedTotalDiscount) {
       customer.processDiscount(haveCoupun, existAcc, newAcc);
       assertEquals(expectedTotalDiscount, customer.getTotalDiscount());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"false,true,true", "true,true,true"})
    public void testProcessDiscountInvalidValues(boolean haveCounpun, boolean existAcc, boolean newAcc) {
        customer.processDiscount(haveCounpun, existAcc, newAcc);
    }

}
