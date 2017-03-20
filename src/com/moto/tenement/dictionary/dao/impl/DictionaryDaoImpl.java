package com.moto.tenement.dictionary.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moto.component.DaoComponent;
import com.moto.tenement.dictionary.dao.DictionaryDao;
import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;

@Repository
public class DictionaryDaoImpl extends DaoComponent implements DictionaryDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<DictionaryType> getDicList(String dicType) {
//		String sql ="select dt.id,dt.status,dt.text,dt.code,di.id itemid," +
//				"di.sort,di.text itemText,di.value,di.type_id,di.createdate,di.creator,di.creatorid " +
//				"from dictionary_type dt left join dictionary_item di on dt.id = di.type_id ";
//		if(!StringUtils.isEmpty(dicType))
//			sql +="where dt.text ='"+dicType+"' ";
//		sql += "order by di.sort";
		String sql = "select d from DictionaryType d";
		if(!StringUtils.isEmpty(dicType))
		{
			sql+="  where d.text =?1";
			return em.createQuery(sql).setParameter(1, dicType).getResultList();
		}
		else
			return em.createQuery(sql).getResultList();
	}

	@Override
	public List<DictionaryItem> getDicItemList(String typeid) {
		String sql="select d from DictionaryItem d where d.typeId =?1 order by sort";
		
		return em.createQuery(sql).setParameter(1, typeid).getResultList();
	}

	@Transactional
	@Override
	public String addDicType(DictionaryType dt) {
		em.persist(dt);
		return dt.getId();
	}

	@Transactional
	@Override
	public String addDicItem(DictionaryItem di) {
		em.persist(di);
		return di.getId();
	}

	@Transactional
	@Override
	public boolean updateDicType(Map<String, String[]> map) {
		/*Iterator<String> iterator = map.keySet().iterator();
		String sql="update dictionary_type set ";
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
		return result > 0 ? true : false;*/
		return update(map, "dictionary_type");
	}

	@Transactional
	@Override
	public boolean deleteDicType(String id) {
		return delete(id, DictionaryType.class);
	}

	@Transactional
	@Override
	public boolean updateDicItem(Map<String, String[]> map) {
		/*Iterator<String> iterator = map.keySet().iterator();
		String sql="update dictionary_item set ";
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
		return result > 0 ? true : false;*/
		return update(map, "dictionary_item");
	}

	@Transactional
	@Override
	public boolean deleteDicItem(String id) {
		return delete(id, DictionaryItem.class);
	}
	
	
}
