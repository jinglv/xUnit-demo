package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jingLv
 * @date 2020-07-03 5:05 下午
 */
public class Demo_Assertion {

    @Test
    void testAssertAll() {
        assertAll("demo assertions",
                () -> assertEquals(2, 2),
                () -> assertEquals(1,3)
        );
    }
}
