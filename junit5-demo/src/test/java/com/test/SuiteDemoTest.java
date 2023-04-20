package com.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * 要引入junit-platform-runner的依赖包
 *
 * @author jinglv
 * @date 2023/4/17 14:57
 */
@RunWith(JUnitPlatform.class)
@SelectPackages({"com.packageA", "com.packageB"})
public class SuiteDemoTest {
}
