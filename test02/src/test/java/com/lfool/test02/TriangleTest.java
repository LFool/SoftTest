package com.lfool.test02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class TriangleTest {
    private final Compute compute = new Triangle();

    /**
     *
     * Method: classify(int a, int b, int c)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/一般边界测试用例.csv", numLinesToSkip = 1)
    void testNormalBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/最坏情况测试用例.csv", numLinesToSkip = 1)
    void testWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/健壮测试用例.csv", numLinesToSkip = 1)
    void testRobustBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/triangle/健壮性最坏情况测试用例.csv", numLinesToSkip = 1)
    void testRobustWorstCaseBoundary(int num, int a, int b, int c, String result) {
        Assertions.assertEquals(result, compute.compute(a, b, c));
    }
}