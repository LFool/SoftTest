package com.lfool.datagenerator;

import com.lfool.test02.Compute;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @ClassName: DataGenerator
 * @Description: TODO
 * @Author: LFool
 * @Date: 2020/5/27 17:04
 * @Version: 1.0
 */

public class DataGenerator {

    private int v1Min, v1Max;
    private int v2Min, v2Max;
    private int v3Min, v3Max;
    private String destDir;
    private Compute compute;

    private FileOutputStream fos = null;
    private OutputStreamWriter osw = null;
    private CSVFormat csvFormat = null;
    private CSVPrinter csvPrinter = null;

    /**
     * DataGenerator 构造函数
     * @param v1Min 第一个变量的最小值
     * @param v1Max 第一个变量的最大值
     * @param v2Min 第二个变量的最小值
     * @param v2Max 第二个变量的最大值
     * @param v3Min 第三个变量的最小值
     * @param v3Max 第三个变量的最大值
     * @param destDir 生成数据文件的目录位置
     * @param compute 抽象类对象
     */
    public DataGenerator(int v1Min, int v1Max, int v2Min, int v2Max,
                         int v3Min, int v3Max, String destDir, Compute compute) {
        this.v1Min = v1Min;
        this.v1Max = v1Max;
        this.v2Min = v2Min;
        this.v2Max = v2Max;
        this.v3Min = v3Min;
        this.v3Max = v3Max;
        this.destDir = destDir;
        this.compute = compute;
    }

    private void initCSVPrinter(String path) throws IOException {
        fos = new FileOutputStream(path);
        osw = new OutputStreamWriter(fos, "utf-8");
        csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "v1", "v2", "v3", "期望值");
        csvPrinter = new CSVPrinter(osw, csvFormat);
    }

    private void closeCSVPrinter() throws IOException {
        csvPrinter.flush();
        csvPrinter.close();
    }

    /**
     * 一般边界值测试：4n+1
     */
    public void test1NormalBoundaryValue() throws Exception // Parameters!
    {
        int[] arr1 = {v1Min, v1Min + 1, (v1Max + v1Min) / 2, v1Max - 1, v1Max};
        int[] arr2 = {v2Min, v2Min + 1, (v2Max + v2Min) / 2, v2Max - 1, v2Max};
        int[] arr3 = {v3Min, v3Min + 1, (v3Max + v3Min) / 2, v3Max - 1, v3Max};

        initCSVPrinter(destDir + "一般边界测试用例.csv");

        int num = 0;
        for (int v1 : arr1) {
            for (int v2 : arr2) {
                for (int v3 : arr3) {
                    if (v2 == (v2Max + v2Min) / 2 && v3 == (v3Max + v3Min) / 2
                            || v2 == (v2Max + v2Min) / 2 && v1 == (v1Max + v1Min) / 2
                            || v3 == (v3Max + v3Min) / 2 && v1 == (v1Max + v1Min) / 2) {
                        csvPrinter.printRecord(++num, v1, v2, v3, compute.compute(v1, v2, v3));
                    }
                }
            }
        }
        closeCSVPrinter();
    }

    /**
     * 最坏情况测试：6n+1
     */
    public void test2WorstCaseBoundaryValue() throws Exception // Parameters!
    {
        int[] arr1 = {v1Min - 1, v1Min, v1Min + 1, (v1Max + v1Min) / 2, v1Max - 1, v1Max, v1Max + 1};
        int[] arr2 = {v2Min - 1, v2Min, v2Min + 1, (v2Max + v2Min) / 2, v2Max - 1, v2Max, v2Max + 1};
        int[] arr3 = {v3Min - 1, v3Min, v3Min + 1, (v3Max + v3Min) / 2, v3Max - 1, v3Max, v3Max + 1};

        initCSVPrinter(destDir + "最坏情况测试用例.csv");

        int num = 0;
        for (int v1 : arr1) {
            for (int v2 : arr2) {
                for (int v3 : arr3) {
                    if (v2 == (v2Max + v2Min) / 2 && v3 == (v3Max + v3Min) / 2
                            || v2 == (v2Max + v2Min) / 2 && v1 == (v1Max + v1Min) / 2
                            || v3 == (v3Max + v3Min) / 2 && v1 == (v1Max + v1Min) / 2) {
                        csvPrinter.printRecord(++num, v1, v2, v3, compute.compute(v1, v2, v3));
                    }
                }
            }
        }
        closeCSVPrinter();
    }

    /**
     * 健壮性边界值测试5的n次方
     */
    public void test3RobustBoundaryValue() throws Exception // Parameters!
    {
        int[] arr1 = {v1Min, v1Min + 1, (v1Max + v1Min) / 2, v1Max - 1, v1Max};
        int[] arr2 = {v2Min, v2Min + 1, (v2Max + v2Min) / 2, v2Max - 1, v2Max};
        int[] arr3 = {v3Min, v3Min + 1, (v3Max + v3Min) / 2, v3Max - 1, v3Max};

        initCSVPrinter(destDir +"健壮测试用例.csv");

        int num = 0;
        for (int v1 : arr1) {
            for (int v2 : arr2) {
                for (int v3 : arr3) {
                    csvPrinter.printRecord(++num, v1, v2, v3, compute.compute(v1, v2, v3));
                }
            }
        }
        closeCSVPrinter();
    }

    /**
     * 健壮最坏情况测试7的n次方
     */
    public void test4RobustWorstCaseBoundaryValue() throws Exception // Parameters!
    {

        int[] arr1 = {v1Min - 1, v1Min, v1Min + 1, (v1Max + v1Min) / 2, v1Max - 1, v1Max, v1Max + 1};
        int[] arr2 = {v2Min - 1, v2Min, v2Min + 1, (v2Max + v2Min) / 2, v2Max - 1, v2Max, v2Max + 1};
        int[] arr3 = {v3Min - 1, v3Min, v3Min + 1, (v3Max + v3Min) / 2, v3Max - 1, v3Max, v3Max + 1};

        initCSVPrinter(destDir +"健壮性最坏情况测试用例.csv");

        int num = 0;
        for (int v1 : arr1) {
            for (int v2 : arr2) {
                for (int v3 : arr3) {
                    csvPrinter.printRecord(++num, v1, v2, v3, compute.compute(v1, v2, v3));
                }
            }
        }
        closeCSVPrinter();
    }

}
