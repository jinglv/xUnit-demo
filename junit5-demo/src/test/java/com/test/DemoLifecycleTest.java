package com.test;

import org.junit.jupiter.api.*;

/**
 * JUnit5 提供了4个生命周期注解 @BeforeAll @AfterAll @BeforeEach @AfterEach
 * <p>
 * - @BeforeAll：在所有的 @Test @RepeatedTest @ParameterizedTest @TestFactory 之前执行
 * - @BeforeEach：在每个测试用例前执行
 * - @AfterAll @AfterEach：与before类似，在测试用例之后执行
 * <p>
 * - @TestInstance()配置，见上面的例子，这个存在两个模式
 * <p>
 * PER_METHOD：每个测试用例执行前，都会创建一个实例（默认，与junit4一致）
 * PER_CLASS：每个类的测试用例执行前，创建统一的实例
 *
 * @author jingLv
 * @date 2020-07-31 3:44 下午
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoLifecycleTest {
    int num = 0;

    @BeforeAll
    static void initAll() {
        System.out.println("initAll");
    }

    @BeforeEach
    void init() {
        System.out.println("init");
    }

    @Test
    @Order(1)
    void doTest1() {
        System.out.println("num is" + num);
        num = 1;
        System.out.println("doTest1");
    }

    @Test
    @Order(2)
    void doTest2() {
        System.out.println("num is" + num);
        num = 2;
        System.out.println("doTest2");
    }
}
