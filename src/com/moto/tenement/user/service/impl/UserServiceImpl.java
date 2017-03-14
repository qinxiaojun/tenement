package com.moto.tenement.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.tenement.user.dao.UserDao;
import com.moto.tenement.user.model.User;
import com.moto.tenement.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	protected UserDao dao;

	@Override
	public User login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public List<User> getUsers(String name, int queryMode) {
		// TODO Auto-generated method stub
		return dao.getUsers(name, queryMode);
	}

	@Override
	public Boolean deleteUser(String userid) {
		// TODO Auto-generated method stub
		return dao.deleteUser(userid);
	}

	@Override
	public Boolean updateUser(Map<String, String[]> user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}
}
