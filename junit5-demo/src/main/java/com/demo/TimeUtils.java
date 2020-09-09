package com.demo;

import java.time.Instant;

/**
 * 时间工具类
 *
 * @author jingLv
 * @date 2020/07/31
 */
public class TimeUtils {
    public static String currentTime(Instant now) {
        return "当前时间是：" + now.toString();
    }
}
