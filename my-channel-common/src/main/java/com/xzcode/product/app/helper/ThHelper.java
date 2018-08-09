package com.xzcode.product.app.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * Thymeleaf工具类
 * 
 * 
 * @author zai
 * 2018-07-04 19:23:01
 */
@Service
public class ThHelper {
	
	/**
	 * 字符串以 \n 分隔成数组
	 * @param str
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 23:39:45
	 */
	public static String[] lineSplit(String str) {
		return lineSplit(str, "\n");
	}
	
	/**
	 * 字符串分隔成数组
	 * @param str
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 23:39:45
	 */
	public static String[] lineSplit(String str, String spliter) {
		if (str == null) {
			return null;
		}
		return str.split(spliter);
	}
	
	/**
	 * 从 yyyy-MM-dd HH:mm:ss 字符串中获取 '天' 值
	 * @param datetimeStr
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 13:29:54
	 */
	public static String getStringDay(String datetimeStr) {
		if (datetimeStr == null) {
			return null;
		}
		return datetimeStr.split(" ")[0].split("-")[2];
	}
	
	/**
	 * 从 yyyy-MM-dd HH:mm:ss 字符串中获取 '月' 值
	 * @param datetimeStr
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 13:29:54
	 */
	public static String getStringMonth(String datetimeStr) {
		if (datetimeStr == null) {
			return null;
		}
		return datetimeStr.split(" ")[0].split("-")[1];
	}
	
	/**
	 * 从 yyyy-MM-dd HH:mm:ss 字符串中获取 '年' 值
	 * @param datetimeStr
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 13:29:54
	 */
	public static String getStringYear(String datetimeStr) {
		if (datetimeStr == null) {
			return null;
		}
		return datetimeStr.split(" ")[0].split("-")[0];
	}
	
	private static final String dateTimeFormatPattern    = "yyyy-MM-dd HH:mm:ss";
	private static final String dateFormatPattern = "yyyy-MM-dd";
	
	/**
	 * 默认日期与时间  "yyyy-MM-dd HH:mm:ss"
	 * @param date
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 14:16:01
	 */
	public static String dateTimeFormat(Date date) {
		return dateTimeFormat(date, dateTimeFormatPattern);
	}
	
	/**
	 * 自定义日期转换
	 * @param date
	 * @param pattern 表达式
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 14:16:50
	 */
	public static String dateTimeFormat(Date date, String pattern) {
		if (date != null) {
			return new SimpleDateFormat(pattern).format(date);			
		}
		return null;
	}
	
	/**
	 * 默认日期转换 "yyyy-MM-dd"
	 * @param date
	 * @return
	 * 
	 * @author zai
	 * 2018-07-05 14:16:32
	 */
	public static String dateFormat(Date date) {
		if (date != null) {
			return new SimpleDateFormat(dateFormatPattern).format(date);			
		}
		return null;
	}
	
	
}
