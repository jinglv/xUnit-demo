package com.test;

import org.testng.annotations.Test;

/**
 * TestNG指定顺序测试执行
 * TestNG默认执行顺序是以方法名称首字母
 * 参数priority指定的数字由小到大执行
 *
 * @author jingLv
 * @date 2020/10/09
 */
public class DemoOrderTest {

    @Test(priority = 3)
    public void testA() {
        System.out.println("This is test case A");
    }

    @Test(priority = 2)
    public void testB() {
        System.out.println("This is test case B");
    }

    @Test(priority = 1)
    public void testC() {
        System.out.println("This is test case C");
    }
}
