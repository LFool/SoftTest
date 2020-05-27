package test.com.lfool.test02;

import com.lfool.test02.Compute;
import com.lfool.test02.Triangle;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Triangle Tester.
 *
 * @author <Authors name>
 * @since <pre>05/27/2020</pre>
 * @version 1.0
 */
class TriangleTest {

    private Compute compute = new Triangle();

    /**
     *
     * Method: classify(int a, int b, int c)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/一般边界测试用例.csv", numLinesToSkip = 1)
    void testNormalBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/最坏情况测试用例.csv", numLinesToSkip = 1)
    void testWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/健壮测试用例.csv", numLinesToSkip = 1)
    void testRobustBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/健壮性最坏情况测试用例.csv", numLinesToSkip = 1)
    void testRobustWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assert.assertEquals(result, compute.compute(a, b, c));
    }


} 
