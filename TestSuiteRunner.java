import static org.junit.jupiter.api.Assertions.*;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestSuiteRunner extends TestSuite{

//    @Test
//    public void test1() {
//        TestSuite testSuite = new TestSuite();
////        testSuite.runTest(ScoreCardTes);
//    }

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestSuite(ScoreCardTest.class);
        testSuite.addTestSuite(DiceTest.class);
        testSuite.addTestSuite(HandTest.class);

        TestResult testResult = new TestResult();
        testSuite.run(testResult);

        System.out.println(testResult.wasSuccessful());

    }
}
