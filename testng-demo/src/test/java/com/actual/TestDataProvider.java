package com.actual;

import com.util.Calculator;
import com.util.FakerUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 数据驱动覆盖数据特性
 *
 * @author jingLv
 * @date 2020-07-20 5:41 下午
 */
public class TestDataProvider {

    @DataProvider(name = "testdata")
    public static Object[][] words() {
        return FakerUtils.getTestData("/src/main/resources/data/divide_params.csv");
    }

    @Test(threadPoolSize = 1, invocationCount = 1, dataProvider = "testdata")
    public void divTest(String x, String y) {
        int result = Calculator.divide(Integer.parseInt(x), Integer.parseInt(y));
        System.out.println(result);
    }
}
