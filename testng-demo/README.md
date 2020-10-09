# TestNG
[TestNG官方文档](https://testng.org/doc/index.html)

## 什么是TestNG

**TestNG**是一个测试框架，其灵感来自JUnit和NUnit，但引入了一些新的功能，使其功能更强大，使用更方便。

TestNG是一个**开源自动化测试框架**;TestNG表示**下一代**(**N**ext **G**eneration的首字母)。 TestNG类似于JUnit(特别是JUnit 4)，但它不是JUnit框架的扩展。它的灵感来源于JUnit。它的目的是优于JUnit，尤其是在用于测试集成多类时。 TestNG的创始人是**Cedric Beust**(塞德里克·博伊斯特)。

TestNG消除了大部分的旧框架的限制，使开发人员能够编写更加**灵活**和**强大**的**测试**。 因为它在很大程度上借鉴了Java注解(JDK5.0引入的)来定义测试，它也可以显示如何使用这个新功能在真实的Java语言生产环境中。

## TestNG特点

- 注解
- TestNG使用Java和面向对象的功能
- 支持综合类测试(例如，默认情况下，不用创建一个新的测试每个测试方法的类的实例)
- 独立的编译时测试代码和运行时配置/数据信息
- 灵活的运行时配置
- 主要介绍“测试组”。当编译测试，只要要求`TestNG`运行所有的“前端”的测试，或“快”，“慢”，“数据库”等
- 支持依赖测试方法，并行测试，负载测试，局部故障
- 灵活的插件API
- 支持多线程测试

## TestNG注解

| 注解          | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| @BeforeSuite  | 在该套件的所有测试都运行在注释的方法之前，仅运行一次。       |
| @AfterSuite   | 在该套件的所有测试都运行在注释方法之后，仅运行一次。         |
| @BeforeClass  | 在调用当前类的第一个测试方法之前运行，注释方法仅运行一次。   |
| @AfterClass   | 在调用当前类的第一个测试方法之后运行，注释方法仅运行一次     |
| @BeforeTest   | 注释的方法将在属于@Test注解的类的所有测试方法运行之前运行。  |
| @AfterTest    | 注释的方法将在属于@Test注解的类的所有测试方法运行之后运行。  |
| @BeforeGroups | 配置方法将在之前运行组列表。 此方法保证在调用属于这些组中的任何一个的第一个测试方法之前不久运行。 |
| @AfterGroups  | 此配置方法将在之后运行组列表。该方法保证在调用属于任何这些组的最后一个测试方法之后不久运行。 |
| @BeforeMethod | 注释方法将在每个测试方法之前运行。                           |
| @AfterMethod  | 注释方法将在每个测试方法之后运行。                           |
| @DataProvider | 标记一种方法来提供测试方法的数据。 注释方法必须返回一个`Object[][]`，其中每个Object[]可以被分配给测试方法的参数列表。 要从该DataProvider接收数据的@Test方法需要使用与此注释名称相等的dataProvider名称。 |
| @Factory      | 将一个方法标记为工厂，返回TestNG将被用作测试类的对象。 该方法必须返回Object [] |
| @Listeners    | 定义测试类上的侦听器。                                       |
| @Parameters   | 描述如何将参数传递给`@Test`方法。                            |
| @Test         | 将类或方法标记为测试的一部分。                               |

### TestNG执行流程
![image-20201009130614443](https://gitee.com/JeanLv/study_image/raw/master///image-20201009130614443.png)

### TestNG忽略测试
有时候我们只想运行部分测试用例，在这种情况下，@Test(enabled=fasle)有助于禁用某些测试用例。被标注的测试用例将不会被执行，此参数默认值为true。

### TestNG组控制问题
在TestNG中，组groups的概念主要是相对于测试方法而言的，即，将具有相似功能的测试方法分组，这样在定义测试用例的时候就可以以组为单位加入对应的测试方法。一个测试方法可以属于组，也可以属于多个组。

### TestNG依赖控制
通过dependsOnMethods声明被依赖方法，该方法将在被依赖方法成功执行后，才会执行，假如被依赖方法执行失败，则该方法会被跳过

### TestNG多线程
测试方法是通过在@Test注解中配置threadPoolSize这个属性来进入多线程模式的。

|属性|描述|
|---|----|
|invocationCount|表示执行的次数|
|threadPoolSize|表示线程池的内线程的个数|
|timeOut|超时时间-毫秒|


threadPoolSize被设为3，这就说明了该测试方法将会在三个不同的线程中同时执行；invocationCount配置的是该测试方法应被执行的总次数；timeOut配置的是每次执行该测试方法所耗费时间，超过则测试失败

### TestNG参数化
需要传递复杂参数，或者参数需要从Java中创建（如复杂对象，从属性文件或这数据库中读取对象），可以使用Data Provider来给需要的测试提供参数。所谓数据提供者，就是一个能返回对象数组的方法，并且这个方法被@Data Provider注解标注

### TestNG顺序执行
TestNG默认执行顺序是以方法名称首字母

`@Test`注解中的参数`priority`指定的数字由小到大执行

### TestNG的配置
在工程的main/resources目录下创建一个testng.xml文件，进行配置

配置执行方式：鼠标在配置文件（xxx.xml）右击 --> 点击【Run】

#### TestNG的多线程配置方式
- TestNG Suite设置：`<suite name="threading" parallel="tests" thread-count="5">`
    - parallel并行模式
        - tests：TestNG会在相同的线程中运行相同<test>标记下的所有方法，但每个<test>下的方法会运行在不同的线程下。
        - methods：TestNG会在不同的线程中运行测试方法，除非那些互相依赖的方法。那些相互依赖的方法会运行在同一个线程中，并且遵照其执行顺序。
        - classes：TestNG会在相同线程中相同类中的运行所有的方法，但是每个类都会用不同的线程运行。
    - thread-count：允许你为当前的执行指定可以运行的**线程数量**。

#### TestNG的参数化配置方式
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="params">
    <test name="test">
        <classes>
            <class name="com.test.DemoParamTest"/>

            <parameter name="name" value="张大力"/>
            <parameter name="age" value="21"/>
        </classes>
    </test>
</suite>
```
注意：parameter一般要写在class之下，不然TestNG执行无法找到参数。

#### TestNG顺序执行配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="priority">
    <test name="order">
        <classes>
            <!--指定Case顺序执行-->
            <class name="com.test.DemoOrderTest">
                <methods>
                    <include name="testB"/>
                    <include name="testA"/>
                    <include name="testC"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>
```
注意：如果priority和配置方式同时存在，最终是以priority方式进行执行

    
## TestNG实战
### 数据特性测试

- testNG数据驱动覆盖数据特性
    - 表格是解决批量编辑的好方法
    - 可以切换不同参数文件快速切换多套参数方案
    - 做到数据与逻辑分离
    
### 线程安全测试
#### 线程安全问题原理
![image-20201009130831223](https://gitee.com/JeanLv/study_image/raw/master///image-20201009130831223.png)
什么是线程安全？通俗的说，就是保证多个线程同时对某一对象进行操作时不会出错。比如两个客户端，同时对某个课程进行报名操作并记录总数，如果不加以并发控制，那么就会出现对当前报名总数脏读的情况

#### 分布式线程安全问题原理
![image-20201009130936034](https://gitee.com/JeanLv/study_image/raw/master///image-20201009130936034.png)
当服务器是分布式集群形式时，会产生一个问题，当多个订单请求打到不同的服务器上，而多个服务器对已定课程总数的读取过程中产生脏读问题，就叫做分布式锁问题

线程安全性问题出现的三个必要条件
1. 多线程环境下
2. 多个线程共享同一个资源
3. 对资源进行非原子性操作

#### testNG构建线程安全场景
当多个线程同时对某一对象进行读写操作是，比如读减库存，排重写入逻辑需要注意线程安全和分布式锁问题，需要对读写操作进行一个分布式的并发场景

注意：测试环境的单点（在测试环境中不易发现分布式锁），线上环境的集群

### 并发场景测试案例
![image-20201009131010652](https://gitee.com/JeanLv/study_image/raw/master///image-20201009131010652.png)
并发场景与性能测试的区别

|-|性能测试|并发场景测试|
|---|---|---|
|关注点|性能指标|功能正常|
|测试时机|较晚|较早|

#### testNG构建并发场景

### 数据库锁
#### 数据库锁原理
1. 表锁定：更新/删除操作会添加排它锁。此类操作的where条件如果未添加索引会升级表级锁定，导致其他逻辑对该表的操作失败
2. 事务中死锁：两个事务都持有对方需要的锁，并且在等待对方释放，并且双方都不会释放自己的锁

#### 数据库锁案例分析
当我们在进行混合场景测试时，发现当分发任务执行时，会有大量的线索收集操作大量超时报错，最后经排查是因为**更新分发结果逻辑包含未加索引的检索条件后升级为表锁**，导致新线索的插入操作超时报错

#### testNG构建场景