package com.dudu.soa.weixindubbo.third.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *sha加密
 */
final class AddSHA1 {
    private AddSHA1() {
    }

    /**
     * sad
     * @param inStr dsd
     * @return s
     */
    public static String shi1(String inStr) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");     //选择SHA-1，也可以选择MD5
            byte[] digest = md.digest(inStr.getBytes());       //返回的是byet[]，要转化为String存储比较方便
            outStr = bytetoString(digest);
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return outStr;
    }

    /**
     * sd
     * @param digest sd
     * @return dsd
     */
    public static String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 0; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            } else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }
}
