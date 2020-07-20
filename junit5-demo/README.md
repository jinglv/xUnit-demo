# Junit5
[官方网站](https://junit.org/junit5/)
Junit5 由JUnit Platform + JUnit Jupiter + JUnit Vintage3部分构成，借用 IBM Developer 的一张图来说明 JUnit 5 的架构：
![image](./image/junit5架构.jpg)

[推荐JUnit5使用教程](https://blog.csdn.net/ryo1060732496/article/details/80792246)

### JUnit Platform:
其主要作用是在JVM上启动测试框架。它定义了一个抽象的TestEngine API来定义运行在平台上的测试框架；也就是说其他的自动化测试引擎或开发人员自己定制的引擎都可以接入Junit实现对接和执行。同时还支持通过命令行、Gradle和Maven来运行平台（这对于我们做自动化测试至关重要）。  
### JUnit Jupiter:
这是Junit5的核心，可以看作是承载Junit4原有功能的演进，包含了JUnit 5最新的编程模型和扩展机制；很多丰富的新特性使JUnit自动化测试更加方便、功能更加丰富和强大。也是测试需要重点学习的地方；Jupiter本身也是一个基于Junit Platform的引擎实现，对JUnit 5而言，JUnit Jupiter API只是另一个API！。
### JUnit Vintage:
Junit发展了10数年，Junit 3和 Junit 4都积累了大量的用户，作为新一代框架，这个模块是对JUnit3，JUnit4 版本兼容的测试引擎，使旧版本junit的自动化测试脚本也可以顺畅运行在Junit5下，它也可以看作是基于Junit Platform实现的引擎范例。

JUnit 5 对 Java 运行环境的最低要求是 Java 8。

## Junit5 的新特性
- 嵌套单元测试
- Lambda支持
- 参数化测试
- 重复测试
- 动态测试

### JUnit 4 与 JUnit 5 中的注解比较
|Junit5|JUnit4         |说明                 |
|-------|-------------|---------------------|
|@Test |@Test   |被注解的方法是一个测试方法 |
|@BeforeAll |@BeforeClass| 被注解的（静态）方法将在当前类中的所有@Test方法**前**执行一次 |
|@BeforeEach |@Before  | 被注解的方法将在当前类中的每个@Test方法**前**执行 |
|@AfterEach |@After| 被注解的方法将在当前类中的每个@Test方法**后**执行 |
|@AfterAll | @AfterClass| 被注解的（静态）方法将在当前类中的所有@Test方法**后**执行一次 |
|@Disabled | @Ignore| 被注解的方法不会执行（将被跳过），但会告知为已执行 |
|@TestFactory|NA|测试工厂进行动态测试。|
|@Nested|NA|嵌套测试。|
|@Tag|@Category|标记和过滤。|
|@ExtendWith|NA|注册自定义扩展。|

### Junit5注解
所有支持的注解都在包 org.junit.jupiter.api 下;

|注解|说明|
|---|---|
|@Test|表示方法是测试方法。与JUnit 4的@Test注释不同，这个注释不声明任何属性，因为JUnit Jupiter中的测试扩展基于它们自己的专用注释进行操作|
|@DisplayName|声明测试类或测试方法的自定义显示名称。|
|@ParameterizedTest|表示方法是参数化测试。|
|@TestFactory|表示方法是动态测试的测试工厂。|
|@TestInstance|用于为带注释的测试类配置测试实例生命周期。|
|@TestTemplate|表示方法是为测试用例设计的模板，根据注册提供程序返回的调用上下文的数量进行多次调用。|
|@BeforeEach|表示在当前类中每个@Test、@RepeatedTest、@ParameterizedTest或@TestFactory方法之前执行注释的方法；类似于JUnit 4的@Before。|
|@AfterEach|表示在当前类中的每个@Test、@RepeatedTest、@ParameterizedTest或@TestFactory方法之后，都应该执行带注释的方法；类似于JUnit 4的@After。|
|@BeforeAll|表示应在当前类中的所有@Test、@RepeatedTest、@ParameterizedTest和@TestFactory方法之前执行带注释的方法；类似于JUnit 4的@BeforeClass。|
|@AfterAll|表示在当前类中，所有@Test、@RepeatedTest、@ParameterizedTest和@TestFactory方法都应该执行注释的方法；类似于JUnit 4的@AfterClass。|
|@Disabled|用于禁用测试类或测试方法；类似于JUnit 4的@Ignore。|
|@Tag|用于在类或方法级别声明过滤测试的标记；类似于TestNG中的测试组或JUnit 4中的类别。|
|@RepeatedTest|表示方法是重复测试的测试模板。|
|@Nested|表示带注释的类是一个嵌套的、非静态的测试类。@BeforeAll和@AfterAll方法不能直接在 @Nested 测试类中使用，除非使用“每个类”测试实例生命周期。|
|@ExtendWith|用于注册自定义扩展。|

注意：

使用@Test、@TestTemplate、@RepeatedTest、@BeforeAll、@AfterAll、@BeforeEach或@AfterEach注释的方法不能返回值。

@Tag() 有以下这些语法规则
- 不能为null或者空字符串
- 不能有空格
- 不能包含ISO控制符
- 不能包含保留字符(`,`,`(`,`)`,`&`,`|`,`!`)

### Junit5断言（Assertions类）
JUnit Jupiter附带了许多JUnit 4拥有的断言方法，并添加了一些可以很好地用于Java 8 lambdas的断言方法。 

所有JUnit5断言都是 org.junit.jupiter.api.Assertions 中的静态方法断言类。

Asser类中主要方法如下：

|方法名称|方法描述|
|----|---|
|assertEquals|断言传入的预期值与实际值是相等的。|
|assertNotEquals|断言传入的预期值与实际值是不相等的。|
|assertArayEquals|断言传入的预期数组与实际数组是相等的。|
|assertNull|断言传入的对象是为空。|
|assertNotNull|断言传入的对象是不为空。|
|assertTrue|断言条件为真。|
|assertFalse|断言条件为假。|
|assertSame|断言两个对象引用同一个对象，相当于"==”。|
|assertNotSame|断言两个对象引用不同的对象，相当于"!=”。|
|assertThat|断言实际值是否满足指定的条件。|

## 生命周期
JUnit5 提供了4个生命周期注解 @BeforeAll @AfterAll @BeforeEach @AfterEach
- @BeforeAll：在所有的 @Test @RepeatedTest @ParameterizedTest @TestFactory 之前执行
- @BeforeEach：在每个测试用例前执行
- @AfterAll @AfterEach：与before类似，在测试用例之后执行

## 参数化
- @ValueSource
- @EnumSource
- @MethodSource
- @CsvSource
- @CsvFileSource
- @ArgumentsSource

## 动态测试用例
-  dynamicTest

# Allure
[官方文档](https://docs.qameta.io/allure/)