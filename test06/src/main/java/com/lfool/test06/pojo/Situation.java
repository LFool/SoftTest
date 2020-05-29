package com.lfool.test06.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @Author: LFool
 * @Time: 2020/5/29 22:54
 */
public class Situation {
    boolean symptom;

    boolean contactHistory;

    public Situation(boolean symptom, boolean contactHistory) {
        this.symptom = symptom;
        this.contactHistory = contactHistory;
    }

    public boolean isSymptom() {
        return symptom;
    }

    public void setSymptom(boolean symptom) {
        this.symptom = symptom;
    }

    public boolean isContactHistory() {
        return contactHistory;
    }

    public void setContactHistory(boolean contactHistory) {
        this.contactHistory = contactHistory;
    }
}
