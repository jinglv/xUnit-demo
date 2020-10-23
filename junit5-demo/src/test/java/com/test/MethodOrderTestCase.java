package com.test;

import org.junit.jupiter.api.*;

/**
 * @author jingLv
 * @date 2020/10/21
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTestCase {

    @Test
    @Order(3)
    @DisplayName("我是1")
    void test1() {
        System.out.println("我是1...");
    }

    @Test
    @Order(2)
    @DisplayName("我是2")
    void test2() {
        System.out.println("我是2...");
    }

    @Test
    @Order(1)
    @DisplayName("我是3")
    void test3() {
        System.out.println("我是3...");
    }
}
