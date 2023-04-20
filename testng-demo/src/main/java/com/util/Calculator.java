package com.util;

/**
 * @author jinglv
 * @date 2023/4/19 14:24
 */
public class Calculator {

    public static int result;

    public static int count(int x) throws InterruptedException {
        int i = result;
        Thread.sleep(1000);
        result = i + x;
        return result;
    }

    public synchronized static int countSyn(int x) throws InterruptedException {
        int i = result;
        Thread.sleep(1000);
        result = i + x;
        return result;
    }

    public static int add(int x, int y) {
        result = x + y;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int subtract(int x, int y) {
        result = x - y;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static int multiply(int x, int y) {
        result = x * y;
        return result;
    }

    public static int divide(int x, int y) {
        result = x / y;
        return result;
    }
}
