package com.liyiruo.proxy;

import java.lang.reflect.Proxy;

/**
 * jdk 动态代理
 * @author liyiruo
 */
public class ProxyFactory {
    public static <T> T getProxyInstance(Class<T> classInstance) {
        return (T) Proxy.newProxyInstance(
                ProxyFactory.class.getClassLoader(),
                new Class[]{classInstance},
                new RPCInvocationHandler());
    }
}
