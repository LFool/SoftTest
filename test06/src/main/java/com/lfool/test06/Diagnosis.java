package com.lfool.test06;

import com.lfool.test06.pojo.Situation;

/**
 * @Description:
 * @Author: LFool
 * @Time: 2020/5/29 22:53
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
