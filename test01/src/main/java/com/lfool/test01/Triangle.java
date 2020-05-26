package com.lfool.test01;

/**
 * @ClassName: Triangle
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/26 21:18
 * @Version: 1.0
 */
public class Triangle {

    public static String classify(int a, int b, int c) {

        if (!((a + b > c) && (a + c > b) && (b + c > a))) {
            return "Non triangle";
        } else if (a == b && a == c && b == c) {
            return "Equilateral triangle";
        } else if (a != b && a != c && b != c) {
            return "Unequal triangle";
        } else {
            return "Isosceles triangle";
        }
    }

}
