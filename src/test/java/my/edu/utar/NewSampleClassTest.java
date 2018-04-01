package my.edu.utar;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public class NewSampleClassTest {

    @Test
    public void testSampleMethod() {
        DummyReaderClass drc = new DummyReaderClass(new int[] {1,2,3,4,5});
        DummyWriterClass dwc = new DummyWriterClass();
        NewSampleClass sampleClass = new NewSampleClass(drc, dwc);
        sampleClass.sampleMethod();
        assertArrayEquals(new int[] {1,2,3,4,5}, dwc.getIntList());
    }
}
