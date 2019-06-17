package com.office.user.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

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

    /**
     * 判断是手机号码是否合法
     *
     * @param mobile
     * @return
     */
    public static Boolean mobile(String mobile) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        return p.matcher(mobile).matches();
    }


    /**
     * 判断输入两次输入的密码是否一致和符合标准
     *
     * @param password
     * @param confirmPassword
     * @return
     */
    public static Boolean confirmPasswords(String password, String confirmPassword) {
        if (password.length() >= 6 && confirmPassword.length() >= 6) {
            if (password.equals(confirmPassword)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 获取随机的盐值 @return
     */
    public static String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 获取加密后的密码
     *
     * @param src  原密码
     * @param salt 盐值
     * @return 加密后的密码
     */
//    private String getEncrpytedPassword(String src, String salt) {
//        /* 将原密码加密 */
//        String s1 = md5(src);
//        /* 将盐加密 */
//        String s2 = md5(salt);
//        String s3 = s1 + s2;
//        String result = md5(s3);
//        return result;
//    }
}
