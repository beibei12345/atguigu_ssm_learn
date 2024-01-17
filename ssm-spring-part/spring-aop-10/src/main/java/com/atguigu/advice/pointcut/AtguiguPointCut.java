package com.atguigu.advice.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class AtguiguPointCut {
    @Pointcut(value = "execution(public int com.atguigu.service.impl.CalculatorPureImpl.*(int, int))")
    public void declarePointCut(){}

    @Pointcut(value = "execution(public String com.atguigu.service.ASimpleService.simpleService(String,String,String))")
    public void transactionPoint(){}
}
