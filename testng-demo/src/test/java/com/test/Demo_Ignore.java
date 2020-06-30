package com.test;

import org.testng.annotations.Test;

/**
 * @author jingLv
 * @date 2020-06-30 5:23 下午
 */
public class Demo_Ignore {
    @Test
    public void putInA() {
        System.out.println("装入坚果A");
    }

    @Test
    public void putInB() {
        System.out.println("装入坚果B");
    }

    @Test(enabled = false)
    public void putInC() {
        System.out.println("装入坚果C");
    }

    @Test(enabled = false)
    public void putInD() {
        System.out.println("装入坚果D");
    }
}
