package com.lfool.test01;

import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * NextDate Tester.
 *
 * @author <Authors name>
 * @since <pre>05/27/2020</pre>
 * @version 1.0
 */
@RunWith(Parameterized.class)
@AllArgsConstructor
public class NextDateTest {

    private int month, day, year;
    private String newDate;

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
                        { 6, 15, 2007, "6/16/2007" },
                        { 6, 30, 2007, "7/1/2007" },
                        { 6, 31, 2007, "Invalid Input Date" },
                        { 1, 15, 2007, "1/16/2007" },
                        { 1, 31, 2007, "2/1/2007" },
                        { 12, 15, 2007, "12/16/2007" },
                        { 12, 31, 2007, "1/1/2008" },
                        { 2, 15, 2007, "2/16/2007" },
                        { 2, 28, 2000, "2/29/2000" },
                        { 2, 28, 2007, "3/1/2007" },
                        { 2, 29, 2000, "3/1/2000" },
                        { 2, 29, 2007, "Invalid Input Date" },
                        { 2, 30, 2007, "Invalid Input Date" },

                });
    }

    /**
     *
     * Method: run(int month, int day, int year)
     *
     */
    @Test
    public void testRun() throws Exception {
        Assert.assertEquals(newDate, NextDate.run(month, day, year));
    }

} 
