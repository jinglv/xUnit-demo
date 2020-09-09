package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jingLv
 * @date 2020/07/03
 */
public class DemoTest {
    @Test
    public void test1() {
        System.out.println(System.getenv("ENV"));
        assertEquals(1, 2);
    }
}
