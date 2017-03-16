package com.moto.tenement.dictionary.dao;

import java.util.List;

import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;

public interface DictionaryDao {
	
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
}
