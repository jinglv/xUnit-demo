package com.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 使用@DisplayNameGeneration()设置别名个性化测试
 *
 * @author jingLv
 * @date 2020/07/31
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class A_year_is_not_supported {

    @Test
    void if_it_is_zero() {
    }

    @DisplayName("闰年计算不支持负数")
    @ParameterizedTest(name = "For example, year {0} is not supported.")
    @ValueSource(ints = {-1, -4})
    void if_it_is_negative(int year) {
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class A_year_is_a_leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = " {0} 年是闰年.")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {
        }

    }

    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + ' ' + testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }

    /**
     * 以下是在官方示例基础上扩展出的另一个别名生成方法，来支持使用驼峰命名法的用例，将驼峰命名的用例方法用空格进行分隔。
     */
    @Nested
    @DisplayNameGeneration(ReplaceCamelCase.class)
    class ThisIsACamelTestCase {

        @Test
        void TodayIsHistory() {
            assertTrue(true);
        }

        @Test
        void TodayWillBeRemembered() {
            assertTrue(true);
        }

    }

    static class ReplaceCamelCase extends DisplayNameGenerator.Standard {
        public ReplaceCamelCase() {
        }

        public String generateDisplayNameForClass(Class<?> testClass) {
            return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
        }

        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
        }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return this.replaceCapitals(testMethod.getName());
        }

        private String replaceCapitals(String name) {
            name = name.replaceAll("([A-Z])", " $1");
            name = name.replaceAll("([0-9].)", " $1");
            return name;
        }
    }
}
