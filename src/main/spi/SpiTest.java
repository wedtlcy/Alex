package spi;

import java.util.ServiceLoader;

/**
 * <p>Service Provider Interface(spi)</p>
 * <p>SPI 全称为 (Service Provider Interface) ,是JDK内置的一种服务提供发现机制。
 * 目前有不少框架用它来做服务的扩展发现， 简单来说，它就是一种动态替换发现的机制，
 * 举个例子来说， 有个接口，想运行时动态的给它添加实现，你只需要添加一个实现</p>
 *
 * <href>https://www.jianshu.com/p/46aa69643c97</href>
 *
 * @author chuanyin.li
 * @create 2019-01-22 4:44 PM
 **/
public class SpiTest {

    public static void main(String[] args) {

        ServiceLoader<HelloInterface> loaders = ServiceLoader.load(HelloInterface.class);

        for (HelloInterface loader : loaders) {
            loader.sayHello();
        }
    }
}
