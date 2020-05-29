package com.lfool.test01;

import com.lfool.test01.Commission;
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
 * Commission Tester.
 *
 * @author <Authors name>
 * @since <pre>05/27/2020</pre>
 * @version 1.0
 */
@RunWith(Parameterized.class)
@AllArgsConstructor
public class CommissionTest {

    private int lock, stock, barrel;
    private int commission;

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
                        {  2,  2,  2, 20},
                        {  0,  2,  2,  0},
                        {  2,  0,  2,  0},
                        {  2,  2,  0,  0},
                        {  0,  0,  2,  0},
                        {  0,  2,  0,  0},
                        {  2,  0,  0,  0},
                        {  0,  0,  0,  0},
                        { 71,  2,  2,  0},
                        {  2, 81,  2,  0},
                        {  2,  2, 91,  0},
                        { 71, 81,  2,  0},
                        { 71,  2, 91,  0},
                        {  2, 81, 91,  0},
                        { 71, 81, 91,  0},
                });
    }

    /**
     *
     * Method: commission(int lock, int stock, int barrel)
     *
     */
    @Test
    public void testCommission() throws Exception {
        Assert.assertEquals(commission, Commission.commission(lock, stock, barrel));
    }

} 
