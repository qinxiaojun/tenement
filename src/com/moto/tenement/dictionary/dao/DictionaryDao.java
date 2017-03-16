package com.moto.tenement.dictionary.dao;

import java.util.List;

import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;

public interface DictionaryDao {
	
	/**
	 * �����ֵ��������Ʋ�ѯ�б�
	 * @param dicType
	 * @return
	 */
	List<DictionaryType> getDicList(String dicType);
	
	/**
	 * ��������id��ȡ�����б�
	 * @param typeid
	 * @return
	 */
	List<DictionaryItem> getDicItemList(String typeid);
	
	/**
	 * �����ֵ�����
	 * @return ����id
	 */
	String addDicType(DictionaryType dt);
	
	/**
	 * �����ֵ�����
	 * @param di
	 * @return
	 */
	String addDicItem(DictionaryItem di);
}
