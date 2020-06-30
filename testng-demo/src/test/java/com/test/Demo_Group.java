package com.test;

import org.testng.annotations.Test;

/**
 * @author jingLv
 * @date 2020-06-30 5:26 下午
 */
public class Demo_Group {
    @Test(groups = {"groups01"})
    public void putInA() {
        System.out.println("装入坚果A");
    }

    @Test(groups = {"groups01"})
    public void putInB() {
        System.out.println("装入坚果B");
    }

    @Test(groups = {"groups01", "groups02"})
    public void putInC() {
        System.out.println("装入坚果C");
    }

    @Test(groups = {"groups02"})
    public void putInD() {
        System.out.println("装入坚果D");
    }

    @Test(groups = {"groups02"})
    public void putInE() {
        System.out.println("装入坚果E");
    }
}
