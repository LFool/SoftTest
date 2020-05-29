package com.lfool.test06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/һ��߽��������.csv", numLinesToSkip = 1)
    void testNormalBoundary(int num, int a, int b, int c, String result) {
        assertEquals(result, Triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/������������.csv", numLinesToSkip = 1)
    void testWorstCaseBoundary(int num, int a, int b, int c, String result) {
        assertEquals(result, Triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/��׳��������.csv", numLinesToSkip = 1)
    void testRobustBoundary(int num, int a, int b, int c, String result) {
        assertEquals(result, Triangle.classify(a, b, c));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/��׳��������������.csv", numLinesToSkip = 1)
    void testRobustWorstCaseBoundary(int num, int a, int b, int c, String result) {
        assertEquals(result, Triangle.classify(a, b, c));
    }
}