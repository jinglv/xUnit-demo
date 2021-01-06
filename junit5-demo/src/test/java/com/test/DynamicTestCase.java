package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicTest.stream;

/**
 * 动态测试用例
 *
 * @author jingLv
 * @date 2020/07/03
 */
public class DynamicTestCase {

    @TestFactory
    @DisplayName("基础动态测试")
    Collection<DynamicTest> simpleDynamicTest() {
        return Collections.singleton(dynamicTest("simple dynamic test", () -> assertTrue(true)));
    }

    @TestFactory
    @DisplayName("DynamicTest 提供了一个静态方法 stream 来根据输入生成动态测试")
    public Stream<DynamicTest> streamDynamicTest() {
        return stream(
                Stream.of("Hello", "World").iterator(),
                (word) -> String.format("Test - %s", word),
                (word) -> assertTrue(word.length() > 4)
        );
    }
}
