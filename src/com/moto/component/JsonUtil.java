package com.moto.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moto.tenement.dictionary.model.DictionaryType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	
	public static String toJsonString(String str)
	{
		JSONObject jo =new JSONObject();
		jo.put("result", str);
		return jo.toString();
	}
	
	public static String toJsonString(Boolean str)
	{
		JSONObject jo =new JSONObject();
		jo.put("result", str);
		return jo.toString();
	}
	
	public static String toJsonString(List list)
	{
		return toJsonString(JSONArray.fromObject(list).toString());
	}
	
	public static String toJsonString(Map map)
	{
		JSONObject jo =new JSONObject();
		jo.putAll(map);
		return jo.toString();
	}
	
	public static void main(String[] args)
	{
		Map map =new HashMap();
		map.put("id", "123");
		map.put("result", "success");
		System.out.println(DictionaryType.class.getName());
		System.out.println(toJsonString(map));
	}
}
