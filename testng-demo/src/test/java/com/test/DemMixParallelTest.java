package com.test;

import com.util.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 混合多线程
 * 直接使用注解，发现并没有进行混合执行，则需要引入配制文件
 *
 * @author jinglv
 * @date 2023/4/20 14:16
 */
public class DemMixParallelTest {

    @Test(threadPoolSize = 2, invocationCount = 5)
    public void addTest() {
        int result = Calculator.add(4, 2);
        System.out.println("加法计算：" + result);
        Assert.assertEquals(6, result);
    }

    @Test(threadPoolSize = 2, invocationCount = 5)
    public void subTractTest() {
        int result = Calculator.subtract(4, 2);
        System.out.println("减法计算：" + result);
        Assert.assertEquals(2, result);
    }
}
