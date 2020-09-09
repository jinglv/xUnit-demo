package com.test;

import com.demo.TimeUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jingLv
 * @date 2020/07/31
 */
@DisplayName("时间工具类测试")
public class DemoDisplayName {

    @Test
    @DisplayName("当前时间测试用例")
    void testCurrentTime() {
        Instant now = Instant.now();
        String expect = "当前时间是：" + now.toString();
        assertEquals(expect, TimeUtils.currentTime(now));
    }
}
