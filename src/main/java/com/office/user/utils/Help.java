package com.office.user.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 帮助类
 */
public class Help {
    /**
     * 时间
     *
     * @return 字符串
     */
    public static String date() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String d = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return d;
    }

    /**
     * 生成6位随机数
     *
     * @return 返回随机数
     */
    public static String randomCode() {
        Integer res = (int) (Math.random() * 1000000);
        return res.toString();
    }

}
