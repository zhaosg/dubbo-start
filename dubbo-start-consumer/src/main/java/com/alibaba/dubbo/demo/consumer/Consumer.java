package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.demo.DemoService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ken.lj on 2017/7/31.
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        long t0=System.nanoTime();
        int a=10000;
        for(int i=0;i<a;i++){
            String hello = demoService.sayHello("world"); // 执行远程方法
        }
        System.out.println(1/((System.nanoTime()-t0)*0.000000001/a));
        System.in.read(); // 按任意键退出

    }
}
