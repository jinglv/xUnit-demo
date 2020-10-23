package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author jingLv
 * @date 2020/10/21
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@DisplayName("按照测试方法名的字母数字排序")
public class MethodAlphanumericTestCase {

    @Test
    @DisplayName("我是Z")
    void testZ() {
        System.out.println("我是Z...");
    }

    @Test
    @DisplayName("我是1")
    void test1() {
        System.out.println("我是1...");
    }

    @Test
    @DisplayName("我是A")
    void testA() {
        System.out.println("我是A...");
    }

    @Test
    @DisplayName("我是G")
    void testG() {
        System.out.println("我是G...");
    }

    @Test
    @DisplayName("我是3")
    void test3() {
        System.out.println("我是3...");
    }
}
