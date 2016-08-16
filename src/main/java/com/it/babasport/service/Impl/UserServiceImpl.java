package com.it.babasport.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.babasport.dao.UserDao;
import com.it.babasport.po.User;
import com.it.babasport.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

}
