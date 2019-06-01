package com.office.user.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Help {

    public static String date() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return df.format(new Date());
    }
}
