package com.atguigu.mytest.test;

import com.atguigu.mytest.Calculator;
import com.atguigu.mytest.CalculatorPureImpl;
import com.atguigu.mytest.proxy.ProxyFactory;

public class Test01 {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new CalculatorPureImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        //proxy.add(1, 1);
        proxy.div(1, 0);
    }
}
