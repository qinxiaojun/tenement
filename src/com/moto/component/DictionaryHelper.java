package com.moto.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * 数据字典帮助类
 * @author qinxiaojun
 */
@Component
@Qualifier("dictionaryHelper")
public class DictionaryHelper {
	
	@PersistenceContext
	protected EntityManager em;
	
	/**字典类型代码:学制*/
	public static String SCHOOL_SYS = "SCHOOL_SYS";
	/**字典类型代码:学校*/
	public static String SCHOOL = "SCHOOL";
	/**字典类型代码:渠道*/
	public static String CHANNEL = "CHANNEL";
	
	/**
	 * 获取用户信息页面上的字典列表
	 * @return
	 */
	public List getUserDicList()
	{
		List<Map> result =new ArrayList<Map>();
		Map<String,Object> dicMap = new HashMap<String,Object>();
		String sql = "select dt.text typeText,di.text itemText,di.sort,di.id itemId,dt.code from dictionary_type dt left join dictionary_item di "
				+ "on dt.id = di.type_id where dt.code in ('"+SCHOOL_SYS+"','"+SCHOOL+"','"+CHANNEL+"') "
			    + "order by dt.code,di.sort";
		List<Object[]> list = em.createNativeQuery(sql).getResultList();
		List<Map> tempList =new ArrayList<Map>();
		
		for(int i =0 ;i<list.size(); i++)
		{
			Object[] obj = list.get(i);
			
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("itemText", obj[1]);
			map.put("sort", obj[2]);
			map.put("itemId", obj[3]);
			tempList.add(map);
			
			if(i+1 == list.size()|| (!obj[4].toString().equals(list.get(i+1)[4].toString())))
			{
				List<Map> temp =new ArrayList<Map>();	
				Map tempMap =new HashMap();
				tempMap.put("code",obj[4]);
				tempMap.put("typeText",obj[0]);
				temp.addAll(tempList);
				tempMap.put("item",temp);
				result.add(tempMap);
				tempList.clear();
			}
		}
		return result;
	}
}
