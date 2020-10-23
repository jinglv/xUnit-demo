package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assumptions.*;

/**
 * @author jingLv
 * @date 2020/10/22
 */
@DisplayName("前置条件测试")
public class AssumptionsTestCase {

    private final String environment = "DEV";

    /**
     * assumeTrue 和 assumFalse 确保给定的条件为 true 或 false，不满足条件会使得测试执行终止
     */
    @Test
    @DisplayName("前置条件断言校验")
    void simpleAssume() {
        assumeTrue(Objects.equals(this.environment, "DEV"));
        assumeFalse(() -> Objects.equals(this.environment, "BETA"));
    }

    /**
     * assumingThat 的参数是表示条件的布尔值和对应的 Executable 接口的实现对象。只有条件满足时，Executable 对象才会被执行；当条件不满足时，测试执行并不会终止。
     */
    @Test
    @DisplayName("前置条件断言成功后执行")
    void assumeThenDo() {
        assumingThat(Objects.equals(this.environment, "DEV"), () -> System.out.println("In dev"));
    }

    @Test
    @DisplayName("前置条件断言失败后终止执行")
    void assumeThenFail() {
        assumingThat(Objects.equals(this.environment, "BETA"), () -> System.out.println("In dev"));
    }
}
