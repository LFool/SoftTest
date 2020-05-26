package test.com.lfool.test01; 

import com.lfool.test01.Triangle;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Triangle Tester.
 *
 * @author <Authors name>
 * @since <pre>05/26/2020</pre>
 * @version 1.0
 */
@RunWith(Parameterized.class)
@AllArgsConstructor
public class TriangleTest {

    private int a, b, c;
    private String type;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(
                new Object[][] {
                        { 10, 20, 30, "Non triangle" },
                        { 2, 2, 2, "Equilateral triangle" },
                        { 0, 0, 0, "Non triangle" },
                        { 4, 3, 5, "Unequal triangle" },
                        { 3, 3, 4, "Isosceles triangle" },
                        { 4, 4, 5, "Isosceles triangle" },
                        { 1, 0, 0, "Non triangle" },
                        { 1, 1, 1, "Equilateral triangle" },
                });
    }

    /**
     *
     * Method: classify(int a, int b, int c)
     *
     */
    @Test
    public void testClassify() throws Exception {
        Assert.assertEquals(this.type, Triangle.classify(a, b, c));
    }


} 
