package com.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 * 并发测试
 *
 * @author jingLv
 * @date 2021/01/06
 */
class ParallelTest {

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void testMethodOne() {
        System.out.println(this.getClass() + "-testMethodOne-" + Thread.currentThread().getName());
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void testMethodTwo() {
        System.out.println(this.getClass() + "-testMethodTwo-" + Thread.currentThread().getName());
    }
}
