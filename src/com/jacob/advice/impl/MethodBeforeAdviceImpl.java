package com.jacob.advice.impl;

import com.jacob.advice.MethodBeforeAdvice;

/**
 * 一个前置通知的具体实现类
 */
public class MethodBeforeAdviceImpl extends MethodBeforeAdvice {
    @Override
    public void preMethod() {
        System.out.println("这是一条前置通知");
    }
}
