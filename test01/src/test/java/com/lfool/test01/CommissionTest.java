package com.lfool.test01;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@AllArgsConstructor
public class CommissionTest {

    private int lock;
    private int stock;
    private int barrel;
    private int commission;

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
        assertEquals(commission, Commission.commission(lock, stock, barrel), 0.01);
    }

}