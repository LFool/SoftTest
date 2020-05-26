package com.lfool.test01;

/**
 * @ClassName: Commission
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/27 1:58
 * @Version: 1.0
 */
public class Commission {

    public static int commission(int lock, int stock, int barrel) {
        return salary(sellResult(lock, stock, barrel));
    }

    private static int sellResult(int lock, int stock, int barrel)
    {
        if (lock < 1 || stock < 1 || barrel < 1) {
            return 0;
        }
        if (lock > 70 || stock > 80 || barrel > 90) {
            return 0;
        }

        return lock * 45 + stock * 30 + barrel * 25;
    }
    private static int salary(int result)
    {
        int pay = 0;
        if (result < 100 || result > 7800) {
            return 0;
        }
        if (result > 1800) {
            pay = (result - 1800) * 20 / 100 + 100 + 120;
        } else if (result > 1000) {
            pay = (result - 1000) * 15 / 100 + 100;
        } else{
            pay = result * 10 / 100;
        }
        return pay;
    }

}
