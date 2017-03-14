package com.moto.tenement.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moto.component.Constants;
import com.moto.component.JsonUtil;
import com.moto.component.Reflection;
import com.moto.tenement.user.model.User;
import com.moto.tenement.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	protected UserService userService;
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.login(username, password);
		if(user != null)
		{
			request.getSession().setAttribute("userid", user.getId());
			request.getSession().setAttribute("nickname", user.getNickname());
			return JSONObject.fromObject(user).toString();
		}
		else
			return Constants.UNAME_PWD_ERROR;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String getUsers(HttpServletRequest request)
	{
		String name = request.getParameter("name");
		String queryMode = request.getParameter("queryMode");
		
		List<User> users = userService.getUsers(StringUtils.isEmpty(name)?"":name, StringUtils.isEmpty(queryMode)?0:Integer.parseInt(queryMode));
		return JSONArray.fromObject(users).toString();
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public String addUser(HttpServletRequest request)
	{
		Map<String, String[]> map = request.getParameterMap();
		Map<String,String> m =new HashMap<String,String>();
		try {
			User user = (User)Reflection.setObjectValue(User.class.getName(), map);
			user.setId(UUID.randomUUID().toString());
			String id = userService.addUser(user);
			m.put("result", "success");
			m.put("id", id);
		} catch (Exception e) {
			m.put("result", "fail");
			m.put("describe", e.getMessage());
		}
		return JsonUtil.toJsonString(m);
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String updateUser(HttpServletRequest request)
	{
		Map<String, String[]> map = request.getParameterMap();
		
		return JsonUtil.toJsonString(userService.updateUser(map));
	}
	
	@ResponseBody
	@RequestMapping("/remove")
	public String deleteUser(HttpServletRequest request)
	{
		return JsonUtil.toJsonString(userService.deleteUser(request.getParameter("userid")));
	}
}
