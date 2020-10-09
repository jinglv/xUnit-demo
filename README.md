# xUnit系列测试框架学习

## xUnit是什么
xUnit 是一系列测试框架的统称，最开始来源于一个叫做 Smalltalk 的 SUnit 框架，现在各种面向对象的语言，如 Java、Python 的鼻祖就是 Smalltalk，后来这些语言都借助了 Sunit 框架的理念，有很多通用的规范和特征，也就统称为 xUnit。

### xUnit框架体系
- Java : JUnit、TestNG
- Python : UnitTest、PyTest

### xUnit 的共同特征
- Test Runner ：测试的运行器
- Test Case ：测试用例
- Test Fixtures : 测试夹具 / 治具，用来管理测试用例的执行
- Test Suites ：测试套件，用来编排测试用例
- Test Execution：测试执行，以何种顺序执行
- Test Result Formatter：测试结果，具备相同的格式，可被整合
- Assertions：断言

## 测试用例核心元素
- 测试用例名字：特定方法名
- 测试用例描述与标签：注解
- 测试用例的容器：类或者套件
- 测试过程与步骤
- 测试断言

## 断言
- Junit4 assert系列
- hamcrest系列

## 用例的执行顺序
- Junit4
    - Default取决于反射方法获得的列表，顺序固定
    - @FixMethodOrder(MethodSorters.JVM) 顺序可能变化（根据JVM版本不同会有变化）
    - @FixMethodOrder(MethodSorters.Name_ASCENDING) 按照名字排序
-TestNG，JUnit5：
    - 可以通过注解设置顺序Order
    
## 测试套件的执行顺序支持
![image-20201009131109902](https://gitee.com/JeanLv/study_image/raw/master///image-20201009131109902.png)
- JUnit4
    - @BeforeClass、@AfterClass
    - @Before、@After
- TestNG
    - @BeforeClass
    - @BeforeMethod
    - @BeforeGroup、@BeforeSuite
- JUnit5
    - @BeforeClass
    - @BeforeEach

## 继承关系下的执行流程
- 父类@BeforeClass
- 子类@BeforeClass
- @BeforeClass
- @Test
- @After
- 子类@AfterClass
- 父类@AfterClass

## 用例初始化执行顺序
- @BeforeClass setUpClass
    - @Before setUp
        - @Test test1()
    - @After tearDown
    - @Before setUp
        - Test test2()
    - @After tearDown
- @AfterClass tearDownClass

## App自动化测试用例管理
- 基类的@BeforeClass：配置读取、配置Capability，初始化driver、安装app
    - 继承的子类执行流程
    - @BeforeClass：启动app，进入特定的tab子功能页面
        - @Before：启动并进入特定界面
        - @Test：测试用例执行
        - @After：回退到入口
    - @AfterClass：关闭app
- 基类的@AfterClass：driver.quit

## 接口测试用例管理
- 基类的@BeforeClass：配置读取、接口api定义读取
    - 继承的子类执行流程
    - @BeforeClass：进入特定的子业务流程，清理数据
        - @Before：特定接口初始化
        - @Test：测试用例执行与断言
        - @After：辅助清理环境
    - @AfterClass：辅助清理环境
- 基类的@AfterClass：辅助清理环境

## 测试用例的流程设计
- 配置文件加载
- 数据驱动文件加载
- 尽量别在After*中保留太多逻辑
- 失败重试
- 并行、并发
- 测试报告自定义

## 参数化与数据驱动
### 参数化
不同的框架实现方式不同
### 数据驱动
- 数据来源：csv、yaml、xml、db、excel、json
- 读取数据源返回数组：
    - 基于schema：List<Class>
    - 纯数据：Array<Array<String, Object>>
- 利用参数化进行数据与变量的对应

### 数据格式的选择

|数据格式|优点         |缺点                 |
|-------|-------------|---------------------|
|Excel |生成数据方便   |二进制文件不利于版本管理 |
|CSV | 可使用Excel编辑| 表达多层及多类型数据有困难 |
|YAML |格式完备，可读性好   | 格式简单 |
|XML | 格式完备| 冗长负责 |
|JSON | 格式完备，可读性一般| 不能编写注解，格式死板 |


### 数据驱动逻辑
- 结构化数据驱动
    - 根据表格数据解释执行，Excel、YAML、XML
    - 将行为也数据化
- 高层抽象
    - ATDD：验收测试驱动开发，借助数据与DSL实现用例描述，代表作框架RobotFramework
    - BDD：行为驱动开发，基于自然语言描述用例，实现仍然基于传统的编程方式，代表作Cucumber

- 牺牲灵活性，无法大规模应用，维护成本较高