package com.test;

import org.testng.annotations.*;

/**
 * @author jingLv
 * @date 2020-06-30 5:16 下午
 */
public class Demo_Flow {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("This is BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("This is AfterSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is AfterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is AfterTest");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("This is AfterMethod");
    }

    @Test
    public void test1(){
        System.out.println("This is Test1");
    }

    @Test
    public void test2(){
        System.out.println("This is Test2");
    }
}
