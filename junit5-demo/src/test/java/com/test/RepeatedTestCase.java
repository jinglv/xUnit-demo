package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author jingLv
 * @date 2020/10/22
 */
@DisplayName("重复测试")
public class RepeatedTestCase {

    @RepeatedTest(3)
    @DisplayName("重复测试三次")
    void repeatedTestOne() {
        System.out.println("执行测试...");
    }

    @RepeatedTest(value = 3, name = "{displayName}第{currentRepetition}次,一共执行了{totalRepetitions}次")
    @DisplayName("自定义名称重复测试")
    void repeatedTestTwo() {
        System.out.println("执行测试...");
    }
}
