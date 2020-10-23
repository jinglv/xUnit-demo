package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试HashMap功能
 *
 * @author jingLv
 * @date 2020/10/21
 */
@DisplayName("内嵌测试类")
class NestUnitTestCase {

    Map<String, Object> map;

    @Nested
    @DisplayName("新建Map")
    class GivenCreateNewMap {
        @BeforeEach
        void create() {
            map = new HashMap<>();
        }

        @Test
        @DisplayName("断言Map是否为空")
        void isEmpty() {
            assertTrue(map.isEmpty());
        }

        @Nested
        @DisplayName("添加元素到Map")
        class ThenAddMap {
            String key = "xiaohong";
            Object value = "123123";

            @BeforeEach
            void add() {
                map.put(key, value);
            }

            @Test
            @DisplayName("断言Map是否为空")
            void isEmpty() {
                assertFalse(map.isEmpty());
            }

            @Test
            @DisplayName("断言value得值是否是设置的值")
            void verifyValue() {
                assertEquals(value, map.get(key));
            }

            @Nested
            @DisplayName("删除Map中元素")
            class RemoveMap {
                @BeforeEach
                void remove() {
                    map.remove(key);
                }

                @Test
                @DisplayName("断言Map是否为空")
                void isEmpty() {
                    assertTrue(map.isEmpty());
                }

                @Test
                @DisplayName("断言Map是否为空")
                void verifyValue() {
                    assertNull(map.get(key));
                }
            }
        }
    }

}
