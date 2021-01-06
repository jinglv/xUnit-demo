package com.test;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;

import java.util.Comparator;

/**
 * 自定义排序方式：根据参数计数的顺序
 *
 * @author jingLv
 * @date 2020/10/28
 */
public class ParameterCountOrder implements MethodOrderer {

    private final Comparator<MethodDescriptor> comparator = Comparator.comparingInt(md -> md.getMethod().getParameterCount());

    @Override
    public void orderMethods(MethodOrdererContext methodOrdererContext) {
        methodOrdererContext.getMethodDescriptors().sort(comparator.reversed());
    }
}
