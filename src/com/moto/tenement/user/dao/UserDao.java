package com.moto.tenement.user.dao;

import java.util.List;
import java.util.Map;

import com.moto.tenement.user.model.User;

public interface UserDao {
	/**
	 * 登录
	 * @return
	 */
	User login(String username,String password);
	
	/**
	 * 获取用户列表
	 * @param queryMode 0:快速查询 1:模糊查询
	 * @return
	 */
	List<User> getUsers(String name,int queryMode);
	
	/**
	 * 删除用户
	 * @return
	 */
	Boolean deleteUser(String userid);
	
	/**
	 * 编辑用户信息
	 * @param user
	 * @return
	 */
	Boolean updateUser(Map<String, String[]> user);
	
	/**
	 * 新增用户
	 * @param user
	 * @return 用户id
	 */
	String addUser(User user);
}
