package com.demo;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author jingLv
 * @date 2020-07-20 5:06 下午
 */
public class CalculateTest {

    private final int a = 10;
    private final int b = 20;
    private final Calculate calculate = new Calculate();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("计算器测试开始啦。。。");
    }

    @Before
    public void before() {
        System.out.println("开始。。。");
    }

    @Test
    public void add() {
        int result = calculate.add(a, b);
        assertEquals(30, result);
    }

    @Test
    public void subtract() {
        int result = calculate.subtract(b, a);
        assertEquals(10, result);
    }

    @Test
    public void multiply() {
        int result = calculate.multiply(a, b);
        assertEquals(200, result);
    }

    @Test
    public void divide() {
        int result = calculate.divide(b, 10);
        assertEquals(2, result);
    }

    @After
    public void after() {
        System.out.println("结束。。。");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("计算器测试结束啦。。。");
    }
}