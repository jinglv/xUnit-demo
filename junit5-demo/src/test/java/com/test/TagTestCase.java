package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author jingLv
 * @date 2020/10/21
 */
@DisplayName("分组测试")
public class TagTestCase {

    @Test
    @Tag("我们是红色")
    void testRedOne() {
        System.out.println("第一个红色...");
    }

    @Test
    @Tag("我们是红色")
    void testRedTwo() {
        System.out.println("第二个红色...");
    }

    @Test
    @Tag("我们是蓝色")
    void testBlueOne() {
        System.out.println("第一个蓝色...");
    }

    @Test
    @Tag("我们是蓝色")
    void testBlueTwo() {
        System.out.println("第二个蓝色...");
    }

    @Test
    @Tag("我们是蓝色")
    void testBlueThree() {
        System.out.println("第三个蓝色...");
    }
}
