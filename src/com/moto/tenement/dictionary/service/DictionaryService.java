package com.moto.tenement.dictionary.service;

import java.util.List;
import java.util.Map;

import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;

public interface DictionaryService {
	/**
	 * 根据字典类型名称查询列表
	 * @param dicType
	 * @return
	 */
	List<DictionaryType> getDicList(String dicType);
	
	/**
	 * 根据类型id获取子项列表
	 * @param typeid
	 * @return
	 */
	List<DictionaryItem> getDicItemList(String typeid);
	
	/**
	 * 新增字典类型
	 * @return 类型id
	 */
	String addDicType(DictionaryType dt);
	
	/**
	 * 新增字典子项
	 * @param di
	 * @return
	 */
	String addDicItem(DictionaryItem di);
	
	/**
	 * 修改字典类型
	 * @param map
	 * @return
	 */
	boolean updateDicType(Map<String, String[]> map);
	
	/**
	 * 删除字典类型
	 * @param id
	 * @return
	 */
	boolean deleteDicType(String id);
	
	/**
	 * 修改字典类型条目
	 * @param map
	 * @return
	 */
	boolean updateDicItem(Map<String, String[]> map);
	
	/**
	 * 删除字典类型条目
	 * @param id
	 * @return
	 */
	boolean deleteDicItem(String id);
}
