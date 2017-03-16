package com.moto.tenement.dictionary.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moto.component.DateUtil;
import com.moto.component.JsonUtil;
import com.moto.component.Reflection;
import com.moto.component.SessionHelper;
import com.moto.tenement.dictionary.model.DictionaryItem;
import com.moto.tenement.dictionary.model.DictionaryType;
import com.moto.tenement.dictionary.service.DictionaryService;

@Controller
@RequestMapping("/dic")
public class DictionaryAction {
	@Autowired
	private DictionaryService dicService;
	
	@ResponseBody
	@RequestMapping("/list")
	public String getDicList(HttpServletRequest request)
	{
		String type = request.getParameter("type");
		return JsonUtil.toJsonString(dicService.getDicList(type));
	}
	
	@ResponseBody
	@RequestMapping("/item/list")
	public String getDicItemList(HttpServletRequest request)
	{
		String typeId=request.getParameter("typeId");
		return JsonUtil.toJsonString(dicService.getDicItemList(typeId));
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public String addDicType(HttpServletRequest request)
	{
		Map<String, String[]> map = request.getParameterMap();
	
		Map<String,String> m =new HashMap<String,String>();
		try {
			DictionaryType dt = (DictionaryType)Reflection.setObjectValue(DictionaryType.class.getName(), SessionHelper.generate(request, map));
			dt.setId(UUID.randomUUID().toString());
			String id = dicService.addDicType(dt);
			m.put("result", "success");
			m.put("id", id);
		} catch (Exception e) {
			m.put("result", "fail");
			m.put("describe", e.getMessage());
		}
		return JsonUtil.toJsonString(m);
	}
	
	@ResponseBody
	@RequestMapping("/item/add")
	public String addDicItem(HttpServletRequest request)
	{
		Map<String, String[]> map = request.getParameterMap();
		
		Map<String,String> m =new HashMap<String,String>();
		try {
			DictionaryItem di = (DictionaryItem)Reflection.setObjectValue(DictionaryItem.class.getName(), SessionHelper.generate(request, map));
			di.setId(UUID.randomUUID().toString());
			String id = dicService.addDicItem(di);
			m.put("result", "success");
			m.put("id", id);
		} catch (Exception e) {
			m.put("result", "fail");
			m.put("describe", e.getMessage());
		}
		return JsonUtil.toJsonString(m);
	}
}
