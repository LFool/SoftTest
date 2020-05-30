# 实验二


## The Triangle Problem



**[Source Code](./src/main/java/com/lfool/test02/Triangle.java)**

**[Test Code](./src/test/java/com/lfool/test02/TriangleTest.java)**

**[Test Data](./src/test/resources/triangle)**



## The NextDate Function



**[Source Code](./src/main/java/com/lfool/test02/NextDate.java)**

**[Test Code](./src/test/java/com/lfool/test02/NextDateTest.java)**

**[Test Data](./src/test/resources/nextDate)**



## The Commission Problem



**[Source Code](./src/main/java/com/lfool/test02/Commission.java)**

**[Test Code](./src/test/java/com/lfool/test02/CommissionTest.java)**

**[Test Data](./src/test/resources/commission)**



## The Result Of JaCoCo Coverage Test

**[Result Page](./target/result/index.html)**




## Data Generator

进行了代码重构，增加了一个抽象类，上述三个类均继承它，并实现了其中的方法。传入不同的参数，可生成不同的数据文件。

```java
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

DataGenerator dataGenerator =
    new DataGenerator(1, 70, 1, 80, 1, 90,
      "src/main/resources/commission/", new Commission());
```