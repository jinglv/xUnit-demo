package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * @author jingLv
 * @date 2020/07/03
 */
public class DemoAssertion {

    @Test
    void testAsserts() {
        assertEquals(1, 2, () -> "1要等于1");
    }

    @Test
    void testAssertAll() {
        assertAll("demo assertions",
                () -> assertEquals(2, 2),
                () -> assertEquals(1, 3)
        );
    }

    /**
     * 增加假设
     */
    @Test
    void testAssume() {
        assumingThat("DEV".equals(System.getenv("ENV")),
                () -> {
                    //如果不为true这里将不执行
                    assertEquals(1, 1);
                }
        );

        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
        // 如果不为true这里将不执行
    }
}
