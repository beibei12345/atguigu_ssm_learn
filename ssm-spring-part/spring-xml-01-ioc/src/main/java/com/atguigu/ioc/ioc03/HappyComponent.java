package com.atguigu.ioc.ioc03;

public class HappyComponent implements A{
    //默认包含无参数构造函数
    private String identfier;

    public void setIdentfier(String identfier) {
        this.identfier = identfier;
    }

    @Override
    public void doWork() {
        System.out.println("HappyComponent.doWork: " + identfier);
    }
}
