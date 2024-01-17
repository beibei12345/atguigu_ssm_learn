package com.atguigu.ioc.ioc01;

public class ClientService {
    private static ClientService clientService = new ClientService();
    private static Integer innerCount = 0;
    private ClientService(){

    }

    public void clientDoWork(){
        System.out.println("client do work ...");
    }

    public static ClientService createInstance(){
        // System.out.println("createInstance被调用了");
        return clientService;
    }

    public static String generateOtherType(){
        return new String("测试字符串");
    }

    public static String generateStrings(){
        innerCount++;
        return new String("测试字符串: " + innerCount);
    }
}
