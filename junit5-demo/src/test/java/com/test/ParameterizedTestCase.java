package com.test;

import org.junit.jupiter.api.DisplayName;
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
 * @date 2020/07/31
 */
@DisplayName("参数化测试")
public class ParameterizedTestCase {

    /**
     * String参数源
     *
     * @param value 参数值
     */
    @ParameterizedTest
    @ValueSource(strings = {"red", "green", "yellow"})
    @DisplayName("String参数源参数化测试")
    void testValueSourceForString(String value) {
        System.out.println(value);
    }

    /**
     * int参数源
     *
     * @param num 参数值
     */
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    @DisplayName("Int参数源参数化测试")
    void testValueSourceForInt(int num) {
        System.out.println(num);
    }

    /**
     * double参数源
     *
     * @param num 参数值
     */
    @ParameterizedTest
    @ValueSource(doubles = {2.D, 4.D, 8.D})
    @DisplayName("double参数源参数化测试")
    void testValueSourceForDouble(double num) {
        System.out.println(num);
    }

    /**
     * Long参数源
     *
     * @param num 参数值
     */
    @ParameterizedTest
    @ValueSource(longs = {2L, 4L, 8L})
    @DisplayName("long参数源参数化测试")
    void testValueSourceForLong(long num) {
        System.out.println(num);
    }

    /**
     * 枚举类参数化测试
     *
     * @param timeUnit jdk自动的time枚举类
     */
    @ParameterizedTest(name = "[{index}]TimeUnit:{arguments}")
    @EnumSource(value = TimeUnit.class)
    @DisplayName("枚举类参数源参数化测试")
    void testForEnumSourceAll(TimeUnit timeUnit) {
        System.out.println(timeUnit.toString());
    }

    /**
     * 注入枚举类,选择部分
     *
     * @param timeUnit jdk自动的time枚举类
     */
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    @DisplayName("枚举类参数源指定枚举值参数化测试")
    void testForEnumSourceInclude(TimeUnit timeUnit) {
        System.out.println(timeUnit.toString());
    }

    /**
     * 注入枚举类,不包含
     *
     * @param timeUnit jdk自动的time枚举类
     */
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.EXCLUDE, names = {"DAYS", "HOURS"})
    @DisplayName("枚举类参数源不包含枚举值参数化测试")
    void testForEnumSourceExclude(TimeUnit timeUnit) {
        System.out.println(timeUnit.toString());
    }

    /**
     * 注入枚举类,正则匹配
     *
     * @param timeUnit jdk自动的time枚举类
     */
    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.MATCH_ALL, names = ".*SECONDS")
    @DisplayName("枚举类参数源正则匹配枚举值参数化测试")
    void testForEnumSourceMatch(TimeUnit timeUnit) {
        System.out.println(timeUnit.toString());
    }


    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    /**
     * 通过方法返回值,单个参数
     *
     * @param argument 方法中的参数
     */
    @ParameterizedTest
    @MethodSource("stringProvider")
    @DisplayName("方法返回值参数源单个参数")
    void testWithExplicitLocalMethodSource(String argument) {
        System.out.println(argument);
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    /**
     * 通过方法返回值参数元,多个参数
     *
     * @param str  参数列表第一个参数：string
     * @param num  参数列表第二个参数：int
     * @param list 参数列表第三个参数：list
     */
    @ParameterizedTest(name = "[{index} fruits name：{0} and number：{1} and list: {2}]")
    @MethodSource("stringIntAndListProvider")
    @DisplayName("方法返回值参数源多参数类型")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        // 多参支持
        System.out.printf("Content: %s is %d, %s%n", str, num, String.join(",", list));
    }


    /**
     * csv参数源，根据csv格式的形式，以逗号分隔
     *
     * @param fruit 水果名称
     * @param rank  水果等级
     */
    @ParameterizedTest(name = "[{index} fruits name：{0} and rank：{1}]")
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1"
    })
    @DisplayName("csv参数源参数化测试")
    void testWithCsvSource(String fruit, int rank) {
        System.out.println(fruit + ":" + rank);
    }

    /**
     * csv文件参数源，文件添加到resources下，注意：与测试类一致的相同路径
     *
     * @param fruit 水果名称
     * @param price 水果价格
     */
    @ParameterizedTest(name = "[{index} fruits name：{0} and price：{1}]")
    @CsvFileSource(resources = "csv/fruit.csv")
    @DisplayName("csv文件参数源参数化测试")
    void testWithCsvFileSource(String fruit, int price) {
        System.out.println(fruit + ":" + price);
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("apple", "banana", "lemon").map(Arguments::of);
        }
    }

    /**
     * 通过参数类参数源， 这里引用的类必须实现 ArgumentsProvider 接口
     *
     * @param argument 参数值
     */
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testWithArgumentsSource(String argument) {
        System.out.println(argument);
    }

}
