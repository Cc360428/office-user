package com.office.user.utils;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
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
     * 获取随机的盐值
     *
     * @return 返回随机盐
     */
    public static String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 加密
     *
     * @param str 加密的字符串
     * @return 返回加密后的密文
     */
    public static String getMD5(String str) {
        String base = str;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /**
     * 密文密码与密文盐值一起加密
     *
     * @param passwordMD5 密文密码
     * @param slatMD5     密文盐值
     * @return 密文
     */
    public static String encrypt(String passwordMD5, String slatMD5) {
        try {
            String passwordAndSlatMD5 = passwordMD5 + slatMD5;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(passwordAndSlatMD5.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
