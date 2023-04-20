package com.test;

import com.util.Calculator;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 混合并发测试
 * 原因是使用了共同的变量，加法和减法都使用result变量
 * 解决方法：每个方法设置内部变量，变量互不干扰
 *
 * @author jinglv
 * @date 2023/4/19 16:20
 */
public class MixParallelDemoTest {

    @RepeatedTest(10)
    void addTest() {
        int result = Calculator.add(4, 2);
        System.out.println(result);
        assertEquals(6, result);
    }

    @RepeatedTest(10)
    void subTractTest() {
        int result = Calculator.subtract(4, 2);
        System.out.println(result);
        assertEquals(2, result);
    }
}
