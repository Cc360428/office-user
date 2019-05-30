package com.office.user.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegixUtils {

	/**
	 * 获取正则匹配的值
	 * @author Cc
	 * @time 2019年5月30日 下午2:39:57
	 * @param content 字符串
	 * @param regix 正则规则
	 * @param num 匹配的group下标
	 * @return
	 */
	public static String match(String content,String regix,int num){
		Pattern r = Pattern.compile(regix);
	    // 现在创建 matcher 对象
		Matcher m = r.matcher(content);
		if (m.find()) {
			return m.group(num);
		}
		return "";
	}
	
}
