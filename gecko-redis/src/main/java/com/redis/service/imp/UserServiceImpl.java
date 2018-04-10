package com.redis.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.redis.dao.UserDao;
import com.redis.model.User;
import com.redis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	@Override
	public User selectUserById(int id) {
		return userDao.selectUserById(id);
	}

}
