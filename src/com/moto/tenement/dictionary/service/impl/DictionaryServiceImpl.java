package com.moto.tenement.dictionary.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.tenement.dictionary.dao.DictionaryDao;
import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;
import com.moto.tenement.dictionary.service.DictionaryService;

@Service("dicService")
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dao;
	@Override
	public List<DictionaryType> getDicList(String dicType) {
		return dao.getDicList(dicType);
	}
	@Override
	public List<DictionaryItem> getDicItemList(String typeid) {
		// TODO Auto-generated method stub
		return dao.getDicItemList(typeid);
	}
	@Override
	public String addDicType(DictionaryType dt) {
		// TODO Auto-generated method stub
		return dao.addDicType(dt);
	}
	@Override
	public String addDicItem(DictionaryItem di) {
		// TODO Auto-generated method stub
		return dao.addDicItem(di);
	}
	@Override
	public boolean updateDicType(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return dao.updateDicType(map);
	}
	@Override
	public boolean deleteDicType(String id) {
		// TODO Auto-generated method stub
		return dao.deleteDicType(id);
	}
	@Override
	public boolean updateDicItem(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return dao.updateDicItem(map);
	}
	@Override
	public boolean deleteDicItem(String id) {
		// TODO Auto-generated method stub
		return dao.deleteDicItem(id);
	}

}
