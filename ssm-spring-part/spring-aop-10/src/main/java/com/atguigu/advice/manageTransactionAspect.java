package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class manageTransactionAspect {
    @Around(value = "com.atguigu.advice.pointcut.AtguiguPointCut.transactionPoint()")
    public Object doManage(ProceedingJoinPoint joinPoint){
        // 通过ProceedingJoinPoint对象获取外界调用目标方法时传入的实参数组
        Object[] args = joinPoint.getArgs();

        // 通过ProceedingJoinPoint对象获取目标方法的签名对象
        Signature signature = joinPoint.getSignature();

        // 通过签名对象获取目标方法的方法名
        String methodName = signature.getName();

        // 声明变量用来存储目标方法的返回值
        Object targetMethodReturnValue = null;

        try {

            // 在目标方法执行前：开启事务（模拟）
            System.out.println("[AOP 环绕通知] 开启事务，方法名：" + methodName + "，参数列表：" + Arrays.asList(args));

            // 过ProceedingJoinPoint对象调用目标方法
            // 目标方法的返回值一定要返回给外界调用者
            targetMethodReturnValue = joinPoint.proceed(args);

            // 在目标方法成功返回后：提交事务（模拟）
            System.out.println("[AOP 环绕通知] 提交事务，方法名：" + methodName + "，方法返回值：" + targetMethodReturnValue);

        }catch (Throwable e){

            // 在目标方法抛异常后：回滚事务（模拟）
            System.out.println("[AOP 环绕通知] 回滚事务，方法名：" + methodName + "，异常：" + e.getClass().getName());

        }finally {

            // 在目标方法最终结束后：释放数据库连接
            System.out.println("[AOP 环绕通知] 释放数据库连接，方法名：" + methodName);

        }

        return targetMethodReturnValue;
    }
}
