package com.lfool.test08;

import com.lfool.test08.pojo.Situation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class DiagnosisTest {

    /**
     *
     * Method: judge(Symptom symptom)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/decisionTable.csv", numLinesToSkip = 1)
    public void testJudge(int num, boolean symptom, boolean contactHistory, int res) throws Exception {

        Situation situation = new Situation(symptom, contactHistory);

        assertEquals(res, new Diagnosis().judge(situation));
    }

}