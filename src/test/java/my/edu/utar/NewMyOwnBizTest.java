package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NewMyOwnBizTest {

    public Object[] getParamsForTest(){
        return new Object[]{
                new Object[]{4999,10},
                new Object[]{5000,5},
                new Object[]{10000,5}
        };
    }

    @Test
    @Parameters(method = "getParamsForTest")
    public void TestDoPromotionValidValues(int quantity, int expectedDiscount) {
        DummySalesObject dso = new DummySalesObject(quantity);
        NewMyOwnBiz nmob = new NewMyOwnBiz(dso);
        nmob.doPromotion();
        assertEquals(expectedDiscount, dso.getDiscount());
    }
}
