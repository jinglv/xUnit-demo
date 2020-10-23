package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jingLv
 * @date 2020/10/22
 */
public class ThrowTestCase {

    public static void division(int a, int b) {
        try {
            int result = a / b;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("除数不能为0");
        }
    }

    @Nested
    @DisplayName("异常校验测试")
    class TestAssertThrows {
        @Test
        @DisplayName("验证抛出除0异常")
        void testAssertThrow() {
            //验证异常匹配并返回exception对象
            Throwable exception = assertThrows(ArithmeticException.class, () -> {
                //抛出除0异常
                division(5, 0);
            });

            //校验具体的异常信息
            assertEquals("除数不能为0", exception.getMessage());
        }

        @Test
        @DisplayName("验证未抛出除0异常 - 5/0")
        void testAssertDoesNotThrowFail() {
            //抛出异常，断言失败
            assertDoesNotThrow(() -> {
                division(5, 0);
            });
        }

        @Test
        @DisplayName("验证未抛出除0异常 - 4/2")
        void testAssertDoesNotThrowSuccess() {
            //未抛出异常，断言成功
            assertDoesNotThrow(() -> {
                division(4, 2);
            });
        }
    }

    @Nested
    @DisplayName("超时校验测试")
    class TestTimeout {
        @Test
        @DisplayName("验证方法执行未超时")
        void timeoutNotExceeded() {
            assertTimeout(ofMinutes(2), () -> {
                // 执行不超过2分钟的操作
            });
        }

        @Test
        @DisplayName("验证方法执行未超时，并验证执行返回结果")
        void timeoutNotExceededWithResult() {
            String actualResult = assertTimeout(ofMinutes(2), () -> {
                return "a result";
            });
            assertEquals("a result", actualResult);
        }

        @Test
        @DisplayName("验证调用的方法对象执行未超时，并验证方法执行结果")
        void timeoutNotExceededWithMethod() {
            String whoRU = assertTimeout(ofMinutes(2), ThrowTestCase::throwTest);
            assertEquals("Hello, Junit5", whoRU);
        }

        @Test
        @DisplayName("验证方法执行超时，等待方法执行完成")
        void timeoutExceeded() {
            assertTimeout(ofMillis(10), () -> {
                Thread.sleep(1000);
            });
        }

        @Test
        @DisplayName("验证方法执行超时，超时立即终止")
        void timeoutExceededWithPreemptiveTermination() {
            assertTimeoutPreemptively(ofMillis(10), () -> {
                Thread.sleep(1000);
            });
        }
    }

    private static String throwTest() {
        return "Hello, Junit5";
    }
}
