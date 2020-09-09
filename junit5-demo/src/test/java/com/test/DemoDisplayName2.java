package com.test;

import com.demo.TimeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 使用@DisplayNameGeneration()，进行更多的配置
 *
 * @author jingLv
 * @date 2020/07/31
 */
@DisplayNameGeneration(DemoDisplayName2.ReplaceUnderscores.class)
public class DemoDisplayName2 {

    @Test
    @DisplayName("当前时间测试用例")
    void testCurrentTime() {
        Instant now = Instant.now();
        String expect = "当前时间是：" + now.toString();
        assertEquals(expect, TimeUtils.currentTime(now));
    }

    static class ReplaceUnderscores extends DisplayNameGenerator.ReplaceUnderscores {
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return "哈哈哈";
        }
    }
}
