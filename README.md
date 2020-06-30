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