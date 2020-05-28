package test.com.lfool.test03; 

import com.lfool.test03.Bill;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* Bill Tester. 
* 
* @author <Authors name> 
* @since <pre>05/28/2020</pre> 
* @version 1.0 
*/

public class BillTest {

    /**
     *
     * Method: getBill(String startTime, String endTime)
     *
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    public void testGetBill(int num, String startTime, String endTime, String pay) throws Exception {
        Assert.assertEquals(pay, Bill.charge(startTime, endTime));
    }



} 
