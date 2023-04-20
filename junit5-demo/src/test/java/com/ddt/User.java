package com.ddt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

/**
 * @author jinglv
 * @date 2023/4/17 15:19
 */
@Data
public class User {
    private String name;

    public String toYaml() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.writeValueAsString(this);
    }
}
