package com.moto.component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class SessionHelper {
	
	public static Map<String,String[]> generate(HttpServletRequest request,Map<String,String[]> map)
	{
		Map<String,String[]> newMap =new HashMap<String,String[]>();
		String userid = (String)request.getSession().getAttribute("userid");
		String nickname = (String)request.getSession().getAttribute("nickname");
		newMap.putAll(map);
		newMap.put("creatorid", new String[]{userid});
		newMap.put("creator", new String[]{nickname});
		newMap.put("creatdate", new String[]{DateUtil.toString(new Date())});
		return newMap;
	}
}
