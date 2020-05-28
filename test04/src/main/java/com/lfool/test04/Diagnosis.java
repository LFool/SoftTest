package com.lfool.test04;

import com.lfool.test04.pojo.Situation;

/**
 * @ClassName: Diagnosis
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/28 22:25
 * @Version: 1.0
 */
public class Diagnosis {

    public static int judge(Situation situation){
        if(situation.isSymptom()){
            if(situation.isContactHistory()){
                return 1;
            }
            else {
                return 2;
            }
        } else {
            if(situation.isContactHistory()){
                return 3;
            }
            else {
                return 4;
            }
        }
    }

}
