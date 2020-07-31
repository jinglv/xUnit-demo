package com.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * 添加@TestMethodOrder(MethodOrderer.OrderAnnotation.class)与@Order()，定义测试用例的执行顺序
 *
 * @author jingLv
 * @date 2020-07-31 3:36 下午
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoOrder {

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    void nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(1)
    void validValues() {
        // perform assertions against valid values
    }
}
