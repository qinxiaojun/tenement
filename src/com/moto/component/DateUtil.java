package com.moto.component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	public static Timestamp toTimeStamp(String date)
	{
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
        try {  
            ts = Timestamp.valueOf(date);  
            return ts;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        }  
	}
	
	public static String tsToString(Timestamp timestamp)
	{
        String tsStr = "";  
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        try {  
            tsStr = sdf.format(timestamp);  
           return tsStr;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return "";
        }  
	}
}
