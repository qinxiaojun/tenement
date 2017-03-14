package com.moto.tenement.dictionary.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.moto.tenement.dictionary.dao.DictionaryDao;
import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;

@Repository
public class DictionaryDaoImpl implements DictionaryDao{

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
		String sql="select d from DictionaryItem d where d.typeId =?1";
		
		return em.createQuery(sql).setParameter(1, typeid).getResultList();
	}

	@Transactional
	@Override
	public String addDicType(DictionaryType dt) {
		em.persist(dt);
		return dt.getId();
	}
	
	
}
