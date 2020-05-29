package com.lfool.datagenerator;

import com.lfool.test02.Triangle;

/**
 * @ClassName: Main
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/27 18:25
 * @Version: 1.0
 */
public class DataGeneratorMain {
    public static void main(String[] args) throws Exception {

        DataGenerator dataGenerator =
                new DataGenerator(1, 100, 1, 100, 1, 100,
                        "src/test/resources/triangle/", new Triangle());
/*        DataGenerator dataGenerator =
                new DataGenerator(1, 12, 1, 31, 1812, 2012,
                        "src/test/resources/nextDate/", new NextDate());*/

/*        DataGenerator dataGenerator =
                new DataGenerator(1, 70, 1, 80, 1, 90,
                        "src/test/resources/commission/", new Commission());*/

        //生成一般边界测试数据
        dataGenerator.test1NormalBoundaryValue();

        //生成最坏情况边界测试数据
        dataGenerator.test2WorstCaseBoundaryValue();

        //生成健壮边界测试数据
        dataGenerator.test3RobustBoundaryValue();

        //生成健壮最坏情况测试用例
        dataGenerator.test4RobustWorstCaseBoundaryValue();
    }
}
