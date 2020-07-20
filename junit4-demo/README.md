# JUnit4

[junit4 github](https://github.com/junit-team/junit4)

## 什么是Junit

- JUnit是Java编程语言的单元测试框架，用于编写和可重复运行的自动化测试

## JUnit特点

- JUnit是一个开放的资源框架，用于编写和运行测试
- 提供注解来识别测试方法
- 提供断言来测试预期结果
- JUnit测试允许你编写代码更快，并能提高质量
- JUnit优雅简洁。没那么复杂，花费时间较少
- JUnit测试可以自动运行并检查自身结果并提供及时反馈。所以也没有必要人工梳理测试结果的报告
- JUnit测试可以被组织为测试套件，包含测试用例，甚至其他的测试套件
- JUnit在一个条中显示进度。如果运行良好则是绿色；如果运行失败，则变成红色

## JUnit缺点

- 最初的设计，使用于单元测试，现在只用于各种测试。
- 不能依赖测试
- 配置控制欠佳(安装/拆卸)
- 侵入性(强制扩展类，并以某种方式命名方法)
- 静态编程模型(不必要的重新编译)
- 不适合管理复杂项目应用，JUnit复杂项目中测试非常棘手。

## JUnit注解

| 注解          | 解释                                                         |
| ------------- | ------------------------------------------------------------ |
| @Test         | 测试注解，标记一个方法可以作为一个测试用例                   |
| @Before       | Before注解表示，该方法必须在类中的每个测试用例之前执行，以便执行某些必要的先前条件 |
| @BeforeClass  | BeforeClass注解指出这是附着在静态方法(static void)必须执行一次并在类的所有测试之前。这种情况一般用于测试计算，共享配置方法（如数据库连接）。注意：方法必须为静态方法 |
| @After        | After注解表示。该方法在每项测试后执行（如执行每个测试后重置某些变量，删除临时变量等） |
| @AfterClass   | 当需要执行所有测试在JUnit测试用例类后执行。AfterClass注解可以使用已清理一些资源（如数据库连接）。注意：方法必须为静态方法(static void) |
| @Ignore       | 当想暂时禁用特定的测试执行可以使用这个注解。每个被注解为@Ignore的方法将不再执行 |
| @RunWith      | @RunWith就是放在测试类名之前，用来确定这个类怎么运行，也可以不注解，会使用默认运行器 |
| @Parameters   | 用于使用参数化功能                                           |
| @SuiteClasses | 用于套件功能                                                 |

## Junit断言
Assert类提供了一系列断言方法来帮助测试这判断程序的运行结果，该类位于junit.framework包中。

Assert类中主要的方法

| 方法          | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| assertNull(Object object) | 检查对象是否为空 |
| assertNotNull(Object object) | 检查对象是否不为空 |
| assertEquals(long expected, long actual) | 检查long类型的值是否相等 |
| assertEquals(double expected, double actual, double delta)| 检查指定精度的double值是否相等 |
| assertFalse(boolean condition) | 检查条件是否为假 |
| assertTrue(boolean condition) | 检查条件是否为真 |
| assertSame(Object expected, Object actual) | 检查两个变量是否引用同一对象 |
| assertNotSame(Object expected, Object actual) | 检查两个变量是否不引用同一对象 |

## 运行器RunWith
首先要分清几个概念：测试方法、测试类、测试集、测试运行器

- 其中测试方法就是用@Test注解的一些函数
- 测试类是包含一个或多个测试方法的一个**Test.java文件
- 测试集是一个suite，可能包含多个测试类
- 测试运行器则决定用了什么方式偏好去运行这些测试集/类/方法

### 常见运行器
@RunWith就是放在测试类名之前，用来确定这个类怎么运行的。也可以不标注，会使用默认运行器，常见的运行器有：

- @RunWith(Parameterized.class)参数化运行器，配合@Parameters使用JUnit的参数化功能
- @RunWith(Suite.class) @SuiteClasses({ATest.class,BTest.class,CTest.class})测试运行器配合使用测试集功能
- @RunWith(Junit4.class),junit4的默认运行器
- @RunWith(Junit38ClassRunner.class)，用于兼容junit3.8的运行器
- 一些其他运行器具备更多功能，例如：@RunWith(SpringJUnit4ClassRunner.class)集成了spring的一些功能
