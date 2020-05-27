package com.lfool.test02;

/**
 * @ClassName: Triangle
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/27 14:45
 * @Version: 1.0
 */
public class Triangle extends Compute {

    @Override
    public String compute(int v1, int v2, int v3) {
        if (!((v1 + v2 > v3) && (v1 + v3 > v2) && (v2 + v3 > v1))) {
            return "Not a triangle";
        } else if (v1 == v2 && v1 == v3 && v2 == v3) {
            return "Equilateral";
        } else if (v1 != v2 && v1 != v3 && v2 != v3) {
            return "Scalene";
        } else {
            return "Isosceles";
        }
    }
}

