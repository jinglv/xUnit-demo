package com.test;

import org.testng.annotations.Test;

/**
 * TestNG多线程测试
 * - 配置方式
 * - 注解方式
 *
 * @author jingLv
 * @date 2020-06-30 5:55 下午
 */
public class DemoMultithreadingTest {
    @Test
    public void putInA() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("装入坚果A");
    }

    @Test
    public void putInB() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("装入坚果B");
    }

    @Test(threadPoolSize = 5, invocationCount = 5, timeOut = 60000)
    public void putInC() throws InterruptedException {
        Thread.sleep(1000);
        long id = Thread.currentThread().getId();
        System.out.println("线程号：" + id + "==>装入坚果C");
    }

    @Test
    public void putInD() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("装入坚果D");
    }

    @Test
    public void putInE() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("装入坚果E");
    }
}
