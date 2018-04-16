package com.redis.dao;

import org.apache.ibatis.annotations.Param;

import com.redis.model.User;

public interface UserDao {
	public User selectUserById(@Param("id") int id);
}
