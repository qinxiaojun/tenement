package com.moto.tenement.dictionary.service;

import java.util.List;
import java.util.Map;

import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;

public interface DictionaryService {
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
	
	/**
	 * �޸��ֵ�����
	 * @param map
	 * @return
	 */
	boolean updateDicType(Map<String, String[]> map);
	
	/**
	 * ɾ���ֵ�����
	 * @param id
	 * @return
	 */
	boolean deleteDicType(String id);
	
	/**
	 * �޸��ֵ�������Ŀ
	 * @param map
	 * @return
	 */
	boolean updateDicItem(Map<String, String[]> map);
	
	/**
	 * ɾ���ֵ�������Ŀ
	 * @param id
	 * @return
	 */
	boolean deleteDicItem(String id);
}
