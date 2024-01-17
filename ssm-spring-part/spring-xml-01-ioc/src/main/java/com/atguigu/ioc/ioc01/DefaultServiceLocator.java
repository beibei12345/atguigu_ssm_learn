package com.atguigu.ioc.ioc01;

public class DefaultServiceLocator {
    private static ClientServiceImpl clientService = new ClientServiceImpl();
    private static ClientServiceImpl2 clientService2 = new ClientServiceImpl2();

    private static Integer innerCount = 0;

    public ClientServiceImpl createClientServiceInstance(){
        return clientService;
    }

    public ClientServiceImpl2 createClientServiceInstance2(){
        return clientService2;
    }

    public String getString(){
        innerCount++;
        return new String("实例工厂生成的字符串：" + innerCount);
    }
}
