package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class GradeBoundaryTesting {

    PartitionExample pe = new PartitionExample();

    @Test
    @Parameters({"0,F", "50,F", "51,D", "60,D", "61,C", "70,C", "71,B", "80,B", "81,A", "100,A"})
    public void testGetGradeValidValues(int mark, String expectedGrade) {
        String grade = pe.getGrade(mark);
        assertEquals(expectedGrade, grade);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-1", "101"})
    public void testGetGradeInvalidValues(int mark) {
        pe.getGrade(mark);
    }
}
