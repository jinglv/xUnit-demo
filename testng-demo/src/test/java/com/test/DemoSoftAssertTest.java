package com.test;

import com.util.Calculator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * 软断言
 *
 * @author jinglv
 * @date 2023/4/20 10:30
 */
public class DemoSoftAssertTest {

    @Test
    public void addTest() {
        SoftAssert softAssert = new SoftAssert();
        int result01 = Calculator.add(4, 2);
        System.out.println(result01);
        softAssert.assertEquals(result01, 5);

        int result02 = Calculator.add(4, 2);
        System.out.println(result02);
        softAssert.assertEquals(result02, 6);

        int result03 = Calculator.add(4, 2);
        System.out.println(result03);
        softAssert.assertEquals(result03, 7);

        int result04 = Calculator.add(4, 2);
        System.out.println(result04);
        softAssert.assertEquals(result04, 8);
        // 不要忘了这个
        softAssert.assertAll();
    }
}
