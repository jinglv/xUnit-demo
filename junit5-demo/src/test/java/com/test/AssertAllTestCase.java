package com.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jingLv
 * @date 2020/10/28
 */
@Nested
@DisplayName("分组校验测试")
class AssertAllTestCase {

    @Test
    @DisplayName("传统验证方式")
    void standardAssertions() {
        assertEquals(2, 2);
        assertEquals(4, 4, "The optional assertion message is now the last parameter.");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- to avoid constructing complex messages unnecessarily.");
    }

    @Test
    @DisplayName("分组批量验证")
    void groupedAssertions() {
        //分组中的所有断言均会执行，并体现在测试报告中
        Person person = new Person().getDefaultPerson();
        assertAll("person",
                () -> assertEquals("John", person.getFirstName()),
                () -> assertEquals("Huang", person.getLastName())
        );
    }

    @Test
    @DisplayName("多级分组批量验证-依赖其他断言")
    void dependentAssertions() {
        //分组验证，分组中的断言互相不产生影响，所有断言都会被验证
        Person person = new Person().getDefaultPerson();
        assertAll("properties",
                () -> {
                    //分组外先执行失败的断言，会阻塞后续断言的执行，但不影响组外的断言
                    String firstName = person.getFirstName();
                    assertNull(firstName);

                    //仅当同级上一条断言执行成功执行
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("n"))
                    );
                },
                //多级分组
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    //仅当同级中上一条断言执行成功执行
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("g"))
                    );
                }
        );
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person getDefaultPerson() {
        return new Person("Xiaohong", "Huang");
    }
}


