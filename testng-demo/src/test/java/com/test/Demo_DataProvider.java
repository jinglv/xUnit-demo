package com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author jingLv
 * @date 2020-06-30 6:00 下午
 */
public class Demo_DataProvider {

    @DataProvider(name = "putInList")
    public Object[][] putInList() {
        Object[][] objects;
        return objects = new Object[][]{
                {"包裹1", 1, 0, 1, 1, 1},
                {"包裹2", 0, 0, 1, 1, 0},
                {"包裹3", 1, 1, 1, 1, 1},
        };
    }

    @Test(dataProvider = "putInList")
    public void putIn(String pakageName, int aNum, int bNum, int cNum, int dNum, int eNum) throws InterruptedException {
        System.out.println("A 操作：" + pakageName + " 装入坚果A" + aNum + " 个！");
        Thread.sleep(1000);
        System.out.println("B 操作：" + pakageName + " 装入坚果A" + bNum + " 个！");
        Thread.sleep(1000);
        System.out.println("C 操作：" + pakageName + " 装入坚果A" + cNum + " 个！");
        Thread.sleep(1000);
        System.out.println("D 操作：" + pakageName + " 装入坚果A" + dNum + " 个！");
        Thread.sleep(1000);
        System.out.println("E 操作：" + pakageName + " 装入坚果A" + eNum + " 个！");
        Thread.sleep(1000);
    }
}
