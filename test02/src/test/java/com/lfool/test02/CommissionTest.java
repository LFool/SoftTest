package com.lfool.test02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CommissionTest {

    private final Compute compute = new Commission();

    /**
     *
     * Method: classify(int a, int b, int c)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/commission/一般边界测试用例.csv", numLinesToSkip = 1)
    void testNormalBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/最坏情况测试用例.csv", numLinesToSkip = 1)
    void testWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/健壮测试用例.csv", numLinesToSkip = 1)
    void testRobustBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/commission/健壮性最坏情况测试用例.csv", numLinesToSkip = 1)
    void testRobustWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }


}