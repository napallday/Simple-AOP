package com.jacob.dao;

public interface UserDao {
	void insert(String user);

	String selectOne(int id);
}