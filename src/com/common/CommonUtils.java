package com.common;

import java.io.UnsupportedEncodingException;


/**
 * 请增加注释
 */
public class CommonUtils {
	
	/**
	 * TRIM 将字符串对象去空格或者NULL对象变""
	 * @param str String对象.
	 * @return trim() 2010.7.23 增加判断 字符串 "null"也返回空串
	 * @author 作者
	 * @date 日期
	 */
	public static String trim(String str) {
		if (str == null || "null".equals(str)) {
			str = "";
		}
		return str.trim();
	}
	

	/**
	 * HTTP协议传参时,以UTF-8解析
	 * @param name
	 * @param request
	 * @return
	 * @author 作者
	 * @date 日期
	 */
	public static String getPar8(String val) {
		try {
			val = trim(val);
			val = java.net.URLDecoder.decode(val, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			val = "";
		}
		return val;
	}
}
