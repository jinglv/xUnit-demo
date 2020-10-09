package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * TestNG参数化测试
 * - 配置文件方式
 *
 * @author jingLv
 * @date 2020/10/09
 */
public class DemoParamTest {

    @Test
    @Parameters({"name", "age"})
    public void testParams(String name, String age) {
        System.out.println("My name is " + name + " and I'm " + age + " years old!");
    }
}
