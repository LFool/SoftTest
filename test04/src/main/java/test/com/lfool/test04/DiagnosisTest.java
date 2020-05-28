package test.com.lfool.test04;

import com.lfool.test04.Diagnosis;
import com.lfool.test04.pojo.Situation;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/** 
* Diagnosis Tester. 
* 
* @author <Authors name> 
* @since <pre>05/28/2020</pre> 
* @version 1.0 
*/ 
public class DiagnosisTest {


    /**
     *
     * Method: judge(Symptom symptom)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/decisionTable.csv", numLinesToSkip = 1)
    public void testJudge(int num, boolean symptom, boolean contactHistory, int res) throws Exception {

        Situation situation = new Situation(symptom, contactHistory);

        Assert.assertEquals(res, Diagnosis.judge(situation));
    }


} 
