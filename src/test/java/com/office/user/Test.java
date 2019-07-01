package com.office.user;

import org.apache.commons.codec.binary.Hex;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.util.UUID;

public class Test {
    /**
     * 生成含有随机盐的密码
     */
    public static String generate(String password, String salt) {

        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验密码是否正确
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取随机的盐值 @return
     */
    public static String getRandomSalt() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static String getMD5(String str) {
        String base = str;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


    /**
     * 密文密码与密文盐值一起加密
     * @param passwordMD5 密文密码
     * @param slatMD5 密文盐值
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

    public static void main(String[] args) {
        String salt = "B958C1FF-A256-4B58-AABB-9C3BEC8B0EC4";
        //获取盐值加密
        String saltMD5 = "a876498addfc7177a50ef5e43ea2c411";

        String password = "123456";
        String passwordMD5 = getMD5(password);

        String p = encrypt(passwordMD5, saltMD5);

        String newPassword = "123456";
        String newPasswordMD5 = encrypt(getMD5(newPassword), saltMD5);


        if (p.equals(newPasswordMD5)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println(p);

    }
}