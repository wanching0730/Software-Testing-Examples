package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TaxBoundaryTesting {

    PartitionExample pe = new PartitionExample();

    @Test
    @Parameters({"0,0", "20000,2000", "20001, 2000.15", "40000, 5000", "40001, 5000.2", "80000, 13000", "80001, 13000.3"})
    public void testCalculateTaxValidValues(int salary, double expectedTax){
        double tax = pe.calculateTax(salary);
        assertEquals(expectedTax, tax);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1"})
    public void testCalculateTaxInvalidValues(int salary) {
        pe.calculateTax(salary);
    }
}
