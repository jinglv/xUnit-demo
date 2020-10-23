package com.test;

import org.junit.jupiter.api.*;

/**
 * @author jingLv
 * @date 2020/10/21
 */
@DisplayName("初体验Junit5")
class FirstTestCase {

    @BeforeAll
    @DisplayName("初始化")
    static void init() {
        System.out.println("初始化...");
    }

    @AfterAll
    @DisplayName("已结束")
    static void clean() {
        System.out.println("已结束...");
    }

    @BeforeEach
    @DisplayName("测试方法开始")
    void tearUp() {
        System.out.println("测试方法开始...");
    }

    @AfterEach
    @DisplayName("测试方法结束")
    void tearDown() {
        System.out.println("测试方法结束...");
    }

    @Test
    @DisplayName("第一个测试用例")
    void testNumberOne() {
        System.out.println("第一个测试用例...");
    }

    @Test
    @DisplayName("第二个测试用例")
    void testNumberTwo() {
        System.out.println("第二个测试用例...");
    }

    @Test
    @DisplayName("第三个测试用例")
    @Disabled
    void testNumberThree() {
        System.out.println("第三个测试用例，我需要禁止...");
    }
}
