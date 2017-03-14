package com.moto.component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;

public class Reflection {
	
	public static Object setObjectValue(String className,Map<String, String[]> map) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException
	{
		Iterator<String> iterator = map.keySet().iterator();
		
		
		Class<?> c = Class.forName(className);
		Method[] methods= c.getMethods();
		Object obj =c.newInstance();
		while (iterator.hasNext()) {
			String key = iterator.next().toLowerCase();
			for (Method method : methods) {
				String mName = method.getName();
				if (mName.startsWith("get") && !mName.startsWith("getClass")) {
					String fieldName = mName.substring(3, mName.length());
					if (key.equals(fieldName.toLowerCase())) 
					{
						Class<?> cla = method.getReturnType();
						c.getMethod("set"+fieldName, cla).invoke(obj,ConvertUtils.convert(map.get(key)[0], cla));
						break;
					}
				}

			}
		}
		return obj;
	}
}
