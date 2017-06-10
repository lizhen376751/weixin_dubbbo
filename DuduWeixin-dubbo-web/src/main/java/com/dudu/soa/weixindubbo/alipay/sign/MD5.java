package com.dudu.soa.weixindubbo.alipay.sign;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * md5
 */
public final class MD5 {

    private MD5() {
    }

    /**
     * 绛惧悕瀛楃涓�
     *
     * @param text         闇�瑕佺鍚嶇殑瀛楃涓�
     * @param key          瀵嗛挜
     * @param inputCharset 缂栫爜鏍煎紡
     * @return 绛惧悕缁撴灉 string
     */
    public static String sign(String text, String key, String inputCharset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
    }

    /**
     * 绛惧悕瀛楃涓�
     *
     * @param text         闇�瑕佺鍚嶇殑瀛楃涓�
     * @param sign         绛惧悕缁撴灉
     * @param key          瀵嗛挜
     * @param inputCharset 缂栫爜鏍煎紡
     * @return 绛惧悕缁撴灉 boolean
     */
    public static boolean verify(String text, String sign, String key, String inputCharset) {
        text = text + key;
        String mysign = DigestUtils.md5Hex(getContentBytes(text, inputCharset));
        return mysign.equals(sign);
    }

    /**
     *
     * @param content 1
     * @param charset 2
     * @return 3
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5绛惧悕杩囩▼涓嚭鐜伴敊璇�,鎸囧畾鐨勭紪鐮侀泦涓嶅,鎮ㄧ洰鍓嶆寚瀹氱殑缂栫爜闆嗘槸:" + charset);
        }
    }

}
