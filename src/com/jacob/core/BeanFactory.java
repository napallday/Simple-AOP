package com.jacob.core;

public interface BeanFactory {
	/**
	 * 根据name返回bean对象
	 */
	Object getBean(String name);
}
