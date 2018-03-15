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
    @Parameters({"false,false,true,100.0,15", "false,true,false,100.0,10", "true,true,false,100.0,30", "true,false,true,100.0,20", "true,false,false,100.0,20",
            "false,true,true,100.0,0", "true,true,true,100.0,0", "false,false,false,100.0,0"})
    public void testProcessDiscountValidValues(boolean haveCoupun, boolean existAcc, boolean newAcc, double amountSpent,
                                               int expectedTotalDiscount) {
       customer.processDiscount(haveCoupun, existAcc, newAcc, amountSpent);
       assertEquals(expectedTotalDiscount, customer.getTotalDiscount());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"false,false,true,-1.0", "false,true,false,-1.0", "true,true,false,-1.0", "true,false,true,-1.0", "true,false,false,-1.0",
            "false,true,true,-100.0", "true,true,true,-100.0", "false,false,false,-100.0"})
    public void testProcessDiscountInvalidValues(boolean haveCounpun, boolean existAcc, boolean newAcc, double amountSpent) {
        customer.processDiscount(haveCounpun, existAcc, newAcc, amountSpent);
    }

}
