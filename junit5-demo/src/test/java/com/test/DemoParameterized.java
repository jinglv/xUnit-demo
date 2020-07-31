package com.test;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 参数测试
 * <p>
 * - @ParameterizedTest 很实用的注解，需要junit-jupiter-params依赖
 *
 * @author jingLv
 * @date 2020-07-31 4:16 下午
 */
public class DemoParameterized {

    /**
     * 注入String内容
     *
     * @param value
     */
    @ParameterizedTest
    @ValueSource(strings = {"red", "green", "yellow"})
    void testForValueSource(String value) {
        System.out.println(value);
    }

    /**
     * 注入枚举类
     *
     * @param timeUnit
     */
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class)
    void testForEnumSourceAll(TimeUnit timeUnit) {
        System.out.println(timeUnit.toString());
    }

    /**
     * 注入枚举类,选择部分
     *
     * @param timeUnit
     */
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void testForEnumSource(TimeUnit timeUnit) {
        System.out.println(timeUnit.toString());
    }

    /**
     * 通过方法名注入,单个参数
     *
     * @param argument
     */
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        System.out.println(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    /**
     * 通过方法名注入,多个个参数
     *
     * @param str
     * @param num
     * @param list
     */
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        // 多参支持
        System.out.println(String.format("Content: %s is %d, %s", str, num, String.join(",", list)));
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    /**
     * csv源支持
     *
     * @param fruit
     * @param rank
     */
    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1"
    })
    void testWithCsvSource(String fruit, int rank) {
        System.out.println(fruit + ":" + rank);
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithArgumentsSource(String argument) {
        System.out.println(argument);
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("apple", "banana").map(Arguments::of);
        }
    }
}
