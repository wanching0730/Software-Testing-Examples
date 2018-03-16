package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class CheckStudentTest {

    CheckStudentClass student = new CheckStudentClass();

    @Test
    @Parameters(method = "getParamsForTest")
    public void testCheckForHighestMarksValidValues(int minMark, int numStudent, Student[] students, Student[] expectedResult) {
        Student[] result = student.checkForHighestMarks(minMark, numStudent, students);
        assertArrayEquals(expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidParamsForTest")
    public void testCheckForHighestMarksInvalidValues(int minMark, int numStudent, Student[] students) {
        Student[] result = student.checkForHighestMarks(minMark, numStudent, students);
    }

    private Object[] getParamsForTest() {

        // return 2 results
        Student[] studArray1 = {new Student("Peter", 60), new Student("James", 50), new Student("Johny", 60),
            new Student("Kelly", 40)};
        Student [] expectedResult1 = {new Student("Peter", 60), new Student("Johny", 60)};

        // return only 1 result
        Student[] studArray2 = {new Student("Peter", 60), new Student("James", 50), new Student("Johny", 40),
                new Student("Kelly", 40)};
        Student [] expectedResult2 = {new Student("Peter", 60)};

        // the marks higher than min marks, return nothing
        Student[] studArray3 = {new Student("Peter", 60), new Student("James", 50), new Student("Johny", 40),
                new Student("Kelly", 40)};
        Student [] expectedResult3 = new Student[0];

        // only return 1 result, although got 2 highest mark because oni check for first 2 students
        // the marks higher than min marks, return nothing
        Student[] studArray4 = {new Student("Peter", 60), new Student("James", 50), new Student("Johny", 40),
                new Student("Kelly", 40)};
        Student [] expectedResult4 = {new Student("Peter", 60)};

        // return 0 result, because no student pass for checking
        Student[] studArray5 = {new Student("Peter", 60), new Student("James", 50), new Student("Johny", 40),
                new Student("Kelly", 40)};
        Student [] expectedResult5 = new Student[0];

        return new Object[] {
                new Object[] {20, 4, studArray1, expectedResult1},
                new Object[] {20, 4, studArray2, expectedResult2},
                new Object[] {80, 4, studArray3, expectedResult3},
                new Object[] {20, 2, studArray4, expectedResult4},
                new Object[] {20, 0, studArray5, expectedResult5}
        };

    }

    public Object[] getInvalidParamsForTest() {

        Student[] studArray1 = {new Student("Peter", -10), new Student("John", -50)};
        Student[] studArray2 = {new Student("Peter", 30), new Student("John", 50)};
        Student[] studArray3 = null;

        return new Object[] {
                new Object[] {20, 2, studArray1},
                new Object[] {-20, 2, studArray2},
                new Object[] {20, 2, studArray3}
        };
    }
}
