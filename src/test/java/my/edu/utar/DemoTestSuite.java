package my.edu.utar;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { BasicClassTest.class, CheckStudentTest.class,
        GradeBoundaryTesting.class, GradePartitioningTesting.class })
public class DemoTestSuite {
}
