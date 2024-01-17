package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {


    @Before(value = "com.atguigu.advice.pointcut.AtguiguPointCut.declarePointCut()")
    public void printLogBeforeCore(JoinPoint joinPoint){
        System.out.println("[AOP前置通知]方法开始了");

        Signature signature = joinPoint.getSignature();
        System.out.println(signature);

        String methodName = signature.getName();
        System.out.println("methodName = " + methodName);

        int modifiers = signature.getModifiers();
        System.out.println("modifiers = " + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName = " + declaringTypeName);

        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));

        System.out.println("[AOP前置通知]方法开始了\n");
    }

    @AfterReturning(
            value = "com.atguigu.advice.pointcut.AtguiguPointCut.declarePointCut()",
            returning = "targetMethodReturnValue")
    public void printLogAfterSuccess(JoinPoint joinPoint, Object targetMethodReturnValue){
        System.out.println("[AOP返回通知]方法成功返回了");
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
        System.out.println("targetMethodReturnValue = " + targetMethodReturnValue);
        System.out.println("[AOP返回通知]方法成功返回了\n");
    }

    @AfterThrowing(
            value = "com.atguigu.advice.pointcut.AtguiguPointCut.declarePointCut()",
            throwing = "targetMethodException")
    public void printLogAfterException(JoinPoint joinPoint, Throwable targetMethodException){
        System.out.println("[AOP异常通知]方法抛异常了");
        String name = joinPoint.getSignature().getName();
        System.out.println(name);
        System.out.println("targetMethodException = " + targetMethodException);
        System.out.println("[AOP异常通知]方法抛异常了\n");
    }

    @After(value = "com.atguigu.advice.pointcut.AtguiguPointCut.declarePointCut()")
    public void printLogFinallyEnd(JoinPoint joinPoint){
        System.out.println("[AOP后置通知]方法最终结束了");
        System.out.println(joinPoint);
        System.out.println("[AOP后置通知]方法最终结束了");
    }
}
