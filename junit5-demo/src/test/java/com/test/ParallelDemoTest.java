package com.test;

import com.util.Calculator;
import org.junit.jupiter.api.RepeatedTest;

/**
 * 并发测试案例，线程安全
 *
 * @author jinglv
 * @date 2023/4/19 14:52
 */
public class ParallelDemoTest {

    @RepeatedTest(10)
    void countTest() throws InterruptedException {
        int count = Calculator.count(1);
        System.out.println(count);
    }

    @RepeatedTest(10)
    void countSynTest() throws InterruptedException {
        int count = Calculator.countSyn(1);
        System.out.println(count);
    }
}
