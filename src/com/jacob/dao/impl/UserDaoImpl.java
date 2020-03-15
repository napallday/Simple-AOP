package com.jacob.dao.impl;

import com.jacob.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void insert(String user) {
        System.out.println("对User:" + user + "执行了插入操作...");
    }

    @Override
    public String selectOne(int id) {
        System.out.println("查询了id为" + id + "的User");
        return "success";
    }
}