package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TestNG依赖测试
 * - dependsOnMethods
 *
 * @author jingLv
 * @date 2020-06-30 5:46 下午
 */
public class DemoDependenciesTest {
    @Test
    public void putInA() {
        System.out.println("装入坚果A");
        Assert.fail("发生错误了");
    }

    @Test(dependsOnMethods = {"putInA"})
    public void putInB() {
        System.out.println("装入坚果B");
    }

    @Test(dependsOnMethods = {"putInB"})
    public void putInC() {
        System.out.println("装入坚果C");
    }

    @Test(dependsOnMethods = {"putInC"})
    public void putInD() {
        System.out.println("装入坚果D");
    }

    @Test(dependsOnMethods = {"putInD"})
    public void putInE() {
        System.out.println("装入坚果E");
    }
}
