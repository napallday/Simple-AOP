package com.jacob.advice;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 前置方法的接口
 */
public abstract class MethodBeforeAdvice implements MethodInterceptor {
    public abstract void preMethod();

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        preMethod();
        Object result = methodProxy == null ? method.invoke(object, args) : methodProxy.invokeSuper(object, args);
        return result;
    }
}
