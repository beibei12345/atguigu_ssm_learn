package com.atguigu.ioc_02;

public class Foo {
    private static Integer count = 1;

    public Foo() {
        count++;
    }

    @Override
    public String toString() {
        return "Foo{}" + (count);
    }
}
