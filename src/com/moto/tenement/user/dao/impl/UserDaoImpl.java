package com.moto.tenement.user.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moto.tenement.user.dao.UserDao;
import com.moto.tenement.user.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	EntityManager em;
	
	
	public User login(String username,String password){
		String sql="select u from User u where u.username=?1 and u.password=?2";
		Query query=em.createQuery(sql).setParameter(1, username).setParameter(2, password);
		try{
			Object obj = query.getSingleResult();
			return (User)obj;
		}
		catch(NoResultException e)
		{
			return null;
		}
	}


	@Override
	public List<User> getUsers(String name,int queryMode) {
		String sql = "select u from User u ";
		List<User> users;
		if(StringUtils.isEmpty(name))
			users = em.createQuery(sql).getResultList();
		else
		{
			if (queryMode == 0)
			{
				sql += "where u.nickname = '"+name+"'";
			//	query.setParameter(1,name);
			}
			else if (queryMode == 1)
			{
				sql += "where u.nickname like '"+"%"+name+"%"+"'";
		//		query.setParameter(1,"%"+name+"%");
			}
			users =em.createQuery(sql).getResultList();
		}
		return users;
	}


	@Transactional
	public Boolean deleteUser(String userid) {
		String sql = "delete from User u where u.id = ?1";
		Query query = em.createQuery(sql).setParameter(1, userid);
		int result = query.executeUpdate();
		return result > 0 ? true : false;
	}

	@Transactional
	public Boolean updateUser(Map<String, String[]> user) {
		Iterator<String> iterator = user.keySet().iterator();
		String sql="update user set ";
		while(iterator.hasNext())
		{
			String key = iterator.next();
			if("id".equals(key))
				continue;
			sql += key+"='"+user.get(key)[0]+"' , ";
		}
		sql = sql.substring(0, sql.length()-2);
		sql += "where id='"+user.get("id")[0]+"'";;
		int result = em.createNativeQuery(sql).executeUpdate();
		return result > 0 ? true : false;
	}

	@Transactional
	public String addUser(User user) {
		em.persist(user);
		return user.getId();
	}
}
