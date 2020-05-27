package com.lfool.test02;

/**
 * @ClassName: Commission
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/27 14:46
 * @Version: 1.0
 */
public class Commission extends Compute {

    @Override
    public String compute(int v1, int v2, int v3) {
        return String.valueOf(salary(sellResult(v1, v2, v3)));
    }

    private int sellResult(int lock, int stock, int barrel)
    {
        if (lock < 1 || stock < 1 || barrel < 1) {
            return 0;
        }
        if (lock > 70 || stock > 80 || barrel > 90) {
            return 0;
        }

        return lock * 45 + stock * 30 + barrel * 25;
    }
    private double salary(int result)
    {
        double pay = 0;
        if (result < 100 || result > 7800) {
            return 0;
        }
        if (result > 1800) {
            pay = (result - 1800) * 20 / 100.0 + 100 + 120;
        } else if (result > 1000) {
            pay = (result - 1000) * 15 / 100.0 + 100;
        } else{
            pay = result * 10 / 100.0;
        }
        return pay;
    }


}
