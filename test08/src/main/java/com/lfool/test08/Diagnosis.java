package com.lfool.test08;

import com.lfool.test08.pojo.Situation;

/**
 * @Description:
 * @Author: LFool
 * @Time: 2020/5/30 0:29
 */
public class Diagnosis {

    public int judge(Situation situation){
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
