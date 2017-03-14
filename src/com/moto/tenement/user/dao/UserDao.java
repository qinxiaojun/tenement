package com.moto.tenement.user.dao;

import java.util.List;
import java.util.Map;

import com.moto.tenement.user.model.User;

public interface UserDao {
	/**
	 * ��¼
	 * @return
	 */
	User login(String username,String password);
	
	/**
	 * ��ȡ�û��б�
	 * @param queryMode 0:���ٲ�ѯ 1:ģ����ѯ
	 * @return
	 */
	List<User> getUsers(String name,int queryMode);
	
	/**
	 * ɾ���û�
	 * @return
	 */
	Boolean deleteUser(String userid);
	
	/**
	 * �༭�û���Ϣ
	 * @param user
	 * @return
	 */
	Boolean updateUser(Map<String, String[]> user);
	
	/**
	 * �����û�
	 * @param user
	 * @return �û�id
	 */
	String addUser(User user);
}
