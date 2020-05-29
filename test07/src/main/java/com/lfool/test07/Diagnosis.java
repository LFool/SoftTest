package com.lfool.test07;

import com.lfool.test07.pojo.Situation;

/**
 * @Description:
 * @Author: LFool
 * @Time: 2020/5/30 0:29
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
