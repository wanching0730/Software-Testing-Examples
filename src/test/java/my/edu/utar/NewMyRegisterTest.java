package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class NewMyRegisterTest {

    @Test
    @Parameters({"1997,false", "2015,true"})
    public void testBorrowBookDummy(int year, boolean expectedProceed) {
        DummyCheckOutObject co = new DummyCheckOutObject(year);
        NewMyRegister register = new NewMyRegister(co);
        register.borrowBook();
        assertEquals(expectedProceed, co.getProceed());
    }
}
