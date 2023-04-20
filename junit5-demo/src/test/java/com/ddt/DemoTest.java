package com.ddt;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 数据驱动
 *
 * @author jinglv
 * @date 2023/4/17 15:18
 */
public class DemoTest {

    @ParameterizedTest
    @MethodSource
    void testDDTFromYaml(User user) {
        assertTrue(user.getName().length() > 3);
    }

    static List<User> testDDTFromYaml() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        User user = new User();
        System.out.println(user.toYaml());
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
        };
        List<User> users = mapper.readValue(
                DemoTest.class.getResourceAsStream("/user.yaml"),
                typeReference
        );
        return users;
    }

    @ParameterizedTest
    @MethodSource
    void testDDTFromJson(User user) {
        assertTrue(user.getName().length() > 3);
    }

    static List<User> testDDTFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        System.out.println(user.toYaml());
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
        };
        List<User> users = mapper.readValue(
                DemoTest.class.getResourceAsStream("/user.json"),
                typeReference
        );
        return users;
    }
}
