package com.lfool.test03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    /**
     *
     * Method: getBill(String startTime, String endTime)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    public void testGetBill(int num, String startTime, String endTime, String pay) throws Exception {
        assertEquals(pay, Bill.charge(startTime, endTime));
    }

}