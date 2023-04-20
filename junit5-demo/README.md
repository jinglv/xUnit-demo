# Junit5介绍

## Junit5组成

Junit5 由**JUnit Platform + JUnit Jupiter + JUnit Vintage** 三部分构成

<img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304171418055.png" alt="image-20230417141819893" style="zoom:50%;" />

### JUnit Platform

其主要作用是在JVM上启动测试框架。它定义了一个抽象的TestEngine API来定义运行在平台上的测试框架；也就是说其他的自动化测试引擎或开发人员自己定制的引擎都可以接入Junit实现对接和执行。同时还支持通过命令行、Gradle和Maven来运行平台（这对于我们做自动化测试至关重要）。  

### JUnit Jupiter

这是Junit5的核心，可以看作是承载Junit4原有功能的演进，包含了JUnit 5最新的编程模型和扩展机制；很多丰富的新特性使JUnit自动化测试更加方便、功能更加丰富和强大。也是测试需要重点学习的地方；Jupiter本身也是一个基于Junit Platform的引擎实现，对JUnit 5而言，JUnit Jupiter API只是另一个API！。

### JUnit Vintage

Junit发展了10数年，Junit 3和 Junit 4都积累了大量的用户，作为新一代框架，这个模块是对JUnit3，JUnit4 版本兼容的测试引擎，使旧版本junit的自动化测试脚本也可以顺畅运行在Junit5下，它也可以看作是基于Junit Platform实现的引擎范例。



## 引入依赖

```xml
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.9.2</version>
            <scope>test</scope>
        </dependency>

        <!--执行-->
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-runner</artifactId>
            <version>1.9.2</version>
            <scope>test</scope>
        </dependency>

        <!--命令行启动-->
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-launcher</artifactId>
            <version>1.9.2</version>
            <scope>test</scope>
        </dependency>
```





## JUnit5套件执行

- @RunWith(JUnitPlatform.class)
    - @SelectPackages({"com.packageA", "com.packageB"})
    - @IncludePackages("包名")
    - @SelectClasses({xx.class, xx.class, xxx.class})
    - @IncludeTags("production")
    - @ExcludeTags("PROD")

```java

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.packageA", "com.packageB"})
class SuiteDemoTest {

}
```



## JUnit5实战

在得到需求后，我们需要进行任务拆解，从以下进行分析：

- 分析被测功能，梳理出主要功能点
- 通过有效途径，模拟用户行为对主要功能点进行操作
- 操作结果要有反馈，并能够通过反馈判断逻辑正确性

**问题1： 虽然自动化脚本能跑起来了，但是结果还是需要专门安排人员进行检查，大家认为这自动化并没有什么卵用**

问题原因：脚本只进行了操作和结果输出没有对结果进行校验

解决思路：需要让脚本自动判断操作结果是否正确，这样就不需要人工对结果进行校验了

实施方案：可以通过JUnit提供的assertEquals()方法对结果进行校验

**问题2：有个一方法存在多个断言，但是其中一个断言失败了，后面的断言都没有执行，
难道我们要等第一个问题修复好了才能继续检查后面的断言么?**

问题原因：因为原来使用的是JUnit5的普通断言，当一个断言失败会直接跳出测试方法，导致后面的断言无法执行，此时的脚本容错性较低

解决思路：

- 拆开多个测试方法，每个测试方法进行一个断言。（会造成大量重复发码，此方法被否）
- 使用软断言（TestNG提出），即使一个断言失败，仍会进行余下的断言，然后统一输出所有断言结果

实施方案：使用JUnit5提供的java 8 lambdas的断言方法，当一个断言失败，剩下的断言依然会执行，脚本容错性增强

**问题3：脚本执行没问题，突然要加一个公共操作，但是每个测试方法加一个，那也太傻了，赶紧优化！**

问题原因：

- 有些公共操作会在特定的时机重复进行操作，但是脚本没有分层
- 导致代码重复问题

解决思路：如果能够像面向切面编程一样标记一个方法，它就会在合适的时机执行，就能解决这个问题了

实施方案：经过查阅资料发现原来使用JUnit的Test Fixture（测试装置）能够解决这个问题 -- JUnit5 BeforeEach每个方法之前执行

**问题4：核心项目多次出现线上问题，但是测试环境无法复现，领导甚至开始怀疑团队的工作能力**

问题原因：测试环境基本上都是单线程操作，而线上存在分布式并发场景，所以并不能暴露所有问题

解决思路：需要在测试环境构建与线上相同的并发场景

实施方案：JUnit5提供了并发解决方案，可以在测试环境模拟并发场景

### 线程安全测试案例

- 案例背景

  <img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304181800903.png" alt="image-20230418180034611" style="zoom:67%;" />

  <img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304181809571.png" alt="image-20230418180913532" style="zoom:50%;" />

- 线程安全问题原理

  - 什么是线程安全？通俗的说，就是保证多个线程同时对某个一对像进行操作时不会出错。比如两个客户端，同时对某个课程进行报名操作并记录总数，如果不加以并发控制，那么就会出现对当前报名总数脏的的情况。（单实例）

    <img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304181815178.png" alt="image-20230418181529134" style="zoom:50%;" />

- 问题

  - 当服务器是分布式集群形式，会产生一个问题，当多个订课请求打到不同的服务器上，而多个服务器对已定课程总数的读取过程中产生脏读的问题，就叫分布式锁问题。

    <img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304181821700.png" alt="image-20230418182143512" style="zoom:50%;" />

- 对应案例分析

  <img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304181827006.png" alt="image-20230418182721971" style="zoom:50%;" />

  - 线程安全性问题出现的三个必要条件
    1. 多线程环境下
    2. 多个线程共享同一个资源
    3. 对资源进行非原子性操作

