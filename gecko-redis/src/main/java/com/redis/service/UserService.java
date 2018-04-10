package com.redis.service;

import com.redis.model.User;

public interface UserService {
	public User selectUserById(int id);
}
