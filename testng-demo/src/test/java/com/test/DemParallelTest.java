package com.test;

import com.util.Calculator;
import org.testng.annotations.Test;

/**
 * 并发测试
 *
 * @author jinglv
 * @date 2023/4/20 11:04
 */
public class DemParallelTest {

    @Test(threadPoolSize = 3, invocationCount = 10, timeOut = 6000)
    public void countTest() throws InterruptedException {
        int count = Calculator.count(1);
        System.out.println("计算加法结果为：" + count);
    }

    @Test(threadPoolSize = 3, invocationCount = 10, timeOut = 12000)
    public void countSynTest() throws InterruptedException {
        int count = Calculator.countSyn(1);
        System.out.println("计算加法结果为：" + count);
    }
}
