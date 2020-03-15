package com.jacob.aop;

import com.jacob.core.BeanFactory;
import com.jacob.core.ClassPathXmlApplicationContext;
import com.jacob.dao.UserDao;
import com.jacob.dao.impl.UserDaoImpl;
import org.junit.Test;

public class TestAOP {
    /**
     * 测试JDK动态代理
     */
    @Test
    public void testCreateNewProxy() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao userDao = (UserDao) beanFactory.getBean("userDaoProxy");
        userDao.insert("Jacob");
        System.out.println();
        userDao.selectOne(1);
        System.out.println(userDao.getClass());
    }
}
