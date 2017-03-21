package com.moto.tenement.member.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moto.component.DictionaryHelper;
import com.moto.component.JsonUtil;

@Controller
@RequestMapping("/member")
public class MemberAction{
	
	@Autowired
	DictionaryHelper dictionaryHelper;
	
	@ResponseBody
	@RequestMapping("/dic/list")
	public String getUserDicList(HttpServletRequest request)
	{
		return JsonUtil.toJsonString(dictionaryHelper.getUserDicList());
	}
}
