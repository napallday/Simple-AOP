package com.jacob.aop;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Proxy;

/**
 * 生产代理对象的类
 */
public class ProxyFactoryBean {
    private Object target;
    private String proxyInterface;
    private MethodInterceptor interceptor;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setProxyInterface(String proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    public void setInterceptor(MethodInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Object createProxy() {
        if(!StringUtils.isEmpty(proxyInterface)){
            // 有接口参数，采用JDK动态代理
            return JDKCreateProxy();
        }
        //没有接口参数，用CGLib代理
        return CGLibcreateProxy();
    }

    private Object JDKCreateProxy() {

        Class<?> clazz;
        try {
            clazz = Class.forName(proxyInterface);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("接口参数错误：" + proxyInterface);
        }

        Object newProxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{clazz}, (proxy, method, args) -> {
                    Object object = interceptor.intercept(target, method, args, null);
                    return object;
                });
        return newProxyInstance;

    }

    private Object CGLibcreateProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(interceptor);
        return enhancer.create();
    }

}
