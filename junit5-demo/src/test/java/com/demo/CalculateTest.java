package com.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试类和测试方法都可以不设置为 public
 *
 * @author jingLv
 * @date 2020-07-20 4:48 下午
 */
class CalculateTest {

    private final int a = 10;
    private final int b = 20;
    private final Calculate calculate = new Calculate();

    @BeforeAll
    static void beforeAll() {
        System.out.println("计算器测试开始啦。。。");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("开始。。。");
    }

    @Test
    @DisplayName("加法")
    void add() {
        int result = calculate.add(a, b);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("减法")
    void subtract() {
        int result = calculate.subtract(b, a);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("乘法")
    void multiply() {
        int result = calculate.multiply(b, a);
        assertEquals(200, result);
    }

    @Test
    @DisplayName("除法")
    @Disabled("除法测试已禁用")
    void divide() {
        int result = calculate.divide(b, a);
        assertEquals(2, result);
    }

    @AfterEach
    void afterEach() {
        System.out.println("结束。。。");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("计算器测试结束啦。。。");
    }
}