package com.moto.component;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class DaoComponent {
	@PersistenceContext
	protected EntityManager em;
	
	@Transactional
	public boolean delete(String id,Class cla)
	{
		String sql ="delete from "+cla.getTypeName()+" d where d.id =?1";
		int result = em.createQuery(sql).setParameter(1, id).executeUpdate();
		return result > 0 ? true : false;
	}
	
	@Transactional
	public boolean update(Map<String, String[]> map,String tableName)
	{
		Iterator<String> iterator = map.keySet().iterator();
		String sql="update "+tableName+" set ";
		while(iterator.hasNext())
		{
			String key = iterator.next();
			if("id".equals(key))
				continue;
			sql += key+"='"+map.get(key)[0]+"' , ";
		}
		sql = sql.substring(0, sql.length()-2);
		sql += "where id='"+map.get("id")[0]+"'";;
		int result = em.createNativeQuery(sql).executeUpdate();
		return result > 0 ? true : false;
	}
}