- 发现问题

  - 问题：在并发场景下，同一天同一个手机号被收费了两次，执行脚本，两条相同手机号的线索都被判定为收费
  - 问题说明：当多个线程同时对某一对象进行读写操作时，比如读减库存，排重写入逻辑需要注意线程安全和分布式锁问题，需要对读写操作进行一个分布式的并发场景测试。



### 线程安全问题修复思路

- Synchronized：保证方法内部或代码块内部资源（数据）的互斥访问。即同一时间、由同一个最多只能有一个线程在访问。
- java.util.concurrent.atomic：包提供了一系列AtomicBoolean、AtomicInteger、AtomicLong等类。使用这些类来声明变量可以保证对其操作具有原子性来保证线程安全。



### 混合并发场景测试案例

<img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304191559069.png" alt="image-20230419155919021" style="zoom: 67%;" />

当我们在进行混合场景测试时，<u>发现当分发任务执行时，会有大量的线索收集操作超时报错</u>（开启分发任务时，使用脚本请求构建程序线索收集场景，多种操作对同一张数据表进行操作），最后经排查是因为**更新分发结果逻辑包含未加索引的检索条件后升级为表锁**，导致新线索的插入操作超时报错。

当多个逻辑之间存在某些互相影响的可能性时，需要考虑这些逻辑混合并发处理的场景。



## 分布式锁实现（额外小话题）

分布式锁是一个分布式系统中的同步机制，用于协调不同进程或节点之间对共享资源的访问控制。以下是几种实现分布式锁的方法：

1. 基于数据库：使用数据库中的表来存储锁信息，每个进程或节点在试图获取锁时，需要向数据库中插入一条记录，如果已经存在该记录，则表示锁已经被其他进程或节点占用。当进程或节点释放锁时，需要删除该记录。

2. 基于缓存：使用分布式缓存如Redis来存储锁信息。每个进程或节点在试图获取锁时，在缓存中设置一个带有过期时间的键值对，如果该键值对已经存在，则表示锁已经被其他进程或节点占用。当进程或节点释放锁时，需要删除该键值对。

3. 基于ZooKeeper：ZooKeeper是一个高性能的分布式协调服务，可以用来实现分布式锁。每个进程或节点在试图获取锁时，在ZooKeeper上创建一个临时顺序节点，并检查自己是否是最小的序号节点。如果是，则表示该进程或节点获得了锁；否则则需要等待其他序号更小的进程或节点释放锁。

4. 基于文件系统：使用共享文件系统如NFS来实现分布式锁。每个进程或节点在试图获取锁时，在共享目录下创建一个带有唯一名称的文件，如果该文件已经存在，则表示锁已经被其他进程或节点占用。当进程或节点释放锁时，需要删除该文件。

无论采用哪种方法实现分布式锁，都需要考虑如何处理死锁、重入、超时等问题



## 并发场景与性能测试的区别

|          | 性能测试 | 并发场景测试 |
| -------- | -------- | ------------ |
| 关注点   | 性能指标 | 功能正常     |
| 测试时机 | 较晚     | 较早         |

<img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304191519806.png" alt="image-20230419151921649" style="zoom: 67%;" />



## 数据库锁原理

1. 表锁定：更新/删除操作会添加**排它锁**。此类操作的where条件如果未添加索引会升级为表级锁定，导致其他逻辑对该表的操作失败。注意：删除、更新后面的where条件的字段是要有索引（MySQL的行锁、排它锁是建立的索引上的）

   当MySQL执行UPDATE、DELETE、SELECT ... FOR UPDATE等语句时，会自动给涉及到的行加上行锁或排它锁。如果没有合适的索引，MySQL会对整张表加锁，导致性能下降。因此，在设计MySQL数据库时，需要合理地选择索引来提高查询效率并减少锁的冲突。

2. 事务中的死锁：两个事务都持有对方需要的锁，并且在等待对方释放，并且都不会释放自己的锁。

<img src="https://jing-images.oss-cn-beijing.aliyuncs.com/img/202304191546657.png" alt="image-20230419154633609" style="zoom: 67%;" />

排它锁是一种数据库锁，用于保护数据在被一个事务修改时不被其他事务读取或修改。当一个事务获得了排它锁时，其他所有的事务都不能访问该资源，直到该事务释放了排它锁。排它锁可以防止多个并发事务同时修改同一行数据而导致的数据不一致问题。

排它锁是一种独占锁，只有持有该锁的事务可以对被锁定的资源进行修改操作。因此，在以下情况下会使用排它锁：

1. 当一个事务需要对某个资源进行写操作时，需要获取该资源的排它锁，以避免其他事务同时修改该资源。

2. 在数据表进行更新、删除和插入等操作时，需要获取该表的排它锁，以避免其他事务同时修改该表。

3. 当一个事务需要对某个范围内的数据行进行修改或其它 DML 操作时，需要获取这些数据行的排他锁。

4. 在使用 SELECT ... FOR UPDATE 时，也会自动获得被查询记录的排他锁。

总之，在需要保证数据一致性和避免并发冲突的情况下，都可能会用到排它锁。





## Allure2

### 环境准备

- 第一步：添加maven依赖

  ```xml
  <dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-junit5</artifactId>
    <version>2.21.0</version>
    <scope>test</scope>
  </dependency>
  ```

  

- 第二步：下载allure2工具并配置环境变量

  - `allure --version`查看配置是否成功

- 第三步allure2工具创建本地jetty服务实例

  - `allure serve allure-results`
