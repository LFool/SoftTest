package test.com.lfool.test02;

import com.lfool.test02.Compute;
import com.lfool.test02.NextDate;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/** 
* NextDate Tester. 
* 
* @author <Authors name> 
* @since <pre>05/27/2020</pre> 
* @version 1.0 
*/ 
public class NextDateTest {

    private Compute compute = new NextDate();

    /**
     *
     * Method: classify(int a, int b, int c)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/一般边界测试用例.csv", numLinesToSkip = 1)
    void testNormalBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/最坏情况测试用例.csv", numLinesToSkip = 1)
    void testWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/健壮测试用例.csv", numLinesToSkip = 1)
    void testRobustBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextDate/健壮性最坏情况测试用例.csv", numLinesToSkip = 1)
    void testRobustWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

} 
